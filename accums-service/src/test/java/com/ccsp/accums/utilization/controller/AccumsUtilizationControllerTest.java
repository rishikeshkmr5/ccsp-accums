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
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Validation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;
import javassist.NotFoundException;
import javax.validation.ValidationException;
/**
 * @author nnarayanaperumaln
 *
 */
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
		List<SpendingSummaryDTO> utilizationHistory = new ArrayList<>();
		SpendingSummaryDTO utilizationDTO = new SpendingSummaryDTO();
		utilizationHistory.add(utilizationDTO);
		when(utilizationService.getSpendingSummary(memberId, null)).thenReturn(utilizationHistory);
		List<SpendingSummaryDTO> resultList = controller.getSpendingSummary(memberId);
		for(SpendingSummaryDTO result : resultList) {
			Assert.assertEquals(result,utilizationDTO);
		}
	}
	
	@Test(expected = NotFoundException.class)
	public void testFetchAccumsUtilizationException() throws ParseException, NotFoundException {
		String memberId = "A0001";
		String subscriberId = "S0001";
		List<SpendingSummaryDTO> utilizationHistory = new ArrayList<>();
		when(utilizationService.getSpendingSummary(memberId, subscriberId)).thenReturn(utilizationHistory);
		List<SpendingSummaryDTO> resultList = controller.getSpendingSummary(memberId);
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
		when(accumulationSummaryService.getBenefitBalance(null, memberId)).thenReturn(accumulationSummaryDTOs);
		List<LedgerSummaryDTO> actual = controller.getBenefitBalance(memberId);
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
		controller.getBenefitBalance(subscriberId);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetClaimDetailsByMemberIdAndAccumType() throws NotFoundException {
		List<AccumsConsumptionDTO> accumulationConsumptionDTOs = new ArrayList<>();
		AccumsConsumptionDTO dto = new AccumsConsumptionDTO();
		accumulationConsumptionDTOs.add(dto);
		String member = "M0001234";
		String subscriber = null;
		String accumType = "Individual Ded";
		when(utilizationService.getAccumsConsumption(accumType, member, null)).thenReturn(accumulationConsumptionDTOs);
		List<AccumsConsumptionDTO> actual = controller.getClaimDetailsByMemberIdAndAccumType(accumType, member);
		Assert.assertEquals(actual.get(0), accumulationConsumptionDTOs.get(0));

	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = ValidationException.class)
	public void testGetClaimDetailsValidationException() throws NotFoundException {
		String member = null;
		String subscriber = null;
		String accumType = "Individual Ded";
		controller.getClaimDetailsByMemberIdAndAccumType(accumType, member);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetClaimDetailsNotFoundException() throws NotFoundException {
		String member = "A12345";
		String subscriber = null;
		String accumType = "Individual Ded";
		controller.getClaimDetailsByMemberIdAndAccumType(accumType, member);
	}
	
	/**
	 * Fetches claim details based on claim id
	 * 
	 * @param claimID
	 * @return
	 * @throws NotFoundException
	 */
	
	@Test
	public void getClaimDeatilsById() throws NotFoundException {
		ClaimDetailDTO claimDetailDTO = new ClaimDetailDTO();
		String claimID = "CLM0001";
		when(utilizationService.getClaimDetail(claimID)).thenReturn(claimDetailDTO);
		ClaimDetailDTO actual = controller.getClaimDeatilsByClaimId(claimID);
		Assert.assertEquals(actual, claimDetailDTO);

	}
}
