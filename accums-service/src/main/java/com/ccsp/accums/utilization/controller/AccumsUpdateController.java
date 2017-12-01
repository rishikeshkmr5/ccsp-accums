/**
 * 
 */
package com.ccsp.accums.utilization.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.ledger.header.dto.AccumUtilization;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.utilization.service.IAccumsUpdateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author rtalapaneni
 *
 */
@Api(description = "Update Accums", produces = "application/json", tags = {"Update Accums"})
@RequestMapping(path = "update-accums")
@RestController
public class AccumsUpdateController {
	/**
	 * Logger for AccumsUpdateController
	 */
	private static Logger LOG = Logger.getLogger(AccumsUpdateController.class);
	
	@Autowired
	private IAccumsUpdateService updateService;
	
	/**
	 * Checks for the mandatory data and passes accum utilization details to service for persisting in database.
	 * @param accumUtilization {@link AccumUtilization}
	 * @return {@link LedgerHeaderDTO}
	 */
	@ApiOperation(value="Update Accums", tags = { "Update Accums" })
	@RequestMapping(path = "/update-accums", method = RequestMethod.POST, consumes = {"application/json; charset=utf-8"})
	@ResponseBody
	public String createLedgerHeader(@RequestBody AccumUtilization accumUtilization) throws Exception {
		LOG.info("Update accums utilization");
		updateService.updateAccums(accumUtilization);
		return "{'response' : 'success'}";
	}
}
