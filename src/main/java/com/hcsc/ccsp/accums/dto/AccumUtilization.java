package com.hcsc.ccsp.accums.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AccumUtilization {

	private String transactionCode;
	private String dcn;
	private int claimLineId;
	private String memberId;
	private String subscriberId;
	private int serviceId;
	private String serviceName;
	
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="CST")
	private Date serviceDate;
	
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="CST")
	private Date processedDate;
	
	private String networkCode;
	private String networkTier;
	private int planId;
	private double allowedAmount;
	private String unitOfMeasure;
	private String accumType;

	@JsonFormat(pattern = "MM/dd/yyyy", timezone="CST")
	private Date endDate;
	
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="CST")
	private Date effectiveDate;
	
	private double maxAmount;
	private int maxVisit;

	@JsonProperty("ServiceLines")
	private List<ServiceLine> serviceLine;
	

	@Override
	public String toString() {
		return "AccumUtilization [transactionCode=" + transactionCode + ", dcn=" + dcn + ", claimLineId=" + claimLineId
				+ ", memberId=" + memberId + ", subscriberId=" + subscriberId + ", serviceId=" + serviceId
				+ ", serviceName=" + serviceName + ", serviceDate=" + serviceDate + ", processedDate=" + processedDate
				+ ", networkCode=" + networkCode + ", networkTier=" + networkTier + ", planId=" + planId
				+ ", allowedAmount=" + allowedAmount + ", unitOfMeasure=" + unitOfMeasure + ", accumType=" + accumType
				+ ", endDate=" + endDate + ", effectiveDate=" + effectiveDate + ", maxAmount=" + maxAmount
				+ ", maxVisit=" + maxVisit + ", serviceLine=" + serviceLine + "]";
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}


	public String getDcn() {
		return dcn;
	}


	public void setDcn(String dcn) {
		this.dcn = dcn;
	}


	public int getClaimLineId() {
		return claimLineId;
	}


	public void setClaimLineId(int claimLineId) {
		this.claimLineId = claimLineId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}


	public int getServiceId() {
		return serviceId;
	}


	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public Date getServiceDate() {
		return serviceDate;
	}


	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}


	public Date getProcessedDate() {
		return processedDate;
	}


	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}


	public String getNetworkCode() {
		return networkCode;
	}


	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}


	public String getNetworkTier() {
		return networkTier;
	}


	public void setNetworkTier(String networkTier) {
		this.networkTier = networkTier;
	}


	public int getPlanId() {
		return planId;
	}


	public void setPlanId(int planId) {
		this.planId = planId;
	}


	public double getAllowedAmount() {
		return allowedAmount;
	}


	public void setAllowedAmount(double allowedAmount) {
		this.allowedAmount = allowedAmount;
	}


	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}


	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}


	public String getAccumType() {
		return accumType;
	}


	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getEffectiveDate() {
		return effectiveDate;
	}


	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}


	public double getMaxAmount() {
		return maxAmount;
	}


	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}


	public int getMaxVisit() {
		return maxVisit;
	}


	public void setMaxVisit(int maxVisit) {
		this.maxVisit = maxVisit;
	}


	public List<ServiceLine> getServiceLine() {
		return serviceLine;
	}


	public void setServiceLine(List<ServiceLine> serviceLine) {
		this.serviceLine = serviceLine;
	}


	
	
	
}
		