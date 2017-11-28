package com.hcsc.ccsp.accums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcsc.ccsp.accums.dao.LedgerDAO;
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
	

	@RequestMapping(value = "api/{table}/getById", method = { RequestMethod.POST })
	public Object getById(@PathVariable("table") String table, @RequestParam String dbColumnName, @RequestParam String dbColumnValue) {
		return ledgerService.getById(table, dbColumnName, dbColumnValue);
	}

}
