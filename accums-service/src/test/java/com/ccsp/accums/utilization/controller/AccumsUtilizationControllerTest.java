package com.ccsp.accums.utilization.controller;

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

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.accums.utilization.dto.AccumsUtilizationDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;

import javassist.NotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsUtilizationControllerTest {

	@InjectMocks
	private AccumsUtilizationController controller;
	
	@Mock
	private AccumsUtilizationService utilizationService;
	
	@Mock
	private LedgerSummaryService accumulationSummaryService;
	
	@Test
	public void testFetchAccumsUtilizationByMemberIdAndSubscriberId() throws ParseException, NotFoundException {
		String memberId = "A0001";
		String subscriberId = "S0001";
		List<AccumsUtilizationDTO> utilizationHistory = new ArrayList<>();
		AccumsUtilizationDTO utilizationDTO = new AccumsUtilizationDTO();
		utilizationHistory.add(utilizationDTO);
		when(utilizationService.getAccumsUtilization(memberId, subscriberId)).thenReturn(utilizationHistory);
		List<AccumsUtilizationDTO> resultList = controller.fetchAccumsUtilizationByMemberIdAndSubscriberId(memberId, subscriberId);
		for(AccumsUtilizationDTO result : resultList) {
			Assert.assertEquals(result,utilizationDTO);
		}
	}
	
	@Test(expected = NotFoundException.class)
	public void testFetchAccumsUtilizationException() throws ParseException, NotFoundException {
		String memberId = "A0001";
		String subscriberId = "S0001";
		List<AccumsUtilizationDTO> utilizationHistory = new ArrayList<>();
		when(utilizationService.getAccumsUtilization(memberId, subscriberId)).thenReturn(utilizationHistory);
		List<AccumsUtilizationDTO> resultList = controller.fetchAccumsUtilizationByMemberIdAndSubscriberId(memberId, subscriberId);
	}
	
	/**
	 * Fetches benefit balance details based on subscriber or member id
	 * 
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	@Test
	public void getLedgerSummaryBalance() throws NotFoundException {
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		accumulationSummaryDTOs.add(new LedgerSummaryDTO());
		String memberId = "M0001234";
		String subscriberId = "S0001234";
		when(accumulationSummaryService.getBenefitBalance(subscriberId, memberId)).thenReturn(accumulationSummaryDTOs);
		List<LedgerSummaryDTO> actual = controller.getLedgerSummaryBalance(subscriberId, memberId);
		Assert.assertEquals(actual, accumulationSummaryDTOs);

	}
	
	/**
	 * 
	 * @throws ParseException
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void getLedgerSummaryBalanceException() throws ParseException, NotFoundException {
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		String memberId = "A0001";
		String subscriberId = "S0001";
		when(accumulationSummaryService.getBenefitBalance(subscriberId, memberId)).thenReturn(accumulationSummaryDTOs);
		List<LedgerSummaryDTO> actual = controller.getLedgerSummaryBalance(subscriberId, memberId);
	}


}
