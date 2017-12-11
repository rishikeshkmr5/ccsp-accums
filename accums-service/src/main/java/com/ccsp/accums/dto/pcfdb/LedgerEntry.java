package com.ccsp.accums.dto.pcfdb;

import java.math.BigInteger;
import java.sql.Date;


public class LedgerEntry {

	private BigInteger LDGR_ENTRY_ID;
	private BigInteger PRIMY_LDGR_ENTRY_ID;
	private BigInteger LDGR_ID;
	private String ACCUM_TYP_NM;
	private String ROLE_NM;
	private String CST_SHR_TIER_NM;
	private double AMT;
	private String NTWK_CD;
	private double SNPSHT_SUM_AMT;
	private String UOM_NM;
	private Date SVC_DT;
	
	
	public LedgerEntry() {
		super();
	}


	@Override
	public String toString() {
		return "LedgerEntry [LDGR_ENTRY_ID=" + LDGR_ENTRY_ID + ", PRIMY_LDGR_ENTRY_ID=" + PRIMY_LDGR_ENTRY_ID
				+ ", LDGR_ID=" + LDGR_ID + ", ACCUM_TYP_NM=" + ACCUM_TYP_NM + ", ROLE_NM=" + ROLE_NM
				+ ", CST_SHR_TIER_NM=" + CST_SHR_TIER_NM + ", AMT=" + AMT + ", NTWK_CD=" + NTWK_CD + ", SNPSHT_SUM_AMT="
				+ SNPSHT_SUM_AMT + ", UOM_NM=" + UOM_NM + ", SVC_DT=" + SVC_DT + "]";
	}


	public BigInteger getLDGR_ENTRY_ID() {
		return LDGR_ENTRY_ID;
	}


	public void setLDGR_ENTRY_ID(BigInteger lDGR_ENTRY_ID) {
		LDGR_ENTRY_ID = lDGR_ENTRY_ID;
	}


	public BigInteger getPRIMY_LDGR_ENTRY_ID() {
		return PRIMY_LDGR_ENTRY_ID;
	}


	public void setPRIMY_LDGR_ENTRY_ID(BigInteger pRIMY_LDGR_ENTRY_ID) {
		PRIMY_LDGR_ENTRY_ID = pRIMY_LDGR_ENTRY_ID;
	}


	public BigInteger getLDGR_ID() {
		return LDGR_ID;
	}


	public void setLDGR_ID(BigInteger lDGR_ID) {
		LDGR_ID = lDGR_ID;
	}


	public String getACCUM_TYP_NM() {
		return ACCUM_TYP_NM;
	}


	public void setACCUM_TYP_NM(String aCCUM_TYP_NM) {
		ACCUM_TYP_NM = aCCUM_TYP_NM;
	}


	public String getROLE_NM() {
		return ROLE_NM;
	}


	public void setROLE_NM(String rOLE_NM) {
		ROLE_NM = rOLE_NM;
	}


	public String getCST_SHR_TIER_NM() {
		return CST_SHR_TIER_NM;
	}


	public void setCST_SHR_TIER_NM(String cST_SHR_TIER_NM) {
		CST_SHR_TIER_NM = cST_SHR_TIER_NM;
	}


	public double getAMT() {
		return AMT;
	}


	public void setAMT(double aMT) {
		AMT = aMT;
	}


	public String getNTWK_CD() {
		return NTWK_CD;
	}


	public void setNTWK_CD(String nTWK_CD) {
		NTWK_CD = nTWK_CD;
	}


	public double getSNPSHT_SUM_AMT() {
		return SNPSHT_SUM_AMT;
	}


	public void setSNPSHT_SUM_AMT(double sNPSHT_SUM_AMT) {
		SNPSHT_SUM_AMT = sNPSHT_SUM_AMT;
	}


	public String getUOM_NM() {
		return UOM_NM;
	}


	public void setUOM_NM(String uOM_NM) {
		UOM_NM = uOM_NM;
	}


	public Date getSVC_DT() {
		return SVC_DT;
	}


	public void setSVC_DT(Date sVC_DT) {
		SVC_DT = sVC_DT;
	}
}
