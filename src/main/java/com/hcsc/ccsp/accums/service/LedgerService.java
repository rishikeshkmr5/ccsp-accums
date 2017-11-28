package com.hcsc.ccsp.accums.service;

import java.util.List;
import java.util.Map;

import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

public interface LedgerService {

	long insertLedgerHeaderGeneratedKey(AccumUtilization accumUtilization);

	long insertLedgerEntryGeneratedKey(ServiceLine serviceLine);

	void insertLedgerEntry(ServiceLine serviceLine, long id);

	void insertLedgerSummary(AccumUtilization accumUtilization, ServiceLine serviceLine);

	List<Map<String, Object>> getMemberHeaderRows(String dbColumnName, String dbColumnValue);

	List<Map<String, Object>> getMemberEntryRows(String dbColumnName, String dbColumnValue);

	List<Map<String, Object>> getMemberSummaryRows(String dbColumnName, String dbColumnValue);

	// Accum Inquiry API
	Object getLedgerHeader(String dbColumnName, String dbColumnValue);

	Object getLedgerEntry(String dbColumnName, String dbColumnValue);

	Object getLedgerSummary(String dbColumnName, String dbColumnValue);

}
