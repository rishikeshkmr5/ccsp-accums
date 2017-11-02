package com.ccsp.accums.service.impl;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.header.dto.ILedgerHeaderDTO;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.utilization.dto.AccumsUtilizationDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsUtilizationServiceTest {

	@InjectMocks
	private AccumsUtilizationService accumsUtilizationService;
	
	@Mock
	private LedgerHeaderService ledgerHeaderService;
	
	@Test
	public void testGetAccumsUtilization() throws ParseException {
		List<LedgerHeaderDTO> ledgerHeaderDTOList = new ArrayList<>();
		LedgerHeaderDTO ledgerHeaderDTO = new LedgerHeaderDTO();		
		String memberId = "A0001";
		String subscriberId = "S0001";
		ledgerHeaderDTO.setMemberId(memberId);
		ledgerHeaderDTO.setSubscriberId(subscriberId);
		ledgerHeaderDTO.setAllowedAmount(100d);
		ledgerHeaderDTO.setNetworkCode("networkCode");
		ledgerHeaderDTO.setServiceName("serviceName");
		ledgerHeaderDTOList.add(ledgerHeaderDTO);
		when(ledgerHeaderService.fetchByMemberIdAndSubscriberId(memberId, subscriberId)).thenReturn(ledgerHeaderDTOList);
		List<AccumsUtilizationDTO> resultList = accumsUtilizationService.getAccumsUtilization(memberId, subscriberId);
		for(AccumsUtilizationDTO result : resultList) {
			Assert.assertEquals(memberId, result.getMemberId());
			Assert.assertEquals(subscriberId, result.getSubscriberId());
			Assert.assertEquals(ledgerHeaderDTO.getNetworkCode(), result.getNetworkCode());
			Assert.assertEquals(ledgerHeaderDTO.getServiceName(), result.getServiceName());
		}
	}
}
