package com.hcsc.ccsp.accums.service;

import java.math.BigInteger;

import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

public interface LedgerService {

	BigInteger insertLedgerHeaderGeneratedKey( AccumUtilization accumUtilization );

	BigInteger insertLedgerEntryGeneratedKey( ServiceLine serviceLine, BigInteger headerKey, BigInteger EntryKey );

	void insertLedgerEntry( ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey );

	void insertLedgerSummary( AccumUtilization accumUtilization, ServiceLine serviceLine );

	Object getById( String sTable, String dbColumnName, String dbColumnValue );
}
