package com.ccsp.accums.ledger.summary.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.utils.UIConstants;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

@RestController
public class LedgerSummaryController {

	/**
	 * Logger for LedgerSummaryController
	 */
	private static Logger log = Logger.getLogger(LedgerSummaryController.class);
	
	@Autowired
	private LedgerSummaryService accumulationSummaryService;
	
	private Validator validator = new Validator();
	
	/**
	 * Fetches all the accumulation summary
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.ACCUMULATION_SUMMARY, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<LedgerSummaryDTO> getAccumulationSummary() throws NotFoundException {
		log.info("Get all members accums summary details");
		return accumulationSummaryService.readAll();
	}

	/**
	 * Persist the received accumulation summary Details
	 * 
	 * @param accumulationSummaryDTO
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping(path = UIConstants.ACCUMULATION_SUMMARY, method = RequestMethod.POST, consumes = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public LedgerSummaryClaimDTO createAccumulationSummary(
			@RequestBody LedgerSummaryClaimDTO accumulationSummaryDTO) throws NotFoundException {
		log.info("Create AccumulationSummary details");
		List<? extends ICommonDTO> accumsSummary = accumulationSummaryDTO.getAccumulationSummaryList();
		validator.validate(accumsSummary);
		return accumulationSummaryService.createClaimSummary(accumulationSummaryDTO);
	}
	
}