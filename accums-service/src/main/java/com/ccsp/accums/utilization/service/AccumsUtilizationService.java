package com.ccsp.accums.utilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccsp.accums.category.type.service.CategoryTypeService;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.utilization.dto.AccumUtilizationDetailDTO;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.common.utils.DateUtils;

/**
 * @author nnarayanaperumaln
 * Gets the spending summary for the member id and subscriber id
 *
 */
@Component
public class AccumsUtilizationService{
	
	@Autowired
	private LedgerHeaderService ledgerHeaderService;
	
	@Autowired
	private LedgerEntryService ledgerEntryService;
	
	@Autowired
	private CategoryTypeService categoryTypeService;
	/**
	 * Fetch the spending summary for the member id and subscriber id
	 * @param memberId
	 * @param subscriberId
	 * @return
	 * @throws ParseException
	 */
	public List<SpendingSummaryDTO> getSpendingSummary(String memberId, String subscriberId) throws ParseException {	
		//fetch the ledgerHeader details for the given member and subscriber id
		List<SpendingSummaryDTO> spendingSummaryDTOList = ledgerHeaderService.getSpendingSummary(memberId, subscriberId);
		//Iterate the LedgerHeader DTOs to create corresponding utilization DTOs
		for(SpendingSummaryDTO spendingSummaryDTO : spendingSummaryDTOList) {
			//Set the start date and end date to static values
			spendingSummaryDTO.setStartDate(DateUtils.getYearStart());
			spendingSummaryDTO.setEndDate(DateUtils.getYearEnd());
			//set the limit to static value
			spendingSummaryDTO.setLimit(10l);
			spendingSummaryDTO.setUnit(spendingSummaryDTO.getAllowedAmount()>0? 1.0 : 0.0);
		}		
		return spendingSummaryDTOList;		
	}
	
	/**
	 * Method to get claim details for the member id and the accum type
	 * @param accumType
	 * @param memberId
	 * @param subscriberId
	 * @return
	 */
	public List<AccumsConsumptionDTO> getAccumsConsumption(String accumType, String memberId, String subscriberId) {
		//Orchestrate the request to the LedgerEntry service
		return ledgerEntryService.getAccumConsumption(memberId, subscriberId, accumType);		
	}	
	
	/**
	 * Method to get claim details based on claim Id
	 * @param claimID
	 * @return
	 */
	public ClaimDetailDTO getClaimDetail(String claimID) {
		ClaimDetailDTO claimDetailDTO = new ClaimDetailDTO();
		// fetches claim details based on claim id
		claimDetailDTO  = ledgerHeaderService.getClaim(claimID);
	    claimDetailDTO.setProvider("Dr. Phill");
	return claimDetailDTO;	
	}
	public List<AccumUtilizationDetailDTO> getAccumsUtilizationDetail(String subscriberID) throws ParseException {
		String accumType = null;
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateformat3.parse("17/07/1989");
	    
		List<AccumUtilizationDetailDTO> accumUtilizationDetailDTOList = new ArrayList<>();
		 List<LedgerHeaderDTO> LedgerHeaderDTOlist = ledgerHeaderService.findBySubscriberId(subscriberID);
		
		 	 for(LedgerHeaderDTO ledgerHeaderDTO : LedgerHeaderDTOlist) {
		 	List<LedgerHeaderDTO> ledgerHeaderDTOList = ledgerHeaderService.fetchByMemberIdAndSubscriberId(ledgerHeaderDTO.getMemberId(), subscriberID);
			 AccumUtilizationDetailDTO accumUtilizationDetailDTO  = new AccumUtilizationDetailDTO();
			 accumUtilizationDetailDTO.setSubscriberID(ledgerHeaderDTO.getSubscriberId());
			 accumUtilizationDetailDTO.setMemberPartyID(ledgerHeaderDTO.getMemberId());
			 accumUtilizationDetailDTO.setMemberName("Johny Doe");
			 accumUtilizationDetailDTO.setGroupNumber(100);
			 accumUtilizationDetailDTO.setDOB(date1);
			 accumUtilizationDetailDTO.setSectionNumer(1);
			 accumUtilizationDetailDTO.setAccountNumber(10101000);
			 accumUtilizationDetailDTO.setSSN("XXX--XX--XXX");
			 accumUtilizationDetailDTO.setRelationship("Subscriber");
			 accumUtilizationDetailDTO.setGender("M");
			 List<Long> networkTypes  = new ArrayList<>();
			 for(LedgerHeaderDTO ledgerDTO:ledgerHeaderDTOList) {
				 Long networkTypeId = categoryTypeService.getListOfValues(("network-type"),ledgerDTO.getNetworkCode()); 
				 if(networkTypeId!=null)
				 networkTypes.add(networkTypeId);
			 }
			 			 
			 accumUtilizationDetailDTO.setNetworkType(networkTypes);
			 List<Long> accumTypes = new ArrayList<>();
			 List<LedgerEntryDTO> ledgerentries = ledgerEntryService.findByLedgerId(ledgerHeaderDTO.getId());
			 for(LedgerEntryDTO ledgerEntryDTO:ledgerentries) {
				 accumType = ledgerEntryDTO.getAccumType();
				 Long accumTypesId = categoryTypeService.getListOfValues(("accum-type"),accumType);
				 if(accumTypesId != null)
				 accumTypes.add(accumTypesId);
			  	}
			 accumUtilizationDetailDTO.setAccumType(accumTypes);
			 
			 List<Long> benefitPeriod = categoryTypeService.getListOfPeriod("benefit-period");
			 accumUtilizationDetailDTO.setBenefitPeriod(benefitPeriod);
			 
			 List<Long> planPeriod = categoryTypeService.getListOfPeriod("plan-period");
			 accumUtilizationDetailDTO.setPlanPeriod(planPeriod);
			  
			 accumUtilizationDetailDTOList.add(accumUtilizationDetailDTO);
		 }
		return accumUtilizationDetailDTOList;
	}
}
