package com.hcsc.ccsp.accums.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.service.AccumService;

import net.sf.json.JSONObject;


@RestController
public class AccumController {

	@Autowired
	private AccumService accumService;
	
	
	@RequestMapping(value = "/api/updateAccum", method = { RequestMethod.POST })
	public Object updateAccum(@RequestBody String requestJson) {
		System.out.println("***********LedgerController.updateAccum-"+requestJson);

		try {
			accumService.updateAccum(accumsUtilizationBuilder(requestJson));
		
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSONObject.fromObject("{'response' : 'success'}");
	}
	
	public AccumUtilization accumsUtilizationBuilder(String requestJson) throws JsonParseException, JsonMappingException, IOException {
		
		AccumUtilization au = new ObjectMapper().readValue(requestJson, AccumUtilization.class);
		return au;
	}
}