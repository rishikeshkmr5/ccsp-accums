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
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsUtilizationServiceTest {

	@InjectMocks
	private AccumsUtilizationService accumsUtilizationService;
	
	@Mock
	private LedgerHeaderService ledgerHeaderService;
	
	@Test
	public void testGetAccumsUtilization() throws ParseException {
		List<SpendingSummaryDTO> ledgerHeaderDTOList = new ArrayList<>();
		SpendingSummaryDTO ledgerHeaderDTO = new SpendingSummaryDTO();		
		String memberId = "A0001";
		String subscriberId = "S0001";
		ledgerHeaderDTO.setMemberId(memberId);
		ledgerHeaderDTO.setSubscriberId(subscriberId);
		ledgerHeaderDTO.setAllowedAmount(100d);
		ledgerHeaderDTO.setNetworkCode("networkCode");
		ledgerHeaderDTO.setServiceName("serviceName");
		ledgerHeaderDTOList.add(ledgerHeaderDTO);
		when(ledgerHeaderService.getSpendingSummary(memberId, subscriberId)).thenReturn(ledgerHeaderDTOList);
		List<SpendingSummaryDTO> resultList = accumsUtilizationService.getSpendingSummary(memberId, subscriberId);
		for(SpendingSummaryDTO result : resultList) {
			Assert.assertEquals(memberId, result.getMemberId());
			Assert.assertEquals(subscriberId, result.getSubscriberId());
			Assert.assertEquals(ledgerHeaderDTO.getNetworkCode(), result.getNetworkCode());
			Assert.assertEquals(ledgerHeaderDTO.getServiceName(), result.getServiceName());
		}
	}
}
