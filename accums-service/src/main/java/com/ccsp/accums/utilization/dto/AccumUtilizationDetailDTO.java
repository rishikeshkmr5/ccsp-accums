package com.ccsp.accums.utilization.dto;

import java.util.Date;
import java.util.List;

import com.ccsp.accums.category.type.repository.BenefitPeriod;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AccumUtilizationDetailDTO {

	  
	private String subscriberID;	
	
	private String memberPartyID;
	
	private String memberName;
	
	private long groupNumber;
	
	private long sectionNumer;
	
	private long accountNumber;
	
	private String SSN;
	
	private String relationship;
	
	private String gender;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date DOB;
	
	private List<PlanPeriod> planPeriod ;
	
	private List<BenefitPeriod> benefitPeriod ;
	
	private List<Long>  networkType;
	
	private List<Long> accumType;

	public String getSubscriberID() {
		return subscriberID;
	}

	public String getMemberPartyID() {
		return memberPartyID;
	}

	public void setMemberPartyID(String memberPartyID) {
		this.memberPartyID = memberPartyID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public long getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(long groupNumber) {
		this.groupNumber = groupNumber;
	}

	public long getSectionNumer() {
		return sectionNumer;
	}

	public void setSectionNumer(long sectionNumer) {
		this.sectionNumer = sectionNumer;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public List<BenefitPeriod> getBenefitPeriod() {
		return benefitPeriod;
	}

	public void setBenefitPeriod(List<BenefitPeriod> benefitPeriod) {
		this.benefitPeriod = benefitPeriod;
	}

	public List<Long> getNetworkType() {
		return networkType;
	}

	public void setNetworkType(List<Long> networkType) {
		this.networkType = networkType;
	}

	public List<Long> getAccumType() {
		return accumType;
	}

	public void setAccumType(List<Long> accumType) {
		this.accumType = accumType;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public List<PlanPeriod> getPlanPeriod() {
		return planPeriod;
	}

	public void setPlanPeriod(List<PlanPeriod> planPeriod) {
		this.planPeriod = planPeriod;
	}

	
	
}
