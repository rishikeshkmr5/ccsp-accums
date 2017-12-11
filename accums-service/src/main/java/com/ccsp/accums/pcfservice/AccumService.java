package com.ccsp.accums.pcfservice;

import java.util.List;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;

public interface AccumService {
	
	void updateAccum( AccumUtilization au );

	String greet();

	List<SpendingSummaryDTO> getSummaryAccum(String memberId);

	List<LedgerSummaryDTO> getBenefitBalance(String memberId);

	List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	ClaimDetailDTO getClaim(String claimID);

	List<SpendingSummaryDTO> summaryAccums(String memberId);

	List<LedgerSummaryDTO> benefitBalance(String memberId);

	List<AccumsConsumptionDTO> claimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	List<ClaimDetailDTO> claimDetail(String claimID);

	

}
