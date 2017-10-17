package com.ccsp.accums.ledger.summary.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.summary.controller.LedgerSummaryController;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
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
public class LedgerSummaryControllerTest {
	
	@InjectMocks
	private LedgerSummaryController ledgerSummaryController;
	
	/**
	 * Mock the Service layer
	 */
	@Mock
	private LedgerSummaryService accumulationSummaryService;
	
	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetAccumulationSummary() throws NotFoundException {
		List<ICommonDTO> accumulationSummaryDTOList = new ArrayList<>();
		when(accumulationSummaryService.readAll()).thenReturn(accumulationSummaryDTOList);
		List<LedgerSummaryDTO> actual = ledgerSummaryController.getAccumulationSummary();
		Assert.assertEquals(actual, accumulationSummaryDTOList);
	}

	/**
	 * Test the ledger summary creation
	 * 
	 * @throws NotFoundException
	 */
	@Test
	public void testSetAccumulationSummary() throws NotFoundException {
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		LedgerSummaryDTO accumulationSummaryDTO = new LedgerSummaryDTO();
		LedgerSummaryClaimDTO claimSummaryDTO = new LedgerSummaryClaimDTO();

		accumulationSummaryDTO.setAccumType("str");
		accumulationSummaryDTO.setLedgerHeaderID(1L);
		accumulationSummaryDTOs.add(accumulationSummaryDTO);

		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);
		ledgerSummaryController.createAccumulationSummary(claimSummaryDTO);
		verify(accumulationSummaryService, times(1)).createClaimSummary(claimSummaryDTO);
	}

	/**
	 * Test the ledger summary creation
	 * 
	 * @throws NotFoundException
	 */
	@Test(expected = ValidationException.class)
	public void testSetAccumulationSummaryWithValidationError() throws NotFoundException {
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		LedgerSummaryClaimDTO claimSummaryDTO = new LedgerSummaryClaimDTO();
		accumulationSummaryDTOs.add(new LedgerSummaryDTO());
		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);
		ledgerSummaryController.createAccumulationSummary(claimSummaryDTO);
		verify(accumulationSummaryService, times(1)).createClaimSummary(claimSummaryDTO);
	}

}
