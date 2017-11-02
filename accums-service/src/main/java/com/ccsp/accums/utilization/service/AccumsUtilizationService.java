package com.ccsp.accums.utilization.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.dto.ILedgerHeaderDTO;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.accums.utilization.dto.AccumsUtilizationDTO;

/**
 * @author nnarayanaperumaln
 *
 */
@Component
public class AccumsUtilizationService{
	
	@Autowired
	private LedgerHeaderService ledgerHeaderService;
	
	/**
	 * @param memberId
	 * @param subscriberId
	 * @return
	 * @throws ParseException
	 */
	public List<AccumsUtilizationDTO> getAccumsUtilization(String memberId, String subscriberId) throws ParseException {	
		//fetch the ledgerHeader details for the given member and subscriber id
		List<LedgerHeaderDTO> ledgerHeaderDTOList = ledgerHeaderService.fetchByMemberIdAndSubscriberId(memberId, subscriberId);
		List<AccumsUtilizationDTO> utilizationDTOList = new ArrayList<>();
		//Iterate the LedgerHeader DTOs to create corresponding utilization DTOs
		for(ILedgerHeaderDTO ledgerHeaderDTO : ledgerHeaderDTOList) {
			AccumsUtilizationDTO utilizationDTO = new AccumsUtilizationDTO(ledgerHeaderDTO);
			SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
			//Set the start date and end date to static values
			utilizationDTO.setStartDate(fmt.parse("01/01/2017"));
			utilizationDTO.setEndDate(fmt.parse("12/31/2017"));
			//set the limit to static value
			utilizationDTO.setLimit(10l);
			utilizationDTOList.add(utilizationDTO);
		}		
		return utilizationDTOList;		
	}
	
}
