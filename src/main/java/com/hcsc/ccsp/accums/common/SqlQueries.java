package com.hcsc.ccsp.accums.common;

// This class defines reusable SQL query Strings
public final class SqlQueries {
	
	public static final String insertLedgerHeaderDbTable = "INSERT INTO " + DbTables.LDGR_HDR
			+ "(DCN, "
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
			+ "ACCUM_TYP_NM, "
			+ "VEND_XACTN_ID) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String insertLedgerEntryDbTable = "INSERT INTO " + DbTables.LDGR_ENTRY
			+ "(PRIMY_LDGR_ENTRY_ID, "
			+ "LDGR_ID, "
			+ "ACCUM_TYP_NM, "
			+ "ROLE_NM, "
			+ "CST_SHR_TIER_NM, "
			+ "AMT, "
			+ "NTWK_CD, "
			+ "SNPSHT_SUM_AMT, "
			+ "UOM_NM, "
			+ "SVC_DT) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	
	public static final String insertLedgerSummaryDbTable = "INSERT INTO " + DbTables.LDGR_SUM
			+ "(ACCUM_TYP_NM, "
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
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
