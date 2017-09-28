package com.ccsp.accums.ledger.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.common.utils.UIConstants;

import javassist.NotFoundException;


@RestController
public class AccumsController {
	
	private static Logger log = Logger.getLogger(AccumsController.class);

	
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public LedgerHeaderDTO getLedgerHeader() throws NotFoundException{
		log.info("Get all members accums details");
		LedgerHeaderDTO ledgerHeader = new LedgerHeaderDTO();
		ledgerHeader.setAllowedAmount(1000.50);
		ledgerHeader.setClaimLine(1l);
		ledgerHeader.setDataTimeProcessed(new Date());
		ledgerHeader.setDateOfService(new Date());
		ledgerHeader.setLedgerId(1l);
		ledgerHeader.setMember("A0001");
		ledgerHeader.setNetwork("INB");
		ledgerHeader.setNetworkTier("PPO");
		ledgerHeader.setPlanId(1l);
		ledgerHeader.setServiceId(10000l);
		ledgerHeader.setserviceName("Specialist Office Visit");
		ledgerHeader.setSubscriber("A0001");
		return ledgerHeader;
	}
	
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	@ResponseBody
	public void setLedgerHeader(@RequestBody LedgerHeaderDTO ledgerHeaderDTO){
		log.info("Set LedgerHeader details");
	}	
}