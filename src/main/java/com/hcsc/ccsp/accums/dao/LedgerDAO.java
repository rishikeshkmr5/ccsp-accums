package com.hcsc.ccsp.accums.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

public interface LedgerDAO {

	List < Object > findAll(String sValue);
	
	//long insertLedgerHeaderGK( Map<String, Object> parameters );
	BigInteger insertLedgerHeaderGK( AccumUtilization accumUtilization );
	
	//long insertLedgerEntryGK( Map<String, Object> parameters );
	BigInteger insertLedgerEntryGK( ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey );
	
	void insert(String sValue,  Object[] params );

	List<Map<String, Object>> getById(String sTable, String dbColumnName, String dbColumnValue);

	int resetAG(String sTable);
	
	int delete(String sTable, String sColumn);
	
}