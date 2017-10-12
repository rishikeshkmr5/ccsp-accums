package com.ccsp.accums.ledger.dto;

import java.util.Date;

import com.ccsp.common.dto.ICommonDTO;

public class ClaimDetailsForAccumTypeDTO implements ICommonDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accumulatorType;
	private String dcn;
	private String network;
	private Date dateOfService;
	private Date dateTimeProcessed;
	private Double allowedAmount;
	private Double runningBalance;
	public String getAccumulatorType() {
		return accumulatorType;
	}
	public void setAccumulatorType(String accumulatorType) {
		this.accumulatorType = accumulatorType;
	}
	public String getDcn() {
		return dcn;
	}
	public void setDcn(String dcn) {
		this.dcn = dcn;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public Date getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}
	public Date getDateTimeProcessed() {
		return dateTimeProcessed;
	}
	public void setDateTimeProcessed(Date dateTimeProcessed) {
		this.dateTimeProcessed = dateTimeProcessed;
	}
	public Double getAllowedAmount() {
		return allowedAmount;
	}
	public void setAllowedAmount(Double allowedAmount) {
		this.allowedAmount = allowedAmount;
	}
	public Double getRunningBalance() {
		return runningBalance;
	}
	public void setRunningBalance(Double runningBalance) {
		this.runningBalance = runningBalance;
	}
	
	
	

}
