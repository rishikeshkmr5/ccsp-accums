package com.hcsc.ccsp.accums.service;

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
	
	long generatedKeyLedgerEntry = 0;
	
	boolean isFirst;
	
	
	public void updateAccum(AccumUtilization accumUtilization)
	{
		ledgerService.insertLedgerHeaderGeneratedKey(accumUtilization);
	
		insertLedgerEntrySummary(accumUtilization);
	}

	
	public void insertLedgerEntrySummary(AccumUtilization accumUtilization) {

		isFirst = true;
		
		for (ServiceLine serviceLine : accumUtilization.getServiceLine()) {
			
			if (!isFirst) {
				ledgerService.insertLedgerEntry(serviceLine, generatedKeyLedgerEntry);
			}
			else
			{
				generatedKeyLedgerEntry = ledgerService.insertLedgerEntryGeneratedKey(serviceLine);
				isFirst = false;
			}

			ledgerService.insertLedgerSummary(accumUtilization,serviceLine);
		}
	}
}