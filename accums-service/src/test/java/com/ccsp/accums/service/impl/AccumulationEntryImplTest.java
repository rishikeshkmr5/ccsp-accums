package com.ccsp.accums.service.impl;

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

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.mapper.LedgerEntryMapper;
import com.ccsp.accums.ledger.entry.repository.ILedgerEntryRepository;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationEntryImplTest {

	@InjectMocks
	private LedgerEntryService serviceImpl;

	/**
	 * Mock the repository
	 */
	@Mock
	private ILedgerEntryRepository iLedgerEntryRepository;

	/**
	 * Mock the repository
	 */
	@Mock
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * Mock the Mapper
	 */
	@Mock
	private LedgerEntryMapper ledgerEntryMapper;

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerEntry() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerEntryMapper.class.getField("INSTANCE"), ledgerEntryMapper);
		LedgerEntryEntity accumulationEntry = new LedgerEntryEntity();
		LedgerHeaderEntity headerEntity = new LedgerHeaderEntity();
		LedgerEntryDTO accumulationEntryDTO = new LedgerEntryDTO();
		when(ledgerHeaderRepository.findOne(accumulationEntryDTO.getLedgerHeaderID())).thenReturn(headerEntity);
		when(ledgerEntryMapper.convertToEntity(accumulationEntryDTO)).thenReturn(accumulationEntry);
		when(iLedgerEntryRepository.save(accumulationEntry)).thenReturn(accumulationEntry);
		accumulationEntry.setId(10l);
		serviceImpl.create(accumulationEntryDTO);
		verify(ledgerEntryMapper, times(1)).convertToDTO(accumulationEntry);
	}

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetClaimLedgerEntry() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerEntryMapper.class.getField("INSTANCE"), ledgerEntryMapper);
		List<LedgerEntryDTO> accumulationEntryDTOs = new ArrayList<>();
		accumulationEntryDTOs.add(new LedgerEntryDTO());
		
		List<LedgerEntryEntity> accumulationEntryEntities = new ArrayList<>();
		accumulationEntryEntities.add(new LedgerEntryEntity());
		
		when(ledgerEntryMapper.convertToEntityList(accumulationEntryDTOs)).thenReturn(accumulationEntryEntities);

		List<LedgerEntryDTO> accumulationEntryDTOsAfterInseration = new ArrayList<>();

		for (LedgerEntryEntity accumulationEntryEntity : accumulationEntryEntities) {
			LedgerHeaderEntity ledger = new LedgerHeaderEntity();
			when(ledgerHeaderRepository.findOne(accumulationEntryEntity.getLedgerHeaderID())).thenReturn(ledger);
			accumulationEntryEntity.setLedgerHeader(ledger);
			
			LedgerEntryDTO ledgerEntryDTO = new LedgerEntryDTO();
			when(ledgerEntryMapper.convertToDTO(accumulationEntryEntity)).thenReturn(ledgerEntryDTO);
			accumulationEntryDTOsAfterInseration.add(ledgerEntryDTO);
		}
		
		when(iLedgerEntryRepository.save(accumulationEntryEntities)).thenReturn(accumulationEntryEntities);
		
		List<LedgerEntryDTO> actual = serviceImpl.create(accumulationEntryDTOs);
		Assert.assertEquals(accumulationEntryDTOsAfterInseration, actual);
	}
	

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	
	@Test
	public void testGetAllLedgerEntries() throws NoSuchFieldException, SecurityException, Exception {
		List<LedgerEntryEntity> ledgerEntries = new ArrayList<>();
		ledgerEntries.add(new LedgerEntryEntity());
		List<LedgerEntryDTO> accumulationEntryDTOList = new ArrayList<>();
		when(iLedgerEntryRepository.findAll()).thenReturn(ledgerEntries);
		when(ledgerEntryMapper.convertToDTOList(ledgerEntries)).thenReturn(accumulationEntryDTOList);
		setFinalStatic(LedgerEntryMapper.class.getField("INSTANCE"), ledgerEntryMapper);
		List<LedgerEntryDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(accumulationEntryDTOList, actual);
	}

	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerEntriesThrowsException() throws NotFoundException {
		List<LedgerEntryEntity> accumulationEntries = new ArrayList<>();
		when(iLedgerEntryRepository.findAll()).thenReturn(accumulationEntries);
		serviceImpl.readAll();
	}

	@Test
	public void testGetAccumConsumption() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerEntryMapper.class.getField("INSTANCE"), ledgerEntryMapper);
		String memberId = "A123";
		String subscriberId = "S123";
		String accumType = "Family Ded";
		List<LedgerEntryEntity> ledgerEntryEntities = new ArrayList<>();
		List<AccumsConsumptionDTO>  accumsConsumptionList = new ArrayList<>();
		AccumsConsumptionDTO dto = new AccumsConsumptionDTO();
		accumsConsumptionList.add(dto);
		when(iLedgerEntryRepository.findLedgerEntryBySubscriberIdAndMemberIdAndAccumType(memberId, accumType, subscriberId)).thenReturn(ledgerEntryEntities);
		when(ledgerEntryMapper.toAccumsConsumptionDTOList(ledgerEntryEntities)).thenReturn(accumsConsumptionList);
		List<AccumsConsumptionDTO>  resultList = serviceImpl.getAccumConsumption(memberId, subscriberId, accumType);
		Assert.assertEquals(resultList.get(0), dto);
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAccumConsumptionForNullSubscriberId() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerEntryMapper.class.getField("INSTANCE"), ledgerEntryMapper);
		String memberId = "A123";
		String subscriberId = null;
		String accumType = "Family Ded";
		List<LedgerEntryEntity> ledgerEntryEntities = new ArrayList<>();
		List<AccumsConsumptionDTO>  accumsConsumptionList = new ArrayList<>();
		AccumsConsumptionDTO dto = new AccumsConsumptionDTO();
		accumsConsumptionList.add(dto);
		when(iLedgerEntryRepository.findLedgerEntryByMemberIdAndAccumType(memberId, accumType)).thenReturn(ledgerEntryEntities);
		when(ledgerEntryMapper.toAccumsConsumptionDTOList(ledgerEntryEntities)).thenReturn(accumsConsumptionList);
		List<AccumsConsumptionDTO>  resultList = serviceImpl.getAccumConsumption(memberId, subscriberId, accumType);
		Assert.assertEquals(resultList.get(0), dto);
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
