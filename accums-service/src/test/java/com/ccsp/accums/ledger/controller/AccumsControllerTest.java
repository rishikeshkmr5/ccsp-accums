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
import com.ccsp.accums.service.LedgerHeaderService;

import javassist.NotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsControllerTest {
	public static int i = 10;

	@InjectMocks
	private AccumsController accumsController;
	
	@Mock
	private LedgerHeaderService ledgerHeaderService;
	
	@Test
	public void testGetLedgerHeader() throws NotFoundException {
		List<LedgerHeaderDTO> ledgerHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderService.getAllLedgerHeader()).thenReturn(ledgerHeaderDTOList);
		List<LedgerHeaderDTO> actual = accumsController.getLedgerHeader();
		Assert.assertEquals(actual, ledgerHeaderDTOList);
	}
	
	@Test
	public void testSetLedgerHeader() {
		LedgerHeaderDTO ledgerHeaderDTO = new LedgerHeaderDTO();
		accumsController.createLedgerHeader(ledgerHeaderDTO);
		verify(ledgerHeaderService, times(1)).setLedgerHeader(ledgerHeaderDTO);
	}
}
