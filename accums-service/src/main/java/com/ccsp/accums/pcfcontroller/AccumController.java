package com.ccsp.accums.pcfcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.pcfservice.AccumService;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;

import net.sf.json.JSONObject;


@RestController
public class AccumController {

	@Autowired
	private AccumService accumService;
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String defaultMessage() {
	    return "Accum API";
    }
	
	@RequestMapping(value = "/greetings", method = { RequestMethod.GET })
	public String greetMessage() {
	    
		return accumService.greet();
	}
	
	
	@RequestMapping(value = "/api/updateAccum", method = { RequestMethod.POST })
	public Object updateAccum(@RequestBody AccumUtilization accumUtilization) {
		System.out.println("***********LedgerController.updateAccum-"+accumUtilization);
		accumService.updateAccum(accumUtilization);
		return JSONObject.fromObject("{'response' : 'success'}");
	}
	
	/*@RequestMapping(value = "/api/fetchsummaryAccum", method = { RequestMethod.GET })
	public List<SpendingSummaryDTO> getSummaryAccum(@RequestParam(value = "memberId", required = false) String memberId) {
		System.out.println("***********LedgerController.updateAccum-"+memberId);
		return accumService.getSummaryAccum(memberId);
	}
	
	@RequestMapping(value = "/api/fetchbenefitBAlance", method = { RequestMethod.GET })
	public List<LedgerSummaryDTO> getBenefitBalance(@RequestParam(value = "memberId", required = false) String memberId) {
		System.out.println("***********LedgerController.updateAccum-"+memberId);
		return accumService.getBenefitBalance(memberId);
	}
	
	@RequestMapping(value = "/api/getClaimDetailsByMemberIdAndAccumType", method = { RequestMethod.GET })
	public List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(
			@RequestParam(value = "accumType", required = true) String accumType,
			@RequestParam(value = "memberId", required = true) String memberID) {
		System.out.println("***********LedgerController.updateAccum-"+accumType + " " +memberID );
		return accumService.getClaimDetailsByMemberIdAndAccumType(accumType,memberID);
	}
	
	@RequestMapping(value = "/api/getClaim", method = { RequestMethod.GET })
	public ClaimDetailDTO getClaim(@RequestParam(value="claimID", required=true) String claimID) {
		System.out.println("***********LedgerController.updateAccum-"+claimID);
		return accumService.getClaim(claimID);
	}
	*/
	
	
	
	public AccumUtilization accumsUtilizationBuilder(String requestJson) throws JsonParseException, JsonMappingException, IOException {
		
		AccumUtilization au = new ObjectMapper().readValue(requestJson, AccumUtilization.class);
		return au;
	}
	
	
	//###################
	
	@RequestMapping(value = "/api/summaryAccums", method = { RequestMethod.GET })
	public List<SpendingSummaryDTO> summaryAccums(@RequestParam(value = "memberId", required = false) String memberId) {
		System.out.println("***********LedgerController.updateAccum-"+memberId);
		return accumService.summaryAccums(memberId);
	}
	
	
	
	@RequestMapping(value = "/api/benefitBalance", method = { RequestMethod.GET })
	public List<LedgerSummaryDTO> benefitBalance(@RequestParam(value = "memberId", required = false) String memberId) {
		System.out.println("***********LedgerController.benefitBalance-"+memberId);
		return accumService.benefitBalance(memberId);
	}
	
	@RequestMapping(value = "/api/claimDetailsByMemberIdAndAccumType", method = { RequestMethod.GET })
	public List<AccumsConsumptionDTO> claimDetailsByMemberIdAndAccumType(
			@RequestParam(value = "accumType", required = true) String accumType,
			@RequestParam(value = "memberId", required = true) String memberID) {
		System.out.println("***********LedgerController.claimDetailsByMemberIdAndAccumType-"+accumType + " " +memberID );
		return accumService.claimDetailsByMemberIdAndAccumType(accumType,memberID);
	}
	
	@RequestMapping(value = "/api/claimDetail", method = { RequestMethod.GET })
	public List<ClaimDetailDTO> claimDetail(@RequestParam(value = "claimID", required = false) String claimID) {
		System.out.println("***********LedgerController.claimDetail-"+claimID);
		return accumService.claimDetail(claimID);
	}
}