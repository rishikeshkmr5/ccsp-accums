package com.ccsp.accums.utilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccsp.accums.category.type.repository.BenefitPeriod;
import com.ccsp.accums.category.type.service.CategoryTypeService;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.utilization.dto.AccumUtilizationDetailDTO;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.FamilyUtilizationDTO;
import com.ccsp.accums.utilization.dto.IndividualUtilizationDTO;
import com.ccsp.accums.utilization.dto.PlanPeriod;
import com.ccsp.accums.utilization.dto.UtilizationPeriodDetailDTO;
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
			 
			 List<BenefitPeriod> benefitPeriod = getListOfBenefitPeriod("benefit-period");
			 accumUtilizationDetailDTO.setBenefitPeriod(benefitPeriod);
			 
			 List<PlanPeriod> planPeriod = getListOfPlanPeriod("plan-period");
			 accumUtilizationDetailDTO.setPlanPeriod(planPeriod);
			  
			 accumUtilizationDetailDTOList.add(accumUtilizationDetailDTO);
		 }
		return accumUtilizationDetailDTOList;
	}

	public List<IndividualUtilizationDTO> getAccumsIndividualUtilization(String memberID) {
		List<IndividualUtilizationDTO> individualUtilizationDTOList = new ArrayList(); 
		List<LedgerHeaderDTO> ledgerHeaderDTOList=ledgerHeaderService.findByMemberId(memberID);
		for(LedgerHeaderDTO ledgerHeaderDTO:ledgerHeaderDTOList) {
			List<LedgerEntryDTO> ledgerentries = ledgerEntryService.findByLedgerId(ledgerHeaderDTO.getId());
			 
				for(LedgerEntryDTO ledgerEntryDTO:ledgerentries) {
					IndividualUtilizationDTO individualUtilizationDTO= new IndividualUtilizationDTO();
					individualUtilizationDTO.setNetworkCode(ledgerHeaderDTO.getNetworkCode());
					List<UtilizationPeriodDetailDTO> individualUtilizationPeriodDetailDTOList = new ArrayList<>();
					UtilizationPeriodDetailDTO individualUtilizationPeriodDetailDTO = new UtilizationPeriodDetailDTO();
					UtilizationPeriodDetailDTO individualUtilizationPeriodDetailDTO1 = new UtilizationPeriodDetailDTO();
					individualUtilizationPeriodDetailDTO.setAccumsRemaining(600l);
					individualUtilizationPeriodDetailDTO.setPeriod("12/01/2019");
					individualUtilizationPeriodDetailDTO.setPlanPeriodLimit(129l);
					individualUtilizationPeriodDetailDTO.setPlanPeriodUtilization(450l);
					
					individualUtilizationPeriodDetailDTO1.setAccumsRemaining(400l);
					individualUtilizationPeriodDetailDTO1.setPeriod("12/01/2019");
					individualUtilizationPeriodDetailDTO1.setPlanPeriodLimit(1266l);
					individualUtilizationPeriodDetailDTO1.setPlanPeriodUtilization(2450l);
					individualUtilizationPeriodDetailDTOList.add(individualUtilizationPeriodDetailDTO);
					individualUtilizationPeriodDetailDTOList.add(individualUtilizationPeriodDetailDTO1);
					
					
					individualUtilizationDTO.setAccumType(ledgerEntryDTO.getAccumType());
					individualUtilizationDTO.setMemberID(memberID);
					individualUtilizationDTO.setIndividualUtilizationPeriodDetailDTOList(individualUtilizationPeriodDetailDTOList);
					
					if(!individualUtilizationDTOList.contains(individualUtilizationDTO))
					individualUtilizationDTOList.add(individualUtilizationDTO);
			  	}
				
		}
		return individualUtilizationDTOList;
	}

	public List<FamilyUtilizationDTO> getAccumsFamilyUtilization(String subscriberID) {
		List<FamilyUtilizationDTO> familyUtilizationDTOList = new ArrayList<>();
		List<LedgerHeaderDTO> ledgerHeaderDTOList = ledgerHeaderService.findBySubscriberId(subscriberID);
		for(LedgerHeaderDTO ledgerHeaderSubscriberDTO:ledgerHeaderDTOList) {
			FamilyUtilizationDTO familyUtilizationDTO= new FamilyUtilizationDTO();
			familyUtilizationDTO.setNetworkCode(ledgerHeaderSubscriberDTO.getNetworkCode());
			List<LedgerHeaderDTO> ledgerHeaderMembersForSubscriberDTOList=ledgerHeaderService.fetchByMemberIdAndSubscriberId(ledgerHeaderSubscriberDTO.getMemberId(), subscriberID);
			for(LedgerHeaderDTO ledgerHeaderDTO:ledgerHeaderMembersForSubscriberDTOList) {
				List<LedgerEntryDTO> ledgerentries = ledgerEntryService.findByLedgerId(ledgerHeaderDTO.getId());
					for(LedgerEntryDTO ledgerEntryDTO:ledgerentries) {
						
						List<UtilizationPeriodDetailDTO> utilizationPeriodDetailDTOList = new ArrayList<>();
						UtilizationPeriodDetailDTO familyUtilizationPeriodDetailDTO = new UtilizationPeriodDetailDTO();
						UtilizationPeriodDetailDTO familyUtilizationPeriodDetailDTO1 = new UtilizationPeriodDetailDTO();
						familyUtilizationPeriodDetailDTO.setAccumsRemaining(600l);
						familyUtilizationPeriodDetailDTO.setPeriod("12/01/2019");
						familyUtilizationPeriodDetailDTO.setPlanPeriodLimit(129l);
						familyUtilizationPeriodDetailDTO.setPlanPeriodUtilization(450l);
						
						familyUtilizationPeriodDetailDTO1.setAccumsRemaining(400l);
						familyUtilizationPeriodDetailDTO1.setPeriod("12/01/2019");
						familyUtilizationPeriodDetailDTO1.setPlanPeriodLimit(1266l);
						familyUtilizationPeriodDetailDTO1.setPlanPeriodUtilization(2450l);
						utilizationPeriodDetailDTOList.add(familyUtilizationPeriodDetailDTO);
						utilizationPeriodDetailDTOList.add(familyUtilizationPeriodDetailDTO1);
						
						
						familyUtilizationDTO.setAccumType(ledgerEntryDTO.getAccumType());
						familyUtilizationDTO.setUtilizationPeriodDetailDTOList(utilizationPeriodDetailDTOList);
						familyUtilizationDTO.setSubscriberId(subscriberID);
						familyUtilizationDTOList.add(familyUtilizationDTO);
				  	}
					
			}
			
		}
		return familyUtilizationDTOList;
	}

	public List<List<IndividualUtilizationDTO>> getAccumsIndividualUtilizationList(List<String> memberID) {
		List<List<IndividualUtilizationDTO>> individualUtilizationDTOList = new ArrayList<>();
		for (String memberId:memberID) {
			
			List<IndividualUtilizationDTO> individualUtilizationDTO = getAccumsIndividualUtilization(memberId);
			if(!individualUtilizationDTOList.contains(individualUtilizationDTO))
			individualUtilizationDTOList.add(individualUtilizationDTO);
		}
		return individualUtilizationDTOList;
	}
	
	public List<PlanPeriod> getListOfPlanPeriod(String period) {		
		List<PlanPeriod> planPeriodList = new ArrayList<>();
			PlanPeriod planPeriod=new PlanPeriod();
			PlanPeriod planPeriod1=new PlanPeriod();
			planPeriod.setId(1l);
			planPeriod.setCode("01/01/2017-03/31/2017");
			planPeriod1.setId(2l);
			planPeriod1.setCode("04/01/2017-12/31/2017");
			planPeriodList.add(planPeriod);
			planPeriodList.add(planPeriod1);
		return planPeriodList;
	}
	
	public List<BenefitPeriod> getListOfBenefitPeriod(String period) {		
		List<BenefitPeriod> benefitPeriodList = new ArrayList<>();
		    BenefitPeriod benefitPeriod=new BenefitPeriod();
			benefitPeriod.setId(1l);
			benefitPeriod.setCode("2017");
			benefitPeriodList.add(benefitPeriod);
			
		return benefitPeriodList;
	}
}
