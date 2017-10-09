package com.ccsp.accums.ledger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vaibhav
 * Entity class for Accumulation Header table
 *
 */
@Entity
@Table(name = "ACCUMLN_SUM")
public class AccumulationSummary  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	@Id
	@Column(name = "ACCUMLN_SUM_ID",  nullable = false)
	private Integer summaryID;
	
	@Column(name = "MBR_MID",  nullable = true)
	private Integer memberMID;
	
	@Column(name = "SUB_MID",  nullable = true)
	private Integer subscriberMID;
	
	@Column(name = "BFPRD_STRT_DT", nullable = true)
	private Date benefitPeriodStartDate;
	
	@Column(name = "BFPRD_END_DT", nullable = true)
	private Date benefitPeriodEndDate;
	
	@Column(name = "ACCUMLN_TYP_ID", nullable = true )
	private Integer accumulationTypeID;
	
	@Column(name = "BAL_AMT", nullable = true, precision=12, scale=2)
	private Double balanceAmount;
	
	@Column(name = "INWK_IND", nullable = true, length = 1)
	private Character inNetworkIndicator;
	
	@Column(name = "BNFT_TIER_ID", nullable = true )
	private Integer benefitTierID;
	
	@Column(name = "FAM_TIER_CD",  nullable = true, length = 50)
	private String familyTierCode;
	
	@Column(name = "CSR_VRNT_ID", nullable = true)
	private Short csrVariantID;
	
	@Column(name = "LST_UPD_TS", nullable = true)
	private Date lastUpdateTimestamp;
	
	@Column(name = "CRTE_TS", nullable = true)
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
