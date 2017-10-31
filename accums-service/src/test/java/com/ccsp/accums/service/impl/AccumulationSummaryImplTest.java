package com.ccsp.accums.service.impl;

import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.repository.LedgerEntryRepository;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.ILedgerSummaryRepository;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationSummaryImplTest {

	@InjectMocks
	private LedgerSummaryService serviceImpl;

	@Mock
	private ILedgerSummaryRepository ledgerSummaryRepository;


	@Mock
	private ILedgerHeaderRepository ledgerHeaderRepository;


	@Mock
	private LedgerSummaryMapper ledgerSummaryMapper;
	
	@Mock
	private LedgerEntryRepository ledgerEntryRepository;

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerSummaryMapper.class.getField("INSTANCE"), ledgerSummaryMapper);
		LedgerSummaryEntity accumulationSummary = new LedgerSummaryEntity();
		LedgerSummaryDTO accumulationSummaryDTO = new LedgerSummaryDTO();
		LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
		when(ledgerSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
		accumulationSummary.setLedgerHeader(ledger);
		serviceImpl.create(accumulationSummaryDTO);
		verify(ledgerSummaryRepository, times(1)).save(accumulationSummary);
	}

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetClaimLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerSummaryMapper.class.getField("INSTANCE"), ledgerSummaryMapper);
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		accumulationSummaryDTOs.add(new LedgerSummaryDTO());

		List<LedgerSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();

		for (LedgerSummaryDTO accumulationSummaryDTO : accumulationSummaryDTOs) {
			LedgerHeaderEntity ledger = new LedgerHeaderEntity();
			when(ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID())).thenReturn(ledger);
			LedgerSummaryEntity accumulationSummary = new LedgerSummaryEntity();
			when(ledgerSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
			accumulationSummary.setLedgerHeader(ledger);

			when(ledgerSummaryRepository.saveAndFlush(accumulationSummary)).thenReturn(accumulationSummary);
			when(ledgerSummaryMapper.convertToDTO(accumulationSummary)).thenReturn(accumulationSummaryDTO);
			accumulationSummaryDTOsAfterInseration.add(accumulationSummaryDTO);
		}
		List<LedgerSummaryDTO> actual = serviceImpl.create(accumulationSummaryDTOs);
		Assert.assertEquals(accumulationSummaryDTOsAfterInseration, actual);
	}

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerSummaries() throws NoSuchFieldException, SecurityException, Exception {
		List<LedgerSummaryEntity> accumulationSummaries = new ArrayList<>();
		LedgerSummaryEntity accumulationSummary = new LedgerSummaryEntity();
		accumulationSummaries.add(accumulationSummary);
		List<LedgerSummaryDTO> accumulationHeaderDTOList = new ArrayList<>();
		when(ledgerSummaryRepository.findAll()).thenReturn(accumulationSummaries);
		when(ledgerSummaryMapper.convertToDTOList(accumulationSummaries)).thenReturn(accumulationHeaderDTOList);
		setFinalStatic(LedgerSummaryMapper.class.getField("INSTANCE"), ledgerSummaryMapper);
		List<LedgerSummaryDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(accumulationHeaderDTOList, actual);
	}

	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException {
		List<LedgerSummaryEntity> accumulationSummaries = new ArrayList<>();
		when(ledgerSummaryRepository.findAll()).thenReturn(accumulationSummaries);
		serviceImpl.readAll();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {
		String subscriberId = "A0001";
		List<LedgerSummaryEntity> ledgerSummaryEntities = new ArrayList<>();
		LedgerSummaryEntity entity = new LedgerSummaryEntity();
		entity.setMemberId("A0001");
		entity.setNetworkCode("nw001");
		entity.setNetworkTier("nt001");
		entity.setAmount(100d);
		entity.setAccumType("Accum01");
		ledgerSummaryEntities.add(entity);
		when(ledgerSummaryRepository.findBySubscriberId(subscriberId)).thenReturn(ledgerSummaryEntities);
		List<LedgerHeaderEntity> ledgerHeaderEntityList = new ArrayList<>();
		LedgerHeaderEntity ledgerHeaderEntity = mock(LedgerHeaderEntity.class);
		Long mockId = 1000l;
		when(ledgerHeaderEntity.getId()).thenReturn(mockId);
		ledgerHeaderEntityList.add(ledgerHeaderEntity);
		when(ledgerHeaderRepository.findBySubscriberId(subscriberId)).thenReturn(ledgerHeaderEntityList);
		LedgerHeaderMapper headerMapper = mock(LedgerHeaderMapper.class);
		LedgerHeaderDTO ledgerHeaderDTO  = new LedgerHeaderDTO();
		setFinalStatic(LedgerHeaderMapper.class.getField("INSTANCE"), headerMapper);
		when(headerMapper.convertToDTO(ledgerHeaderEntity)).thenReturn(ledgerHeaderDTO);
		List<LedgerEntryEntity> ledgerEntryList = new ArrayList<>();	
		LedgerEntryEntity ledgerEntryEntity = new LedgerEntryEntity();
		ledgerEntryEntity.setAccumType("Accum01");
		ledgerEntryEntity.setAmount(100d);
		ledgerEntryList.add(ledgerEntryEntity);
		when(ledgerEntryRepository.findByledgerHeaderID(mockId)).thenReturn(ledgerEntryList);
		LedgerSummaryMapper summaryMapper = mock(LedgerSummaryMapper.class);
		setFinalStatic(LedgerSummaryMapper.class.getField("INSTANCE"), summaryMapper);
		when(summaryMapper.convertHeaderDTOtoEntity(ledgerHeaderDTO)).thenReturn(entity);
		serviceImpl.updateLedgerSummary(subscriberId);
		verify(ledgerSummaryRepository).save(anyCollection());
	}

	/**
	 * @param field
	 * @param newValue
	 * @throws Exception
	 */
	static void setFinalStatic(Field field, Object newValue) throws Exception {
		field.setAccessible(true);

		// remove final modifier from field
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}
}