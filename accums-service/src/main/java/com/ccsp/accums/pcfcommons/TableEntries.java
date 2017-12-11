package com.ccsp.accums.pcfcommons;

import com.ccsp.accums.dto.pcfdb.LedgerEntry;
import com.ccsp.accums.dto.pcfdb.LedgerHeader;
import com.ccsp.accums.dto.pcfdb.LedgerSummary;

public enum TableEntries {
	
	LedgerHeader("LDGR_HDR","LDGR_ID",LedgerHeader.class),
	LedgerEntry("LDGR_ENTRY","LDGR_ENTRY_ID",LedgerEntry.class),
	LedgerSummary("LDGR_SUM","LDGR_SUM_ID",LedgerSummary.class);
		
	private final String tableName;
	private final String tableId;
	private final Class<?> tableClass;

	private TableEntries(String tableName, String tableId, Class<?> tableClass) {
		this.tableName = tableName;
		this.tableId = tableId;
		this.tableClass = tableClass;
	}
	public String getTableName() {
		return tableName;
	}
	public String getTableId() {
		return tableId;
	}
	public Class<?> getTableClass() {
		return tableClass;
	}
	
}
