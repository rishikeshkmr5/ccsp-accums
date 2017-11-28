package com.hcsc.ccsp.accums.dao;

import java.util.List;
import java.util.Map;

public interface LedgerDAO {

	List < Object > findAll(String sValue);
	
	long insertLedgerHeaderGK( Map<String, Object> parameters );
	
	long insertLedgerEntryGK( Map<String, Object> parameters );
	
	void insert(String sValue,  Object[] params );
}
