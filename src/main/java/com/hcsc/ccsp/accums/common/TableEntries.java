package com.hcsc.ccsp.accums.common;

import com.hcsc.ccsp.accums.dto.db.LedgerEntry;
import com.hcsc.ccsp.accums.dto.db.LedgerHeader;
import com.hcsc.ccsp.accums.dto.db.LedgerSummary;

public enum TableEntries {
	
	LedgerHeader("LDGR_HDR",LedgerHeader.class),
	LedgerEntry("LDGR_ENTRY",LedgerEntry.class),
	LedgerSummary("LDGR_SUM",LedgerSummary.class);
		
	private final String tableName;
	private final Class<?> tableClass;

	private TableEntries(String tableName, Class<?> tableClass) {
		this.tableName = tableName;
		this.tableClass = tableClass;
	}
	public String getTableName() {
		return tableName;
	}
	public Class<?> getTableClass() {
		return tableClass;
	}
	
}
