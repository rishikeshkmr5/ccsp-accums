package com.ccsp.accums.ledger.header.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsp.accums.ledger.header.dto.AccumUtilization;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.common.utils.UIConstants;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

/**
 * Ledger header controller exposes the API end points to handle CRUD operations on ledger header.
 * 
 * @author nnarayanaperumaln
 *
 */
@RestController
public class LedgerHeaderController {
	/**
	 * Logger for LedgerHeaderController.
	 */
	private static Logger log = Logger.getLogger(LedgerHeaderController.class);
	
	@Autowired
	private LedgerHeaderService accumulationHeaderService;

	/**
	 * Validates the availability of required information in request.
	 */
	private Validator validator = new Validator();
	
	/**
	 * Checks for the mandatory data and passes accum utilization details to service for persisting in database.
	 * 
	 * @param accumUtilization {@link AccumUtilization}
	 * @return {@link LedgerHeaderDTO}
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.POST
			, consumes = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public LedgerHeaderDTO createLedgerHeader(@RequestBody AccumUtilization accumUtilization) {
		log.info("Create LedgerHeader details");
		
		//Perform mandatory fields validation
		validator.validate(accumUtilization);
		
		return accumulationHeaderService.create(accumUtilization);
	}
	

	/**
	 * Fetches all the available ledger header details.
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

	@RequestMapping(value = "/fileupload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
    public @ResponseBody void upload(@RequestParam("file") MultipartFile inputFile){
           LedgerHeaderDTO header = new LedgerHeaderDTO();
           if (!inputFile.isEmpty()) {       
        	   ByteArrayInputStream stream = null;
			try {
				stream = new   ByteArrayInputStream(inputFile.getBytes());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				JAXBContext context = JAXBContext.newInstance(LedgerHeaderDTO.class);
			    Unmarshaller unmarshaller = context.createUnmarshaller();
			    header = (LedgerHeaderDTO) unmarshaller.unmarshal(stream);
               
			} catch (JAXBException e) {
				e.printStackTrace();
			}
           }
           accumulationHeaderService.create(header);
    }
	
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.PUT, consumes = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public LedgerHeaderDTO updateLedgerHeader(@RequestBody AccumUtilization claimsForAccumulationHeaderDTO) {
		log.info("Create LedgerHeader details");
		LedgerHeaderDTO accumulationHeaderDTO = claimsForAccumulationHeaderDTO;
		return accumulationHeaderService.update(accumulationHeaderDTO);
	}
}