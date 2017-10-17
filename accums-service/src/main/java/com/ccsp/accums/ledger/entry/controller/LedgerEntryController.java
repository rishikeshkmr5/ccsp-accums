package com.ccsp.accums.ledger.entry.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryClaimDTO;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.utils.UIConstants;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

@RestController
public class LedgerEntryController {

	/**
	 * Logger for LedgerEntryController
	 */
	private static Logger log = Logger.getLogger(LedgerEntryController.class);
	
	@Autowired
	private LedgerEntryService ledgerEntryService;
	
	private Validator validator = new Validator();

	/**
	 * Persist the received LedgerEntry Details
	 * 
	 * @param ledgerEntryDTO
	 */
	@RequestMapping(path = UIConstants.ACCUMS_ENTRY, method = RequestMethod.POST, consumes = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<LedgerEntryDTO> createLedgerEntry(@RequestBody LedgerEntryClaimDTO claimAccumEntry) throws ValidationException{
		log.info("Create LedgerEntry details");
		MDC.put("username", "ABC");
		List<? extends ICommonDTO> accumsEntry = claimAccumEntry.getAccumEntryList();
		validator.validate(accumsEntry);
		return ledgerEntryService.create(accumsEntry);
	}

	/**
	 * Fetches all the ledgerEntries
	 * 
	 * @return LedgerEntries
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.ACCUMS_ENTRY, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<LedgerEntryDTO> getLedgerEntry() throws NotFoundException {
		log.info("Get LedgerEntry details");
		return ledgerEntryService.readAll();
	}

}
