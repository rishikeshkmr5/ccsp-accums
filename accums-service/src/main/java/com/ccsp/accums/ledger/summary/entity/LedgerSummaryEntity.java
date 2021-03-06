package com.ccsp.accums.ledger.summary.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Vaibhav
 * Entity class for Accumulation Header table
 *
 */
@Entity
@Table(name = "LDGR_SUM") 
public class LedgerSummaryEntity  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LDGR_SUM_ID_SEQ")
	@SequenceGenerator(name = "LDGR_SUM_ID_SEQ", sequenceName = "LDGR_SUM_ID_SEQ", allocationSize = 100)
	@Column(name = "LDGR_SUM_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "SUB_ID",  nullable = true)
	private String subscriberId;
	
	@Column(name = "MBR_ID",  nullable = true,unique=true)
	private String memberId;
	
	@Column(name = "PLN_ID",  nullable = true)
	private Long planId;
		
	@Column(name = "ACCUM_TYP_NM",  nullable = true,unique=true)
	private String accumType;
	
	@Column(name = "AMT",  nullable = true)
	private Double amount;
	
	@Column(name = "NTWK_CD",  nullable = true ,unique=true)
	private String networkCode;
	
	@Column(name = "NTWK_TIER_NM",  nullable = true,unique=true)
	private String networkTier;
	
	@Column(name = "UOM_NM",  nullable = true)
	private String unitOfMeasure;
	
	@Column(name = "MAX_AMT",  nullable = true)
	private Double maxAmount;
	
	@Column(name = "MAX_VST_CNT",  nullable = true)
	private Integer maxVisit;
	
	@Column(name = "EFF_DT",  nullable = true)
	private Date effectiveDate;
	
	@Column(name = "END_DT",  nullable = true,unique=true)
	private Date endDate;

	/**
	 * Default constructor.
	 */
	public LedgerSummaryEntity() { }

	/**
	 * Created to convert results of fetchAccumulation from Ledger header repository 
	 */
	public LedgerSummaryEntity(String accumType,String memberId,String networkCode, String networkTier,int planId,String subscriberId,Double amount,String unitOfMeasure) {
		this.accumType=accumType;
		this.memberId=memberId;
		this.networkCode=networkCode;
		this.networkTier=networkTier;
		this.planId=(long) planId;
		this.subscriberId=subscriberId;
		this.amount=amount;
		this.unitOfMeasure=unitOfMeasure;
		
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberID
	 */
	public void setSubscriberId(String subscriberID) {
		this.subscriberId = subscriberID;
	}

	/**
	 * @return
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberID
	 */
	public void setMemberId(String memberID) {
		this.memberId = memberID;
	}

	/**
	 * @return
	 */
	public Long getPlanId() {
		return planId;
	}

	/**
	 * @param planID
	 */
	public void setPlanId(Long planID) {
		this.planId = planID;
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
	public String getNetworkCode() {
		return networkCode;
	}

	/**
	 * @param network
	 */
	public void setNetworkCode(String network) {
		this.networkCode = network;
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
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDt
	 */
	public void setEffectiveDate(Date effectiveDt) {
		this.effectiveDate = effectiveDt;
	}

	
	/**
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDt
	 */
	public void setEndDate(Date endDt) {
		this.endDate = endDt;
	}
	
	/**
	 * @return the accumType
	 */
	public String getAccumType() {
		return accumType;
	}

	/**
	 * @param accumType the accumType to set
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}

	/**
	 * @return the networkTier
	 */
	public String getNetworkTier() {
		return networkTier;
	}

	/**
	 * @param networkTier the networkTier to set
	 */
	public void setNetworkTier(String networkTier) {
		this.networkTier = networkTier;
	}
}
