package com.ccsp.accums.ledger.summary.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

/**
 * @author Vaibhav
 * Entity class for Accumulation Header table
 *
 */
@Entity
@Table(name = "LEDGER_SUMMARY")
public class LedgerSummaryEntity  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LDGR_SUM_ID",unique=true)
	private Long summaryID;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = LedgerHeaderEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name="LDGR_ID",referencedColumnName="LEDGER_ID")
	private LedgerHeaderEntity ledgerHeader;
	
	@Column(name = "SUB_ID",  nullable = true)
	private String subscriberID;
	
	@Column(name = "MBR_ID",  nullable = true,unique=true)
	private String memberID;
	
	@Column(name = "PLN_ID",  nullable = true)
	private String planID;
		
	@Column(name = "ACCUM_TYP_NM",  nullable = true,unique=true)
	private String accumTypeName;
	
	@Column(name = "AMT",  nullable = true)
	private Double amount;
	
	@Column(name = "NTWK_CD",  nullable = true ,unique=true)
	private String network;
	
	@Column(name = "NTWK_TIER_NM",  nullable = true,unique=true)
	private String networkTierName;
	
	@Column(name = "UOM_NM",  nullable = true)
	private String unitOfMeasure;
	
	@Column(name = "MAX_AMT",  nullable = true)
	private Double maxAmount;
	
	@Column(name = "MAX_VST_CNT",  nullable = true)
	private Integer maxVisit;
	
	@Column(name = "EFF_DT",  nullable = true)
	private Date effectiveDt;
	
	@Column(name = "END_DT",  nullable = true,unique=true)
	private Date endDt;

	
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


	/**
	 * @return
	 */
	public LedgerHeaderEntity getLedgerHeader() {
		return ledgerHeader;
	}

	/**
	 * @param ledgerHeader
	 */
	public void setLedgerHeader(LedgerHeaderEntity ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
	}

	/**
	 * @return
	 */
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	/**
	 * @param effectiveDt
	 */
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	
	/**
	 * @return
	 */
	public Date getEndDt() {
		return endDt;
	}

	/**
	 * @param endDt
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	/**
	 * @return
	 */
	public String getAccumTypeName() {
		return accumTypeName;
	}

	/**
	 * @param accumTypeName
	 */
	public void setAccumTypeName(String accumTypeName) {
		this.accumTypeName = accumTypeName;
	}
	/**
	 * @return
	 */
	public String getNetworkTierName() {
		return networkTierName;
	}

	/**
	 * @param networkTierName
	 */
	public void setNetworkTierName(String networkTierName) {
		this.networkTierName = networkTierName;
	}
	
	
}
