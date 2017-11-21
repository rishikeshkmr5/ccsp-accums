package com.ccsp.accums.ledger.header.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "LDGR_HDR")
public class LedgerHeaderEntity  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 8510561406430816669L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LDGR_ID_SEQ")
	@SequenceGenerator(name = "LDGR_ID_SEQ", sequenceName = "LDGR_ID_SEQ", allocationSize = 1)
	@Column(name = "LDGR_ID", unique = true, nullable = false)
	private Long id;
		
	@Column(name = "VEND_XACTN_ID", nullable = true, length=16)
	private String transactionCode;
	
	@Column(name = "DCN", nullable = true, length=16)
	private String dcn;
	
	@Column(name = "CLM_LN_ID", nullable = true)
	private Integer claimLineId;

	@Column(name = "SVC_ID", nullable = true)
	private Integer serviceId;
	
	@Column(name = "SVC_NM", nullable = true)
	private String serviceName;
	
	@Column(name = "SVC_DT", nullable = true)
	private Date serviceDate;
	
	@Column(name = "PROC_DT", nullable = true)
	private Timestamp processedDate;
	
	@Column(name = "NTWK_CD", nullable = true)
	private String networkCode;
	
	@Column(name = "NTWK_TIER_NM", nullable = true)
	private String networkTier;
	
	@Column(name = "PLN_ID", nullable = true)
	private Integer planId;
	
	@Column(name = "ALWD_AMT", nullable = true)
	private Double allowedAmount;
	
	@Column(name = "MBR_ID", nullable = true)
	private String memberId;
	
	/*@Column(name = "SUB_ID", nullable = true)
	private Integer patientID;*/
	
	@Column(name = "SUB_ID", nullable = true)
	private String subscriberId;
	
	@Column(name = "UOM_NM", nullable = true)
	private String unitOfMeasure;
	
	@Column(name="CORP_ENT_CD")
	private String corporateEntityCode;
	
	/**
	 * Default constructor.
	 */
	public LedgerHeaderEntity() { }

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
	public String getTransactionCode() {
		return transactionCode;
	}

	/**
	 * @param vendorTaxID
	 */
	public void setTransactionCode(String vendorTaxID) {
		this.transactionCode = vendorTaxID;
	}

	/**
	 * @return
	 */
	public String getDcn() {
		return dcn;
	}

	/**
	 * @param dcn
	 */
	public void setDcn(String dcn) {
		this.dcn = dcn;
	}

	/**
	 * @return
	 */
	public Integer getClaimLineId() {
		return claimLineId;
	}

	/**
	 * @param claimLine
	 */
	public void setClaimLineId(Integer claimLine) {
		this.claimLineId = claimLine;
	}

	/**
	 * @return
	 */
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceID
	 */
	public void setServiceId(Integer serviceID) {
		this.serviceId = serviceID;
	}

	/**
	 * @return the serviceDate
	 */
	public Date getServiceDate() {
		return serviceDate;
	}

	/**
	 * @param serviceDate the serviceDate to set
	 */
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	/**
	 * @return
	 */
	public Timestamp getProcessedDate() {
		return processedDate;
	}

	/**
	 * @param dateTimeProcessed
	 */
	public void setProcessedDate(Timestamp dateTimeProcessed) {
		this.processedDate = dateTimeProcessed;
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
	public String getNetworkTier() {
		return networkTier;
	}

	/**
	 * @param networkTier
	 */
	public void setNetworkTier(String networkTier) {
		this.networkTier = networkTier;
	}

	/**
	 * @return
	 */
	public Integer getPlanId() {
		return planId;
	}

	/**
	 * @param planID
	 */
	public void setPlanId(Integer planID) {
		this.planId = planID;
	}

	/**
	 * @return
	 */
	public Double getAllowedAmount() {
		return allowedAmount;
	}

	/**
	 * @param allowedAmount
	 */
	public void setAllowedAmount(Double allowedAmount) {
		this.allowedAmount = allowedAmount;
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
	 * 
	 * @return
	 */

	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCorporateEntityCode() {
		return corporateEntityCode;
	}

	public void setCorporateEntityCode(String corporateEntityCode) {
		this.corporateEntityCode = corporateEntityCode;
	}
	
	

	}
