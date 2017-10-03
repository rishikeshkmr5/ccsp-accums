package com.ccsp.accums.ledger.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.service.impl.AccumsLedgerHeaderServiceImpl;
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
	private AccumsLedgerHeaderServiceImpl ledgerHeaderService;
	
	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetLedgerHeader() throws NotFoundException {
		List<ICommonDTO> ledgerHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderService.readAll()).thenReturn(ledgerHeaderDTOList);
		List<LedgerHeaderDTO> actual = accumsController.getLedgerHeader();
		Assert.assertEquals(actual, ledgerHeaderDTOList);
	}
	
	/**
	 * Test the ledgerHeader creation
	 */
	@Test
	public void testSetLedgerHeader() {
		LedgerHeaderDTO ledgerHeaderDTO = new LedgerHeaderDTO();
		accumsController.createLedgerHeader(ledgerHeaderDTO);
		verify(ledgerHeaderService, times(1)).create(ledgerHeaderDTO);
	}
}
