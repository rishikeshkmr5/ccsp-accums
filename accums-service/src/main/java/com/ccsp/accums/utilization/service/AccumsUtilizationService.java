package com.ccsp.accums.utilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
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
	
}
