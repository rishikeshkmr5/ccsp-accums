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

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.LedgerSummaryRepository;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationSummaryImplTest {

	@InjectMocks
	private LedgerSummaryService serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private LedgerSummaryRepository ledgerSummaryRepository;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private ILedgerHeaderRepository ledgerHeaderRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private LedgerSummaryMapper ledgerSummaryMapper;
	
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
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
		when(ledgerSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
		accumulationSummary.setLedgerHeader(ledger);
		serviceImpl.create(accumulationSummaryDTO);
		verify(ledgerSummaryRepository, times(1)).saveAndFlush(accumulationSummary);		
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetClaimLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {

		LedgerSummaryClaimDTO claimSummaryDTO = new LedgerSummaryClaimDTO();
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		accumulationSummaryDTOs.add(new LedgerSummaryDTO());
		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);

		
		LedgerSummaryClaimDTO claimSummaryDTOAfterInseration = new LedgerSummaryClaimDTO();
		List<LedgerSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();
		//List<AccumulationSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();
		
		//accumulationSummaryDTOs = claimSummaryDTO.getAccumulationSummaryDTO();
		for (LedgerSummaryDTO accumulationSummaryDTO : accumulationSummaryDTOs) {
			LedgerHeaderEntity ledger = new LedgerHeaderEntity();
			ledger.setLedgerID(1L);
			when(ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID())).thenReturn(ledger);
			//LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
			LedgerSummaryEntity accumulationSummary = new LedgerSummaryEntity();
			when(ledgerSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
			accumulationSummary.setLedgerHeader(ledger);

			when(ledgerSummaryRepository.saveAndFlush(accumulationSummary)).thenReturn(accumulationSummary);
			when(ledgerSummaryMapper.convertToDTO(accumulationSummary)).thenReturn(accumulationSummaryDTO);
			accumulationSummaryDTOsAfterInseration.add(accumulationSummaryDTO);
		}
		claimSummaryDTOAfterInseration.setAccumulationSummaryList(accumulationSummaryDTOsAfterInseration);
		LedgerSummaryClaimDTO actual = serviceImpl.createClaimSummary(claimSummaryDTO);
		Assert.assertEquals(claimSummaryDTOAfterInseration, actual);
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
		LedgerHeaderEntity ledgerHeaderEntity = new LedgerHeaderEntity();
		ledgerHeaderEntity.setLedgerID(1L);
		accumulationSummary.setLedgerHeader(ledgerHeaderEntity);
		accumulationSummaries.add(accumulationSummary);
		List<LedgerSummaryDTO> accumulationHeaderDTOList = new ArrayList<>();
		when(ledgerSummaryRepository.findAll()).thenReturn(accumulationSummaries);
		for(LedgerSummaryEntity summary: accumulationSummaries) {
			
			LedgerSummaryDTO accumulationSummaryDTO=new LedgerSummaryDTO();
			when(ledgerSummaryMapper.convertToDTO(summary)).thenReturn(accumulationSummaryDTO);
			accumulationSummaryDTO.setLedgerHeaderID(summary.getLedgerHeader().getLedgerID());
			accumulationHeaderDTOList.add(accumulationSummaryDTO);
			
		}
		setFinalStatic(LedgerSummaryMapper.class.getField("INSTANCE"), ledgerSummaryMapper);
		List<LedgerSummaryDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(accumulationHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<LedgerSummaryEntity> accumulationSummaries = new ArrayList<>();
		when(ledgerSummaryRepository.findAll()).thenReturn(accumulationSummaries);
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
