package com.hcsc.ccsp.accums.dto.db;

import java.math.BigInteger;
import java.sql.Date;


public class LedgerHeader {
	 
	private BigInteger LDGR_ID;
	private String DCN;
	private String CORP_ENT_CD;
	private int CLM_LN_ID;
	private int SVC_ID;
	private String SVC_NM;
	private Date SVC_DT;
	private Date PROC_DT;
	private String NTWK_CD;
	private String NTWK_TIER_NM;
	private int PLN_ID;
	private double ALWD_AMT;
	private String MBR_ID;
	private String SUB_ID;
	private String UOM_NM;
	private String VEND_XACTN_ID;
	
	
	public LedgerHeader() {
		super();
	}


	@Override
	public String toString() {
		return "LedgerHeader [LDGR_ID=" + LDGR_ID + ", DCN=" + DCN + ", CORP_ENT_CD=" + CORP_ENT_CD + ", CLM_LN_ID="
				+ CLM_LN_ID + ", SVC_ID=" + SVC_ID + ", SVC_NM=" + SVC_NM + ", SVC_DT=" + SVC_DT + ", PROC_DT="
				+ PROC_DT + ", NTWK_CD=" + NTWK_CD + ", NTWK_TIER_NM=" + NTWK_TIER_NM + ", PLN_ID=" + PLN_ID
				+ ", ALWD_AMT=" + ALWD_AMT + ", MBR_ID=" + MBR_ID + ", SUB_ID=" + SUB_ID + ", UOM_NM=" + UOM_NM
				+ ", VEND_XACTN_ID=" + VEND_XACTN_ID + "]";
	}


	public BigInteger getLDGR_ID() {
		return LDGR_ID;
	}


	public void setLDGR_ID(BigInteger lDGR_ID) {
		LDGR_ID = lDGR_ID;
	}


	public String getDCN() {
		return DCN;
	}


	public void setDCN(String dCN) {
		DCN = dCN;
	}


	public String getCORP_ENT_CD() {
		return CORP_ENT_CD;
	}


	public void setCORP_ENT_CD(String cORP_ENT_CD) {
		CORP_ENT_CD = cORP_ENT_CD;
	}


	public int getCLM_LN_ID() {
		return CLM_LN_ID;
	}


	public void setCLM_LN_ID(int cLM_LN_ID) {
		CLM_LN_ID = cLM_LN_ID;
	}


	public int getSVC_ID() {
		return SVC_ID;
	}


	public void setSVC_ID(int sVC_ID) {
		SVC_ID = sVC_ID;
	}


	public String getSVC_NM() {
		return SVC_NM;
	}


	public void setSVC_NM(String sVC_NM) {
		SVC_NM = sVC_NM;
	}


	public Date getSVC_DT() {
		return SVC_DT;
	}


	public void setSVC_DT(Date sVC_DT) {
		SVC_DT = sVC_DT;
	}


	public Date getPROC_DT() {
		return PROC_DT;
	}


	public void setPROC_DT(Date pROC_DT) {
		PROC_DT = pROC_DT;
	}


	public String getNTWK_CD() {
		return NTWK_CD;
	}


	public void setNTWK_CD(String nTWK_CD) {
		NTWK_CD = nTWK_CD;
	}


	public String getNTWK_TIER_NM() {
		return NTWK_TIER_NM;
	}


	public void setNTWK_TIER_NM(String nTWK_TIER_NM) {
		NTWK_TIER_NM = nTWK_TIER_NM;
	}


	public int getPLN_ID() {
		return PLN_ID;
	}


	public void setPLN_ID(int pLN_ID) {
		PLN_ID = pLN_ID;
	}


	public double getALWD_AMT() {
		return ALWD_AMT;
	}


	public void setALWD_AMT(double aLWD_AMT) {
		ALWD_AMT = aLWD_AMT;
	}


	public String getMBR_ID() {
		return MBR_ID;
	}


	public void setMBR_ID(String mBR_ID) {
		MBR_ID = mBR_ID;
	}


	public String getSUB_ID() {
		return SUB_ID;
	}


	public void setSUB_ID(String sUB_ID) {
		SUB_ID = sUB_ID;
	}


	public String getUOM_NM() {
		return UOM_NM;
	}


	public void setUOM_NM(String uOM_NM) {
		UOM_NM = uOM_NM;
	}


	public String getVEND_XACTN_ID() {
		return VEND_XACTN_ID;
	}


	public void setVEND_XACTN_ID(String vEND_XACTN_ID) {
		VEND_XACTN_ID = vEND_XACTN_ID;
	}


	
}
	