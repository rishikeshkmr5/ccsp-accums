package com.ccsp.accums.pcfservice;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.pcfdto.ServiceLine;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;


@Service
@Transactional
public class AccumServiceImpl implements AccumService {

	@Autowired
	private LedgerService ledgerService;
	
	BigInteger generatedKeyLedgerHeader;
	BigInteger generatedKeyLedgerEntry;
	
	boolean isFirst;
	
	
	public void updateAccum(AccumUtilization accumUtilization)
	{
		generatedKeyLedgerHeader = ledgerService.insertLedgerHeaderGeneratedKey(accumUtilization);
	
		insertLedgerEntrySummary(accumUtilization);
	}

	public List<SpendingSummaryDTO> getSummaryAccum(String memberId){
		List<SpendingSummaryDTO> summaryDTO = ledgerService.getSummaryAccum(memberId);
		return summaryDTO;
	}
	
	public void insertLedgerEntrySummary(AccumUtilization accumUtilization) {

		isFirst = true;
		
		for (ServiceLine serviceLine : accumUtilization.getServiceLine()) {
			
			if (!isFirst) {
				ledgerService.insertLedgerEntry(serviceLine, generatedKeyLedgerHeader, generatedKeyLedgerEntry);
			}
			else
			{
				generatedKeyLedgerEntry = ledgerService.insertLedgerEntryGeneratedKey(serviceLine, generatedKeyLedgerHeader, BigInteger.valueOf(0));
				isFirst = false;
			}

	//		if summaryExists
			ledgerService.insertLedgerSummary(accumUtilization,serviceLine);
		}
	}
	
	
	public List<LedgerSummaryDTO> getBenefitBalance(String memberId){
	return	ledgerService.getBenefitBalance(memberId);
	}
	
	public List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(String accumType, String memberID){
		return	ledgerService.getClaimDetailsByMemberIdAndAccumType(accumType,memberID);
	}
	
	public ClaimDetailDTO getClaim(String claimID){
		return	ledgerService.getClaim(claimID);
	}
	
	public List<SpendingSummaryDTO> summaryAccums(String memberId){
		List<SpendingSummaryDTO> summaryDTO = ledgerService.summaryAccum(memberId);
		return summaryDTO;
	}
	
	public List<LedgerSummaryDTO> benefitBalance(String memberId){
		return ledgerService.benefitBalance(memberId);
	}

	public List<AccumsConsumptionDTO> claimDetailsByMemberIdAndAccumType(String accumType, String memberID){
		return ledgerService.claimDetailsByMemberIdAndAccumType(accumType,memberID);
	}

	public List<ClaimDetailDTO> claimDetail(String claimID){
		return ledgerService.claimDetail(claimID);
	}
	
	
	public String greet() {
		return "Hello World";
	}
}