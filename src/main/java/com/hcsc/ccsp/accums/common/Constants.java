package com.hcsc.ccsp.accums.common;

public final class Constants {

	
	public final static String insertLedgerEntry = "INSERT into LDGR_ENTRY(PRIMY_LDGR_ENTRY_ID,LDGR_ID,ACCUM_TYP_NM,ROLE_NM,CST_SHR_TIER_NM,AMT,NTWK_CD,SNPSHT_SUM_AMT,UOM_NM,SVC_DT) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";; 
			
	public final static String insertLedgerSummary = "INSERT into LDGR_SUM(ACCUM_TYP_NM,MBR_ID,NTWK_CD,NTWK_TIER_NM,END_DT,EFF_DT,PLN_ID,SUB_ID,AMT,MAX_AMT,MAX_VST_CNT,UOM_NM) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";



}
