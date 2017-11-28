package com.hcsc.ccsp.accums.common;

// This enum defines reusable SQL query Strings
public enum SqlQueries {

	
	insertLedgerHeader("INSERT INTO " + TableEntries.LedgerHeader.getTableName()
			+ "(LDGR_ID, "
			+ "DCN, "
			+ "CORP_ENT_CD, "
			+ "CLM_LN_ID, "
			+ "SVC_ID, "
			+ "SVC_NM, "
			+ "SVC_DT, "
			+ "PROC_DT, "
			+ "NTWK_CD, "
			+ "NTWK_TIER_NM, "
			+ "PLN_ID, "
			+ "ALWD_AMT, "
			+ "MBR_ID, "
			+ "SUB_ID, "
			+ "UOM_NM, "
			+ "VEND_XACTN_ID) "
			+ "VALUES (LDGR_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),   
	insertLedgerEntry("INSERT INTO " + TableEntries.LedgerEntry.getTableName()
			+ "(LDGR_ENTRY_ID, "
			+ "PRIMY_LDGR_ENTRY_ID, "
			+ "LDGR_ID, "
			+ "ACCUM_TYP_NM, "
			+ "ROLE_NM, "
			+ "CST_SHR_TIER_NM, "
			+ "AMT, "
			+ "NTWK_CD, "
			+ "SNPSHT_SUM_AMT, "
			+ "UOM_NM, "
			+ "SVC_DT) "
			+ "VALUES (LDGR_ENTRY_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
	insertLedgerSummary("INSERT INTO " + TableEntries.LedgerSummary.getTableName()
			+ "(LDGR_SUM_ID, "
			+ "ACCUM_TYP_NM, "
			+ "MBR_ID, "
			+ "NTWK_CD, "
			+ "NTWK_TIER_NM, "
			+ "END_DT, "
			+ "EFF_DT, "
			+ "PLN_ID, "
			+ "SUB_ID, "
			+ "AMT, "
			+ "MAX_AMT, "
			+ "MAX_VST_CNT, "
			+ "UOM_NM) "
			+ "VALUES (LDGR_SUM_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	
	
	private String sql;
	
	SqlQueries(String sql) {
		this.sql = sql;
	}

	
	public String getSql() {
		return sql;
	}
}


