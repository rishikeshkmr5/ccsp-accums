package com.ccsp.accums.ledger.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Vaibhav
 * Entity class for Accumulation Header table
 *
 */
@Entity
@Table(name = "LEDGER_SUMMARY")
public class AccumulationSummary  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	@Id
	@Column(name = "SUMMARY_ID", unique = true, nullable = false)
	private Long summaryID;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AccumulationHeader.class, fetch = FetchType.EAGER)
	@JoinColumn(name="LEDGER_ID",referencedColumnName="LEDGER_ID")
	private AccumulationHeader ledgerHeader;
	
	@Column(name = "SUBSCRIBER_ID",  nullable = true)
	private String subscriberID;
	
	@Column(name = "MEMBER_ID",  nullable = true)
	private String memberID;
	
	@Column(name = "PLAN_ID",  nullable = true)
	private String planID;
	
	@Column(name = "ACCUM_KEY",  nullable = true)
	private String accumKey;
	
	@Column(name = "ACCUM_NAME",  nullable = true)
	private String accumName;
	
	@Column(name = "ACCUM_TYPE",  nullable = true)
	private String accumType;
	
	@Column(name = "Amount",  nullable = true)
	private Double amount;
	
	@Column(name = "NETWORK",  nullable = true)
	private String network;
	
	@Column(name = "UNIT_OF_MEASURE",  nullable = true)
	private String unitOfMeasure;
	
	@Column(name = "MAX_AMOUNT",  nullable = true)
	private Double maxAmount;
	
	@Column(name = "MAX_VISIT",  nullable = true)
	private Integer maxVisit;
	
	@Column(name = "EFFECTIVE_DT",  nullable = true)
	private Date effectiveDt;

	/**
	 * @return
	 */
	public Long getSummaryID() {
		return summaryID;
	}

	/**
	 * @param summaryID
	 */
	public void setSummaryID(Long summaryID) {
		this.summaryID = summaryID;
	}

	/**
	 * @return
	 */
	public String getSubscriberID() {
		return subscriberID;
	}

	/**
	 * @param subscriberID
	 */
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	/**
	 * @return
	 */
	public String getMemberID() {
		return memberID;
	}

	/**
	 * @param memberID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * @return
	 */
	public String getPlanID() {
		return planID;
	}

	/**
	 * @param planID
	 */
	public void setPlanID(String planID) {
		this.planID = planID;
	}

	/**
	 * @return
	 */
	public String getAccumKey() {
		return accumKey;
	}

	/**
	 * @param accumKey
	 */
	public void setAccumKey(String accumKey) {
		this.accumKey = accumKey;
	}

	/**
	 * @return
	 */
	public String getAccumName() {
		return accumName;
	}

	/**
	 * @param accumName
	 */
	public void setAccumName(String accumName) {
		this.accumName = accumName;
	}

	/**
	 * @return
	 */
	public String getAccumType() {
		return accumType;
	}

	/**
	 * @param accumType
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}

	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return
	 */
	public Double getMaxAmount() {
		return maxAmount;
	}

	/**
	 * @param maxAmount
	 */
	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * @return
	 */
	public Integer getMaxVisit() {
		return maxVisit;
	}

	/**
	 * @param maxVisit
	 */
	public void setMaxVisit(Integer maxVisit) {
		this.maxVisit = maxVisit;
	}


	public AccumulationHeader getLedgerHeader() {
		return ledgerHeader;
	}

	public void setLedgerHeader(AccumulationHeader ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
	}
	
}
