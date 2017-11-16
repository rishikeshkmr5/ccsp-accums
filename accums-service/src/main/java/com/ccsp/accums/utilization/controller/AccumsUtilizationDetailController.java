package com.ccsp.accums.utilization.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.utilization.dto.AccumUtilizationDetailDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;
import com.ccsp.common.utils.UIConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;


@Api(description = UIConstants.API_ACCUMS_UTILIZATION_DETAIL, produces = "application/json", tags = {
		UIConstants.API_ACCUMS_UTILIZATION_DETAIL_TAG }, hidden = true)
@RestController
public class AccumsUtilizationDetailController {
	
	@Autowired
	AccumsUtilizationService accumsUtilizationService;
	
	
	@ApiOperation(value = UIConstants.API_CATEGORY_TYPE_INQUIRE, tags = { UIConstants.API_ACCUMS_UTILIZATION_DETAIL_TAG }, hidden = false)
	@RequestMapping(path = UIConstants.UI_INQUIRY, method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	
	@ResponseBody
	public List<AccumUtilizationDetailDTO>  getAccumsUtilizationDetail(@PathVariable("subscriberID") String subscriberID) throws NotFoundException, ParseException{
		return accumsUtilizationService.getAccumsUtilizationDetail(subscriberID);
			
	}
	
}
