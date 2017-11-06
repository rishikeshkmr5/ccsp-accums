package com.ccsp.accums.rules;

import java.net.URI;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.accums.rules.dto.ClaimoperationRequest;
import com.ccsp.accums.rules.dto.ClaimoperationResponse;
import com.ccsp.common.rules.webservice.service.IRulesFactory;
import com.ccsp.common.rules.webservice.service.IRulesInvokerService;
import com.ccsp.common.utils.RulesConstants;
import com.ccsp.common.utils.UIConstants;

@RestController
public class RulesRestController {

	/**
	 * Logger for LedgerSummaryController
	 */
	private static Logger log = Logger.getLogger(RulesRestController.class);

	@Autowired
	IRulesFactory rulesFactory;

	/**
	 * This endpoint takes the claim request object , hits the REST endpoint of
	 * Rules engine server and returns the response.
	 * 
	 * @param request
	 *            REST request object
	 * @return ClaimoperationResponse
	 * @throws Exception
	 *             Exception thrown
	 * @author rishkumar
	 * 
	 */

	@RequestMapping(path = UIConstants.CLAIM, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ClaimoperationResponse getClaimResponse(@RequestBody ClaimoperationRequest request) throws Exception {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Defining the parameters which will be required while making the rest call
		URI url = new URI(
				"http://35.165.45.103:9080/DecisionService/rest/v1/ccspDeployment/1.0/claimoperation/1.0/WADL");
		HttpMethod method = HttpMethod.POST;

		ParameterizedTypeReference<ClaimoperationResponse> responseType = new ParameterizedTypeReference<ClaimoperationResponse>() {};

		HttpEntity<ClaimoperationRequest> requestEntity = new HttpEntity<ClaimoperationRequest>(request, headers);
		IRulesInvokerService rulesInvoker = rulesFactory.getRulesInvoker(RulesConstants.REST);
		log.info("Going to call ODM claim REST webservices with parameters: " + "Rest Endpoint Uri:" + url
				+ "\n Method: " + method + "\n Request+" + request.toString());

		ResponseEntity<?> rulesJson = rulesInvoker.getRulesJson(url, method, requestEntity, responseType);

		ClaimoperationResponse claimResponse = (ClaimoperationResponse) rulesJson.getBody();

		return claimResponse;
	}

}