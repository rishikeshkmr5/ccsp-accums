package com.ccsp.accums.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.mapper.LedgerEntryMapper;
import com.ccsp.accums.ledger.entry.repository.LedgerEntryRepository;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;

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
	private LedgerEntryRepository ledgerEntryRepository;

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
		LedgerEntryDTO accumulationEntryDTO = new LedgerEntryDTO();
		LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(accumulationEntryDTO.getLedgerHeaderID());
		when(ledgerEntryMapper.convertToEntity(accumulationEntryDTO)).thenReturn(accumulationEntry);
		accumulationEntry.setLedgerHeader(ledger);
		serviceImpl.create(accumulationEntryDTO);
		verify(ledgerEntryRepository, times(1)).saveAndFlush(accumulationEntry);
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

		List<LedgerEntryDTO> accumulationEntryDTOsAfterInseration = new ArrayList<>();

		for (LedgerEntryDTO accumulationEntryDTO : accumulationEntryDTOs) {
			LedgerHeaderEntity ledger = new LedgerHeaderEntity();
			when(ledgerHeaderRepository.findOne(accumulationEntryDTO.getLedgerHeaderID())).thenReturn(ledger);
			LedgerEntryEntity accumulationEntry = new LedgerEntryEntity();
			when(ledgerEntryMapper.convertToEntity(accumulationEntryDTO)).thenReturn(accumulationEntry);
			accumulationEntry.setLedgerHeader(ledger);

			when(ledgerEntryRepository.saveAndFlush(accumulationEntry)).thenReturn(accumulationEntry);
			when(ledgerEntryMapper.convertToDTO(accumulationEntry)).thenReturn(accumulationEntryDTO);
			accumulationEntryDTOsAfterInseration.add(accumulationEntryDTO);
		}
		List<LedgerEntryDTO> actual = serviceImpl.create(accumulationEntryDTOs);
		Assert.assertEquals(accumulationEntryDTOsAfterInseration, actual);
	}

	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void testGetAllLedgerEntries() throws NoSuchFieldException, SecurityException, Exception {
		List<LedgerEntryEntity> accumulationEntries = new ArrayList<>();
		LedgerEntryEntity accumulationEntry = new LedgerEntryEntity();
		LedgerHeaderEntity ledgerHeaderEntity = new LedgerHeaderEntity();
		ledgerHeaderEntity.setId(1L);
		accumulationEntry.setLedgerHeader(ledgerHeaderEntity);
		accumulationEntries.add(accumulationEntry);
		List<LedgerEntryDTO> accumulationEntryDTOList = new ArrayList<>();
		when(ledgerEntryRepository.findAll()).thenReturn(accumulationEntries);
		for (LedgerEntryEntity entry : accumulationEntries) {

			LedgerEntryDTO accumulationEntryDTO = new LedgerEntryDTO();
			when(ledgerEntryMapper.convertToDTO(entry)).thenReturn(accumulationEntryDTO);
			accumulationEntryDTO.setLedgerHeaderID(entry.getLedgerHeader().getId());
			accumulationEntryDTOList.add(accumulationEntryDTO);

		}
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
		when(ledgerEntryRepository.findAll()).thenReturn(accumulationEntries);
		serviceImpl.readAll();
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
