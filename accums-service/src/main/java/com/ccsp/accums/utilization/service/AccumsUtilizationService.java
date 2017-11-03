package com.ccsp.accums.utilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
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
			spendingSummaryDTO.setStartDate(DateUtils.format("01/01/2017"));
			spendingSummaryDTO.setEndDate(DateUtils.format("12/31/2017"));
			//set the limit to static value
			spendingSummaryDTO.setLimit(10l);
			spendingSummaryDTO.setUnit(spendingSummaryDTO.getAllowedAmount()>0? 1.0 : 0.0);
		}		
		return spendingSummaryDTOList;		
	}
	
	public List<AccumsConsumptionDTO> getAccumsConsumption(String accumType, String memberID, String subscriberID) {
		List<AccumsConsumptionDTO> accumsConsumptionDTOList = new ArrayList<>();
		List<LedgerHeaderDTO> ledgerHeaderDTOList = null;
		if(subscriberID != null)
			ledgerHeaderDTOList	= ledgerHeaderService.fetchByMemberIdAndSubscriberId(memberID, subscriberID);
		else
			ledgerHeaderDTOList = ledgerHeaderService.findByMemberId(memberID);
		if(ledgerHeaderDTOList != null) {
				for(LedgerHeaderDTO ledgerHeaderDTO:ledgerHeaderDTOList) {
					
					List<LedgerEntryDTO> ledgerEntryList = ledgerEntryService.findByLedgerId(ledgerHeaderDTO.getId());
						for(LedgerEntryDTO LedgerEntryDTO:ledgerEntryList) {
							if(LedgerEntryDTO.getAccumType().equals(accumType)){
								AccumsConsumptionDTO accumsConsumptionDTO = new AccumsConsumptionDTO();
								accumsConsumptionDTO.setAmount(ledgerHeaderDTO.getAllowedAmount());
								accumsConsumptionDTO.setDcn(ledgerHeaderDTO.getDcn());
								accumsConsumptionDTO.setNetworkCode(ledgerHeaderDTO.getNetworkCode());
								accumsConsumptionDTO.setProcessedDate(ledgerHeaderDTO.getProcessedDate());
								accumsConsumptionDTO.setRunningTotal(LedgerEntryDTO.getAmount());
								accumsConsumptionDTO.setServiceDate(ledgerHeaderDTO.getServiceDate());
								accumsConsumptionDTOList.add(accumsConsumptionDTO);
							}
						}
					
						
					}
			    }
		
		
		return accumsConsumptionDTOList;
	}
	
}
