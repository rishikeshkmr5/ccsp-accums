package com.ccsp.accums.utilization.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.utilization.dto.AccumsUtilizationDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;
import com.ccsp.common.utils.UIConstants;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
@RestController
public class AccumsUtilizationController {
	
	@Autowired
	private AccumsUtilizationService utilizationService;
	
	/**
	 * @param memberId
	 * @param subscriberId
	 * @return
	 * @throws ParseException
	 * @throws NotFoundException
	 * Gets the utilization summary for the given member id and subscriber id
	 */
	@RequestMapping(path = UIConstants.ACCUMS_UTILIZATION, method = RequestMethod.GET, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	@ResponseBody
	public List<AccumsUtilizationDTO> fetchAccumsUtilizationByMemberIdAndSubscriberId(@RequestParam(value="memberId", required=false) String memberId, @RequestParam(value="subscriberId", required=false) String subscriberId) throws ParseException, NotFoundException{
		//get the utilization summary for the given member and subscriber
		List<AccumsUtilizationDTO> utilizationHistory = utilizationService.getAccumsUtilization(memberId, subscriberId);
		//return the summary if it is not empty else return status 404
		if(CollectionUtils.isNotEmpty(utilizationHistory))
			return utilizationHistory;
		else
			throw new NotFoundException("Requested resource not found");
	}
}
