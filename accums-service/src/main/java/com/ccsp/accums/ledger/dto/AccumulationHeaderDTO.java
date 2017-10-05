package com.ccsp.accums.ledger.dto;

import java.util.Date;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
public class AccumulationHeaderDTO  implements ICommonDTO {

	/**
	 * serialVersion id
	 */
	private static final long serialVersionUID = 1L;

	private Long accumulationHeaderID;
	
	private Long memberMID;
	
	private Long claimID;
	
	private Long claimLineNumber;
	
	private Date serviceFromDate;
	
	private Date serviceToDate;
	
	private Long providerID;
	
	private Date adjudicationTimestamp;
	
	private Long planId;
	
	private Long benefitServiceID;
	
	private String operatorID;
	
	private Long subscriberMID;
	
	private String accountID;
	
	private Long vendorID;

	/**
	 * @return
	 */
	public Long getAccumulationHeaderID() {
		return accumulationHeaderID;
	}

	/**
	 * @param accumulationHeaderID
	 */
	public void setAccumulationHeaderID(Long accumulationHeaderID) {
		this.accumulationHeaderID = accumulationHeaderID;
	}

	/**
	 * @return
	 */
	public Long getMemberMID() {
		return memberMID;
	}

	/**
	 * @param memberMID
	 */
	public void setMemberMID(Long memberMID) {
		this.memberMID = memberMID;
	}

	/**
	 * @return
	 */
	public Long getClaimID() {
		return claimID;
	}

	/**
	 * @param claimID
	 */
	public void setClaimID(Long claimID) {
		this.claimID = claimID;
	}

	/**
	 * @return
	 */
	public Long getClaimLineNumber() {
		return claimLineNumber;
	}

	/**
	 * @param claimLineNumber
	 */
	public void setClaimLineNumber(Long claimLineNumber) {
		this.claimLineNumber = claimLineNumber;
	}

	/**
	 * @return
	 */
	public Date getServiceFromDate() {
		return serviceFromDate;
	}

	/**
	 * @param serviceFromDate
	 */
	public void setServiceFromDate(Date serviceFromDate) {
		this.serviceFromDate = serviceFromDate;
	}

	/**
	 * @return
	 */
	public Date getServiceToDate() {
		return serviceToDate;
	}

	/**
	 * @param serviceToDate
	 */
	public void setServiceToDate(Date serviceToDate) {
		this.serviceToDate = serviceToDate;
	}

	/**
	 * @return
	 */
	public Long getProviderID() {
		return providerID;
	}

	/**
	 * @param providerID
	 */
	public void setProviderID(Long providerID) {
		this.providerID = providerID;
	}

	/**
	 * @return
	 */
	public Date getAdjudicationTimestamp() {
		return adjudicationTimestamp;
	}

	/**
	 * @param adjudicationTimestamp
	 */
	public void setAdjudicationTimestamp(Date adjudicationTimestamp) {
		this.adjudicationTimestamp = adjudicationTimestamp;
	}

	/**
	 * @return
	 */
	public Long getPlanId() {
		return planId;
	}

	/**
	 * @param planId
	 */
	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	/**
	 * @return
	 */
	public Long getBenefitServiceID() {
		return benefitServiceID;
	}

	/**
	 * @param benefitServiceID
	 */
	public void setBenefitServiceID(Long benefitServiceID) {
		this.benefitServiceID = benefitServiceID;
	}

	/**
	 * @return
	 */
	public String getOperatorID() {
		return operatorID;
	}

	/**
	 * @param operatorID
	 */
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	/**
	 * @return
	 */
	public Long getSubscriberMID() {
		return subscriberMID;
	}

	/**
	 * @param subscriberMID
	 */
	public void setSubscriberMID(Long subscriberMID) {
		this.subscriberMID = subscriberMID;
	}

	/**
	 * @return
	 */
	public String getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	/**
	 * @return
	 */
	public Long getVendorID() {
		return vendorID;
	}

	/**
	 * @param vendorID
	 */
	public void setVendorID(Long vendorID) {
		this.vendorID = vendorID;
	}


}
