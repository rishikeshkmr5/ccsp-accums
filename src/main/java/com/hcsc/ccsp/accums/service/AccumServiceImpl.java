package com.hcsc.ccsp.accums.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;


@Service
@Transactional
public class AccumServiceImpl implements AccumService {

	@Autowired
	private LedgerService ledgerService;
	
	BigInteger generatedKeyLedgerHeader;
	BigInteger generatedKeyLedgerEntry;
	
	boolean isFirst;
	
	
	public void updateAccum(AccumUtilization accumUtilization)
	{
		generatedKeyLedgerHeader = ledgerService.insertLedgerHeaderGeneratedKey(accumUtilization);
	
		insertLedgerEntrySummary(accumUtilization);
	}

	
	public void insertLedgerEntrySummary(AccumUtilization accumUtilization) {

		isFirst = true;
		
		for (ServiceLine serviceLine : accumUtilization.getServiceLine()) {
			
			if (!isFirst) {
				ledgerService.insertLedgerEntry(serviceLine, generatedKeyLedgerHeader, generatedKeyLedgerEntry);
			}
			else
			{
				generatedKeyLedgerEntry = ledgerService.insertLedgerEntryGeneratedKey(serviceLine, generatedKeyLedgerHeader, BigInteger.valueOf(0));
				isFirst = false;
			}

	//		if summaryExists
			ledgerService.insertLedgerSummary(accumUtilization,serviceLine);
		}
	}
	
	
	public String greet() {
		return "Hello World";
	}
}