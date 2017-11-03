package com.ccsp.accums.utilization.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;
import com.ccsp.common.utils.UIConstants;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 * Gets the utilization summary for the given member id and subscriber id
 * Fetches benefit balance details based on subscriber or member id
 */
@RequestMapping(path = UIConstants.ACCUMS_INQUIRY)
@RestController
public class AccumsUtilizationController {

	@Autowired
	private AccumsUtilizationService utilizationService;

	@Autowired
	private LedgerSummaryService accumulationSummaryService;

	/**
	 * Gets the utilization summary for the given member id and subscriber id
	 * @param memberId
	 * @param subscriberId
	 * @return
	 * @throws ParseException
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.ACCUMS_UTILIZATION, method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public List<SpendingSummaryDTO> getSpendingSummary(
			@RequestParam(value = "memberId", required = false) String memberId,
			@RequestParam(value = "subscriberId", required = false) String subscriberId)
			throws ParseException, NotFoundException {
		// check for input validation if both parameters are empty return status 400 for Bad request
		if (StringUtils.isEmpty(memberId) && StringUtils.isEmpty(subscriberId))
			throw new ValidationException("Atleast one member or subscriber id is required");
		// get the utilization summary for the given member and subscriber
		List<SpendingSummaryDTO> utilizationHistory = utilizationService.getSpendingSummary(memberId, subscriberId);
		// return the summary if it is not empty else return status 404
		if (CollectionUtils.isNotEmpty(utilizationHistory))
			return utilizationHistory;
		else
			throw new NotFoundException("Requested resource not found");
	}

	/**
	 * Fetches benefit balance details based on subscriber or member id
	 * 
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.BENEFIT_BALANCE, method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	public @ResponseBody List<LedgerSummaryDTO> getLedgerSummaryBalance(
			@RequestParam(value = "subscriberId", required = false) String subscriberID,
			@RequestParam(value = "memberId", required = false) String memberID) throws NotFoundException {
		// check for input validation if both parameters are empty return status 400 for
		// Bad request
		if (StringUtils.isEmpty(subscriberID) && StringUtils.isEmpty(memberID))
			throw new ValidationException("Atleast one member or subscriber id is required");

		// get benefit balance based by member or subscriber id
		List<LedgerSummaryDTO> utilizationHistory = accumulationSummaryService.getBenefitBalance(subscriberID,
				memberID);
		// return the summary if it is not empty else return status 404
		if (CollectionUtils.isNotEmpty(utilizationHistory))
			return utilizationHistory;
		else
			throw new NotFoundException("Requested resource not found");
	}

}
