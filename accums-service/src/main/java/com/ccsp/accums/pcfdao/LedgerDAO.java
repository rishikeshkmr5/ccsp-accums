package com.ccsp.accums.pcfdao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.pcfdto.ServiceLine;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;

public interface LedgerDAO {

	List < Object > findAll(String sValue);
	
	//long insertLedgerHeaderGK( Map<String, Object> parameters );
	BigInteger insertLedgerHeaderGK( AccumUtilization accumUtilization );
	
	//long insertLedgerEntryGK( Map<String, Object> parameters );
	BigInteger insertLedgerEntryGK( ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey );
	
	void insert(String sValue,  Object[] params );

	List<Map<String, Object>> getById(String sTable, String dbColumnName, String dbColumnValue);

	int resetAG(String sTable);
	
	int delete(String sTable, String sColumn);

	List<SpendingSummaryDTO> getSummaryAccum(String memberId);

	List<LedgerSummaryDTO> getBenefitBalance(String memberId);

	List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	ClaimDetailDTO getClaim(String claimID);

	List<SpendingSummaryDTO> summaryAccum(String memberId);

	List<LedgerSummaryDTO> benefitBalance(String memberId);

	List<AccumsConsumptionDTO> claimDetailsByMemberIdAndAccumType(String accumType, String memberID);

	List<ClaimDetailDTO> claimDetail(String claimID);

	
	
}