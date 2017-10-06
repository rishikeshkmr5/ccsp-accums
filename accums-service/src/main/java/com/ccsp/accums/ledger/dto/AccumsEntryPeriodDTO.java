package com.ccsp.accums.ledger.dto;

import com.ccsp.common.dto.ICommonDTO;

public class AccumsEntryPeriodDTO implements ICommonDTO{
	
	private Long accumsEntryId;
	private String periodTypeCode;
	private Long periodQuantity;
	private Double limitAmtt;
	private Double amt;
	public Long getAccumsEntryId() {
		return accumsEntryId;
	}
	public void setAccumsEntryId(Long accumsEntryId) {
		this.accumsEntryId = accumsEntryId;
	}
	public String getPeriodTypeCode() {
		return periodTypeCode;
	}
	public void setPeriodTypeCode(String periodTypeCode) {
		this.periodTypeCode = periodTypeCode;
	}
	public Long getPeriodQuantity() {
		return periodQuantity;
	}
	public void setPeriodQuantity(Long periodQuantity) {
		this.periodQuantity = periodQuantity;
	}
	public Double getLimitAmtt() {
		return limitAmtt;
	}
	public void setLimitAmtt(Double limitAmtt) {
		this.limitAmtt = limitAmtt;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	
	

}
