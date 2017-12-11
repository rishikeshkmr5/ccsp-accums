package com.ccsp.accums.pcfservice;

import java.math.BigInteger;
import java.util.List;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.pcfdto.ServiceLine;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;

public interface LedgerService {

	BigInteger insertLedgerHeaderGeneratedKey( AccumUtilization accumUtilization );

	BigInteger insertLedgerEntryGeneratedKey( ServiceLine serviceLine, BigInteger headerKey, BigInteger EntryKey );

	void insertLedgerEntry( ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey );

	void insertLedgerSummary( AccumUtilization accumUtilization, ServiceLine serviceLine );

	Object getById( String sTable, String dbColumnName, String dbColumnValue );

	List<SpendingSummaryDTO> getSummaryAccum(String memberId);

	List<LedgerSummaryDTO> getBenefitBalance(String memberId);

	List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	ClaimDetailDTO getClaim(String claimID);

	List<SpendingSummaryDTO> summaryAccum(String memberId);

	List<LedgerSummaryDTO> benefitBalance(String memberId);

	List<AccumsConsumptionDTO> claimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	List<ClaimDetailDTO> claimDetail(String claimID);

	
}
