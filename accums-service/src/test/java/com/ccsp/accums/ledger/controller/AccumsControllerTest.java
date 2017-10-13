package com.ccsp.accums.ledger.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.dto.ClaimSummaryDTO;
import com.ccsp.accums.service.impl.AccumulationHeaderServiceImpl;
import com.ccsp.accums.service.impl.AccumulationSummaryServiceImpl;
import com.ccsp.common.dto.ICommonDTO;

import javassist.NotFoundException;


/**
 * @author nnarayanaperumaln
 *
 */
/**
 * @author nnarayanaperumaln
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsControllerTest {
	public static int i = 10;

	@InjectMocks
	private AccumsLedgerHeaderController accumsController;
	
	/**
	 * Mock the Service layer
	 */
	@Mock
	private AccumulationHeaderServiceImpl ledgerHeaderService;
	
	/**
	 * Mock the Service layer
	 */
	@Mock
	private AccumulationSummaryServiceImpl accumulationSummaryService;
	
	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetLedgerHeader() throws NotFoundException {
		List<ICommonDTO> ledgerHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderService.readAll()).thenReturn(ledgerHeaderDTOList);
		List<AccumulationHeaderDTO> actual = accumsController.getLedgerHeader();
		Assert.assertEquals(actual, ledgerHeaderDTOList);
	}
	
	/**
	 * Test the ledgerHeader creation
	 */
	@Test
	public void testSetLedgerHeader() {
		AccumulationHeaderDTO ledgerHeaderDTO = new AccumulationHeaderDTO();
		accumsController.createLedgerHeader(ledgerHeaderDTO);
		verify(ledgerHeaderService, times(1)).create(ledgerHeaderDTO);
	}

	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetAccumulationSummary() throws NotFoundException {
		List<ICommonDTO> accumulationSummaryDTOList = new ArrayList<>();
		when(accumulationSummaryService.readAll()).thenReturn(accumulationSummaryDTOList);
		List<AccumulationSummaryDTO> actual = accumsController.getAccumulationSummary();
		Assert.assertEquals(actual, accumulationSummaryDTOList);
	}
	
	/**
	 * Test the ledger summary creation
	 * @throws NotFoundException 
	 */
	@Test
	public void testSetAccumulationSummary() throws NotFoundException {
		List<AccumulationSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		AccumulationSummaryDTO accumulationSummaryDTO = new AccumulationSummaryDTO();
		ClaimSummaryDTO claimSummaryDTO = new ClaimSummaryDTO();
		
		accumulationSummaryDTO.setAccumType("str");
		accumulationSummaryDTO.setLedgerHeaderID(1L);
		accumulationSummaryDTOs.add(accumulationSummaryDTO);
		
		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);
		accumsController.createAccumulationSummary(claimSummaryDTO);
		verify(accumulationSummaryService, times(1)).createClaimSummary(claimSummaryDTO);
	}

}
