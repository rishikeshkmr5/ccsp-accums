package com.hcsc.ccsp.accums.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ServiceLine {

	private String accumType;
	private String role;
	private String costShareTier;
	private double amount;
	private String network;
	private double snapShotSummary;
	private String unitOfMeasure;
	
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="CST")
	private Date serviceDate;

	
	public ServiceLine() {
		super();
	}
	

	@Override
	public String toString() {
		return "ServiceLine [accumType=" + accumType + ", role=" + role
				+ ", costShareTier=" + costShareTier + ", amount=" + amount + ", network=" + network
				+ ", snapShotSummary=" + snapShotSummary + ", unitOfMeasure=" + unitOfMeasure + ", serviceDate="
				+ serviceDate + "]";
	}


	public String getAccumType() {
		return accumType;
	}


	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getCostShareTier() {
		return costShareTier;
	}


	public void setCostShareTier(String costShareTier) {
		this.costShareTier = costShareTier;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getNetwork() {
		return network;
	}


	public void setNetwork(String network) {
		this.network = network;
	}


	public double getSnapShotSummary() {
		return snapShotSummary;
	}


	public void setSnapShotSummary(double snapShotSummary) {
		this.snapShotSummary = snapShotSummary;
	}


	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}


	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}


	public Date getServiceDate() {
		return serviceDate;
	}


	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	
}
