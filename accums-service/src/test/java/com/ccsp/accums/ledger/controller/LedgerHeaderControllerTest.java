package com.ccsp.accums.ledger.controller;

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

import com.ccsp.accums.ledger.header.controller.LedgerHeaderController;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
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
/*@RunWith(SpringJUnit4ClassRunner.class)
public class LedgerHeaderControllerTest {
	public static int i = 10;

	@InjectMocks
	private LedgerHeaderController accumsController;*/

	/**
	 * Mock the Service layer
	 */
	/*@Mock
	private LedgerHeaderService ledgerHeaderService;

	/**
	 * @throws NotFoundException
	 */
	/*@Test
	public void testGetLedgerHeader() throws NotFoundException {
		List<ICommonDTO> ledgerHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderService.readAll()).thenReturn(ledgerHeaderDTOList);
		List<LedgerHeaderDTO> actual = accumsController.getLedgerHeader();
		Assert.assertEquals(actual, ledgerHeaderDTOList);
	}*/

	/**
	 * Test the ledgerHeader creation
	 */
	/*@Test
	public void testSetLedgerHeader() {
		AccumulationHeaderDTO ledgerHeaderDTO = new AccumulationHeaderDTO();
		accumsController.createLedgerHeader(ledgerHeaderDTO);
		verify(ledgerHeaderService, times(1)).create(ledgerHeaderDTO);
	}*/

//}