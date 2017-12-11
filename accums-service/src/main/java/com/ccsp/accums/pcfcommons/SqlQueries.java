package com.ccsp.accums.pcfcommons;

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
			+ "VALUES (LDGR_SUM_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
	selectLedgerHeader("SELECT * FROM " +TableEntries.LedgerHeader.getTableName() +
			" WHERE MBR_ID = ?"),
	selectLedger("SELECT l.MBR_ID as memberId,l.SUB_ID as subscriberId,l.NTWK_CD as networkCode,l.SVC_NM  as serviceName," + 
			"l.ALWD_AMT as allowedAmount FROM " +TableEntries.LedgerHeader.getTableName() + " l WHERE l.MBR_ID = ?"),
	selectLedgerSummary("SELECT * FROM " +TableEntries.LedgerSummary.getTableName() +
			" WHERE MBR_ID = ?"),
	selectSummary("SELECT l.MBR_ID as memberId,l.SUB_ID as subscriberId,l.ACCUM_TYP_NM as accumType,l.EFF_DT as EffectiveDate,l.END_DT as endDate," + 
			"l.NTWK_CD as networkCode,l.AMT as amount,l.MAX_AMT as maxAmount  FROM " + TableEntries.LedgerSummary.getTableName() + " l WHERE l.MBR_ID = ?"),
	selectLedgerHeaderAndEntry("SELECT * FROM " + TableEntries.LedgerEntry.getTableName() + " c," +TableEntries.LedgerHeader.getTableName() + " h where c.LDGR_ID  = h.LDGR_ID and c.ACCUM_TYP_NM = ? and h.MBR_ID = ?"),
	selectHeaderAndEntry("SELECT c.ACCUM_TYP_NM as accumType,l.ALWD_AMT as allowedAmount,c.AMT as amount,l.DCN as dcn,l.MBR_ID as memberId," + 
			"l.NTWK_CD as networkCode,l.PROC_DT as processedDate,l.SVC_DT as serviceDate,l.SUB_ID as subscriberId FROM " + TableEntries.LedgerEntry.getTableName() + " c," +TableEntries.LedgerHeader.getTableName() + " l where c.LDGR_ID  = l.LDGR_ID and c.ACCUM_TYP_NM = ? and l.MBR_ID = ?"),
	selectClaimFromLedgerHeader("SELECT * FROM " +TableEntries.LedgerHeader.getTableName() + " l where l.DCN = ?"),
	selectClaim("SELECT l.ALWD_AMT as amount,l.DCN as claim,l.CLM_LN_ID as claimLine,l.MBR_ID as member,l.NTWK_CD as network," + 
			"l.PROC_DT as processedDt,l.SVC_NM  as service,l.SVC_DT as serviceDt,l.SUB_ID as subscriber FROM " +TableEntries.LedgerHeader.getTableName() + " l where l.DCN = ?")
	;
	
	
	private String sql;
	
	SqlQueries(String sql) {
		this.sql = sql;
	}

	
	public String getSql() {
		return sql;
	}
}


