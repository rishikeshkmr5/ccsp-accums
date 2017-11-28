package com.hcsc.ccsp.accums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcsc.ccsp.accums.dao.LedgerDAO;
import com.hcsc.ccsp.accums.dao.LedgerDAOImpl;
import com.hcsc.ccsp.accums.service.AccumService;
import com.hcsc.ccsp.accums.service.LedgerService;


@RestController
public class LedgerController {

	@Autowired
	private LedgerDAO ledgerDao;
	
	@Autowired
	private LedgerService ledgerService;
	
	
	@RequestMapping(value = "/api/{table}/list", method = { RequestMethod.GET })
	public Object getList(@PathVariable("table") String table) {
	    System.out.println("***********LedgerController.get("+table+")");

	    return ledgerDao.findAll(table);
    }
	
	// Accum Inquiry API request mappings
	@RequestMapping(value = "api/inquiryLedgerHeaderDbTable", method = { RequestMethod.POST })
	public Object getInquiryHeaderDbTable(@RequestBody String dbColumnName, String dbColumnValue) {
		return ledgerService.getLedgerHeader(dbColumnName, dbColumnValue);
	}
	
	@RequestMapping(value = "api/inquiryLedgerEntryDbTable", method = { RequestMethod.POST })
	public Object getInquiryEntryDbTable(@RequestBody String dbColumnName, String dbColumnValue) {
		return ledgerService.getLedgerEntry(dbColumnName, dbColumnValue);
	}
	
	@RequestMapping(value = "api/inquiryLedgerSummaryDbTable", method = { RequestMethod.POST })
	public Object getInquirySummaryDbTable(@RequestBody String dbColumnName, String dbColumnValue) {
		return ledgerService.getLedgerSummary(dbColumnName, dbColumnValue);
	}
}
