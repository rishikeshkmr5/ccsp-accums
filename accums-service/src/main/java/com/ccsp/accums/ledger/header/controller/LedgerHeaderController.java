package com.ccsp.accums.ledger.header.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.ValidationException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsp.accums.ledger.benefit.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.benefit.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.benefit.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.benefit.service.BenefitBalanceServiceImpl;
import com.ccsp.accums.ledger.benefit.service.BenefitSpendingServiceImpl;
import com.ccsp.accums.ledger.benefit.service.ClaimDetailServiceImpl;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryClaimDTO;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderClaimDTO;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.utils.UIConstants;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

/**
 * This controller holds the methods to perform CURD operations on ledger
 * header.
 * 
 * @author nnarayanaperumaln
 *
 */
@RestController
public class LedgerHeaderController {
	/**
	 * Logger for AccumsController
	 */
	private static Logger log = Logger.getLogger(LedgerHeaderController.class);
	

	@Autowired
	private LedgerHeaderService accumulationHeaderService;

	@Autowired
	private BenefitBalanceServiceImpl benefitBalanceServiceImpl;
	
	@Autowired
	private ClaimDetailServiceImpl claimDetailServiceImpl;

	@Autowired
	private BenefitSpendingServiceImpl benefitSpendingServiceImpl;
	
	private Validator validator = new Validator();

	/**
	 * Fetches all the ledgerHeaders
	 * 
	 * @return LedgerHeaders
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<LedgerHeaderDTO> getLedgerHeader() throws NotFoundException {
		log.info("Get all members accums details");
		return accumulationHeaderService.readAll();
	}

	/**
	 * Persist the received LedgerHeader Details
	 * @param ledgerHeaderDTO
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.POST, consumes = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public LedgerHeaderDTO createLedgerHeader(@RequestBody LedgerHeaderClaimDTO claimsForAccumulationHeaderDTO) {
		log.info("Create LedgerHeader details");
		LedgerHeaderDTO accumulationHeaderDTO = claimsForAccumulationHeaderDTO.getAccumulationHeaderDTO();
		validator.validate(accumulationHeaderDTO);
		return accumulationHeaderService.create(accumulationHeaderDTO);
	}

	
	

	/**
	 * Fetches benefit balance details based on subscriber or member id
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.BENEFIT_BALANCE, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	public @ResponseBody List<BenefitBalanceDTO> getBenefitBalanceBySubscriberOrMemberId(
			@RequestParam(value="subscriberid", required=false) String subscriberID, @RequestParam(value="memberid", required=false) String memberID)
			throws NotFoundException {
		log.info("Benefit balance details based on subscriber or member id");
		return benefitBalanceServiceImpl.getBenefitBalance(subscriberID, memberID);

	}
	
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
	
	@RequestMapping(value = "/fileupload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
    public @ResponseBody void upload(@RequestParam("file") MultipartFile inputFile){
           LedgerHeaderDTO header = new LedgerHeaderDTO();
           if (!inputFile.isEmpty()) {       
        	   ByteArrayInputStream stream = null;
			try {
				stream = new   ByteArrayInputStream(inputFile.getBytes());
				//extension = IOUtils.toString(stream, "UTF-8");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				JAXBContext context = JAXBContext.newInstance(LedgerHeaderDTO.class);
			    Unmarshaller unmarshaller = context.createUnmarshaller();
			    header = (LedgerHeaderDTO) unmarshaller.unmarshal(stream);
               
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
           accumulationHeaderService.create(header);
    }
}