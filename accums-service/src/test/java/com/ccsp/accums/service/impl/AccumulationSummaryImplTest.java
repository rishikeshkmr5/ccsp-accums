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

import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.dto.ClaimSummaryDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.ledger.repository.AccumulationSummaryRepository;
import com.ccsp.accums.mapper.AccumulationSummaryMapper;
import com.ccsp.common.dto.ICommonDTO;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationSummaryImplTest {

	@InjectMocks
	private AccumulationSummaryServiceImpl serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private AccumulationSummaryRepository accumulationSummaryRepository;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private AccumulationHeaderRepository ledgerHeaderRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private AccumulationSummaryMapper accumulationSummaryMapper;
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(AccumulationSummaryMapper.class.getField("INSTANCE"), accumulationSummaryMapper);
		AccumulationSummary accumulationSummary = new AccumulationSummary();
		AccumulationSummaryDTO accumulationSummaryDTO = new AccumulationSummaryDTO();
		AccumulationHeader ledger= ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
		when(accumulationSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
		accumulationSummary.setLedgerHeader(ledger);
		serviceImpl.create(accumulationSummaryDTO);
		verify(accumulationSummaryRepository, times(1)).saveAndFlush(accumulationSummary);		
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetClaimLedgerSummary() throws NoSuchFieldException, SecurityException, Exception {

		ClaimSummaryDTO claimSummaryDTO = new ClaimSummaryDTO();
		List<AccumulationSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		accumulationSummaryDTOs.add(new AccumulationSummaryDTO());
		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);

		
		ClaimSummaryDTO claimSummaryDTOAfterInseration = new ClaimSummaryDTO();
		List<AccumulationSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();
		//List<AccumulationSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();
		
		//accumulationSummaryDTOs = claimSummaryDTO.getAccumulationSummaryDTO();
		for (AccumulationSummaryDTO accumulationSummaryDTO : accumulationSummaryDTOs) {
			AccumulationHeader ledger = new AccumulationHeader();
			ledger.setLedgerID(1L);
			when(ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID())).thenReturn(ledger);
			//AccumulationHeader ledger = ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
			AccumulationSummary accumulationSummary = new AccumulationSummary();
			when(accumulationSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
			accumulationSummary.setLedgerHeader(ledger);

			when(accumulationSummaryRepository.saveAndFlush(accumulationSummary)).thenReturn(accumulationSummary);
			when(accumulationSummaryMapper.convertToDTO(accumulationSummary)).thenReturn(accumulationSummaryDTO);
			accumulationSummaryDTOsAfterInseration.add(accumulationSummaryDTO);
		}
		claimSummaryDTOAfterInseration.setAccumulationSummaryList(accumulationSummaryDTOsAfterInseration);
		ClaimSummaryDTO actual = serviceImpl.createClaimSummary(claimSummaryDTO);
		Assert.assertEquals(claimSummaryDTOAfterInseration, actual);
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerSummaries() throws NoSuchFieldException, SecurityException, Exception {
		List<AccumulationSummary> accumulationSummaries = new ArrayList<>();
		AccumulationSummary accumulationSummary = new AccumulationSummary();
		AccumulationHeader accumulationHeader = new AccumulationHeader();
		accumulationHeader.setLedgerID(1L);
		accumulationSummary.setLedgerHeader(accumulationHeader);
		accumulationSummaries.add(accumulationSummary);
		List<AccumulationSummaryDTO> accumulationHeaderDTOList = new ArrayList<>();
		when(accumulationSummaryRepository.findAll()).thenReturn(accumulationSummaries);
		for(AccumulationSummary summary: accumulationSummaries) {
			
			AccumulationSummaryDTO accumulationSummaryDTO=new AccumulationSummaryDTO();
			when(accumulationSummaryMapper.convertToDTO(summary)).thenReturn(accumulationSummaryDTO);
			accumulationSummaryDTO.setLedgerHeaderID(summary.getLedgerHeader().getLedgerID());
			accumulationHeaderDTOList.add(accumulationSummaryDTO);
			
		}
		setFinalStatic(AccumulationSummaryMapper.class.getField("INSTANCE"), accumulationSummaryMapper);
		List<AccumulationSummaryDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(accumulationHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<AccumulationSummary> accumulationSummaries = new ArrayList<>();
		when(accumulationSummaryRepository.findAll()).thenReturn(accumulationSummaries);
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
