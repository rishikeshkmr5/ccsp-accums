package com.ccsp.accums.ledger.dto;

import java.util.Date;

import javax.persistence.Column;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
public class AccumulationSummaryDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1;

	private Integer summaryID;
	
	private Integer memberMID;
	
	private Integer subscriberMID;
	
	private Date benefitPeriodStartDate;
	
	private Date benefitPeriodEndDate;
	
	private Integer accumulationTypeID;
	
	private Double balanceAmount;
	
	private Character inNetworkIndicator;
	
	private Integer benefitTierID;
	
	private String familyTierCode;
	
	private Short csrVariantID;
	
	private Date lastUpdateTimestamp;
	
	private Date createTimestamp;

	/**
	 * @return
	 */
	public Integer getSummaryID() {
		return summaryID;
	}

	/**
	 * @param summaryID
	 */
	public void setSummaryID(Integer summaryID) {
		this.summaryID = summaryID;
	}
	
	/**
	 * @return
	 */
	public Integer getMemberMID() {
		return memberMID;
	}

	/**
	 * @param memberMID
	 */
	public void setMemberMID(Integer memberMID) {
		this.memberMID = memberMID;
	}

	/**
	 * @return
	 */
	public Integer getSubscriberMID() {
		return subscriberMID;
	}

	/**
	 * @param subscriberMID
	 */
	public void setSubscriberMID(Integer subscriberMID) {
		this.subscriberMID = subscriberMID;
	}

	/**
	 * @return
	 */
	public Date getBenefitPeriodStartDate() {
		return benefitPeriodStartDate;
	}

	/**
	 * @param benefitPeriodStartDate
	 */
	public void setBenefitPeriodStartDate(Date benefitPeriodStartDate) {
		this.benefitPeriodStartDate = benefitPeriodStartDate;
	}

	/**
	 * @return
	 */
	public Date getBenefitPeriodEndDate() {
		return benefitPeriodEndDate;
	}

	/**
	 * @param benefitPeriodEndDate
	 */
	public void setBenefitPeriodEndDate(Date benefitPeriodEndDate) {
		this.benefitPeriodEndDate = benefitPeriodEndDate;
	}

	/**
	 * @return
	 */
	public Integer getAccumulationTypeID() {
		return accumulationTypeID;
	}

	/**
	 * @param accumulationTypeID
	 */
	public void setAccumulationTypeID(Integer accumulationTypeID) {
		this.accumulationTypeID = accumulationTypeID;
	}

	/**
	 * @return
	 */
	public Double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount
	 */
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * @return
	 */
	public Character getInNetworkIndicator() {
		return inNetworkIndicator;
	}

	/**
	 * @param inNetworkIndicator
	 */
	public void setInNetworkIndicator(Character inNetworkIndicator) {
		this.inNetworkIndicator = inNetworkIndicator;
	}

	/**
	 * @return
	 */
	public Integer getBenefitTierID() {
		return benefitTierID;
	}

	/**
	 * @param benefitTierID
	 */
	public void setBenefitTierID(Integer benefitTierID) {
		this.benefitTierID = benefitTierID;
	}

	/**
	 * @return
	 */
	public String getFamilyTierCode() {
		return familyTierCode;
	}

	/**
	 * @param familyTierCode
	 */
	public void setFamilyTierCode(String familyTierCode) {
		this.familyTierCode = familyTierCode;
	}

	/**
	 * @return
	 */
	public Short getCsrVariantID() {
		return csrVariantID;
	}

	/**
	 * @param csrVariantID
	 */
	public void setCsrVariantID(Short csrVariantID) {
		this.csrVariantID = csrVariantID;
	}

	/**
	 * @return
	 */
	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	/**
	 * @param lastUpdateTimestamp
	 */
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	/**
	 * @return
	 */
	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp
	 */
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
}
