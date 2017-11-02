package com.ccsp.accums.ledger.benefit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.benefit.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.benefit.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.benefit.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.benefit.service.BenefitBalanceServiceImpl;
import com.ccsp.accums.ledger.benefit.service.BenefitSpendingServiceImpl;
import com.ccsp.accums.ledger.benefit.service.ClaimDetailServiceImpl;
import com.ccsp.common.utils.UIConstants;

import javassist.NotFoundException;

/**
 * This controller holds the methods to perform read operations on ledger
 * benefit.
 * 
 * @author rtalapaneni
 *
 */
@RestController
public class LedgerBenefitController {
	/**
	 * Logger for LedgerBenefitController
	 */
	private static Logger log = Logger.getLogger(LedgerBenefitController.class);
	
	@Autowired
	private BenefitBalanceServiceImpl benefitBalanceServiceImpl;
	
	@Autowired
	private ClaimDetailServiceImpl claimDetailServiceImpl;

	@Autowired
	private BenefitSpendingServiceImpl benefitSpendingServiceImpl;
	
	/**
	 * Fetches benefit balance details based on subscriber or member id
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	/*@RequestMapping(path = UIConstants.BENEFIT_BALANCE, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	public @ResponseBody List<BenefitBalanceDTO> getBenefitBalanceBySubscriberOrMemberId(
			@RequestParam(value="subscriberid", required=false) String subscriberID, @RequestParam(value="memberid", required=false) String memberID)
			throws NotFoundException {
		log.info("Benefit balance details based on subscriber or member id");
		return benefitBalanceServiceImpl.getBenefitBalance(subscriberID, memberID);

	}*/
	
	@RequestMapping(path = UIConstants.CLAIIMS_ASSOCIATED_TO_ACCUMS, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<ClaimDetailsForAccumTypeDTO> getClaimsAssociatedToAccums(@PathVariable("accumType") String accumType) throws NotFoundException {
		log.info("Get all claim details related to accums type");
		return claimDetailServiceImpl.getClaimDetail(accumType);
		
	}
	
	/**
	 * Fetches benefit spending details based on member id
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.BENEFIT_SPENDING, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	public @ResponseBody List<BenefitSpendingDTO> getBenefitSpendingByMemberId(
			@RequestParam("memberid") String memberID)
			throws NotFoundException {
		log.info("Benefit spending details based on member id");
		return benefitSpendingServiceImpl.getBenefitSpending(memberID);

	}	
}