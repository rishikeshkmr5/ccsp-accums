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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.common.utils.UIConstants;

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
		List<LedgerSummaryDTO> accumulationSummaryDTOList = new ArrayList<>();
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
		accumulationSummaryDTOs.add(accumulationSummaryDTO);

		claimSummaryDTO.setAccumulationSummaryList(accumulationSummaryDTOs);
		ledgerSummaryController.createLedgerSummary(claimSummaryDTO);
		verify(accumulationSummaryService, times(1)).create(claimSummaryDTO.getAccumulationSummaryList());
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
		ledgerSummaryController.createLedgerSummary(claimSummaryDTO);
		verify(accumulationSummaryService, times(1)).create(claimSummaryDTO.getAccumulationSummaryList());
	}
}
