package com.hcsc.ccsp.accums.dto.db;

import java.math.BigInteger;
import java.sql.Date;


public class LedgerSummary {

	private BigInteger LDGR_SUM_ID;
	private String ACCUM_TYP_NM;
	private String MBR_ID;
	private String NTWK_CD;
	private String NTWK_TIER_NM;
	private Date END_DT;
	private Date EFF_DT;
	private int PLN_ID;
	private String SUB_ID;
	private double AMT;
	private double MAX_AMT;
	private int MAX_VST_CNT;
	private String UOM_NM;
	
	
	public LedgerSummary() {
		super();
	}


	@Override
	public String toString() {
		return "LedgerSummary [LDGR_SUM_ID=" + LDGR_SUM_ID + ", ACCUM_TYP_NM=" + ACCUM_TYP_NM + ", MBR_ID=" + MBR_ID
				+ ", NTWK_CD=" + NTWK_CD + ", NTWK_TIER_NM=" + NTWK_TIER_NM + ", END_DT=" + END_DT + ", EFF_DT="
				+ EFF_DT + ", PLN_ID=" + PLN_ID + ", SUB_ID=" + SUB_ID + ", AMT=" + AMT + ", MAX_AMT=" + MAX_AMT
				+ ", MAX_VST_CNT=" + MAX_VST_CNT + ", UOM_NM=" + UOM_NM + "]";
	}


	public BigInteger getLDGR_SUM_ID() {
		return LDGR_SUM_ID;
	}


	public void setLDGR_SUM_ID(BigInteger lDGR_SUM_ID) {
		LDGR_SUM_ID = lDGR_SUM_ID;
	}


	public String getACCUM_TYP_NM() {
		return ACCUM_TYP_NM;
	}


	public void setACCUM_TYP_NM(String aCCUM_TYP_NM) {
		ACCUM_TYP_NM = aCCUM_TYP_NM;
	}


	public String getMBR_ID() {
		return MBR_ID;
	}


	public void setMBR_ID(String mBR_ID) {
		MBR_ID = mBR_ID;
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


	public Date getEND_DT() {
		return END_DT;
	}


	public void setEND_DT(Date eND_DT) {
		END_DT = eND_DT;
	}


	public Date getEFF_DT() {
		return EFF_DT;
	}


	public void setEFF_DT(Date eFF_DT) {
		EFF_DT = eFF_DT;
	}


	public int getPLN_ID() {
		return PLN_ID;
	}


	public void setPLN_ID(int pLN_ID) {
		PLN_ID = pLN_ID;
	}


	public String getSUB_ID() {
		return SUB_ID;
	}


	public void setSUB_ID(String sUB_ID) {
		SUB_ID = sUB_ID;
	}


	public double getAMT() {
		return AMT;
	}


	public void setAMT(double aMT) {
		AMT = aMT;
	}


	public double getMAX_AMT() {
		return MAX_AMT;
	}


	public void setMAX_AMT(double mAX_AMT) {
		MAX_AMT = mAX_AMT;
	}


	public int getMAX_VST_CNT() {
		return MAX_VST_CNT;
	}


	public void setMAX_VST_CNT(int mAX_VST_CNT) {
		MAX_VST_CNT = mAX_VST_CNT;
	}


	public String getUOM_NM() {
		return UOM_NM;
	}


	public void setUOM_NM(String uOM_NM) {
		UOM_NM = uOM_NM;
	}
}
