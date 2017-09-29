package com.ccsp.accums.ledger.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.service.LedgerHeaderService;
import com.ccsp.common.utils.UIConstants;

import javassist.NotFoundException;


/**
 * @author nnarayanaperumaln
 *
 */
@RestController
public class AccumsController {
	
	/**
	 * Logger for AccumsController 
	 */
	private static Logger log = Logger.getLogger(AccumsController.class);


	@Autowired
	private LedgerHeaderService ledgerHeaderService;
 	
	/**
	 * Fetches all the ledgerHeaders 
	 * @return LedgerHeaders
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<LedgerHeaderDTO> getLedgerHeader() throws NotFoundException{
		log.info("Get all members accums details");
		return ledgerHeaderService.getAllLedgerHeader();
	}
	
	/**
	 * Persist the received LedgerHeader Details
	 * @param ledgerHeaderDTO
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	@ResponseBody
	public void createLedgerHeader(@RequestBody LedgerHeaderDTO ledgerHeaderDTO){
		log.info("Create LedgerHeader details");
		ledgerHeaderService.setLedgerHeader(ledgerHeaderDTO);
	}	
}