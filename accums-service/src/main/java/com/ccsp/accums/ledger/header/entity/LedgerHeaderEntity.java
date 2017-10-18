package com.ccsp.accums.ledger.header.entity;

import java.util.Date;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LDGR_HDR")
	@SequenceGenerator(name = "SEQ_LDGR_HDR", sequenceName = "SEQ_LDGR_HDR", allocationSize = 1)
	@Column(name = "LDGR_ID", unique = true, nullable = false)
	private Long id;
		
	@Column(name = "VEND_XACTN_ID", nullable = true, length=16)
	private String vendorTaxID;
	
	@Column(name = "DCN", nullable = true, length=16)
	private String dcn;
	
	@Column(name = "CLM_LN_ID", nullable = true)
	private Integer claimLine;

	@Column(name = "SVC_ID", nullable = true)
	private Integer serviceID;
	
	@Column(name = "SVC_NM", nullable = true)
	private String serviceName;
	
	@Column(name = "SVC_DT", nullable = true)
	private Date serviceDate;
	
	@Column(name = "PROC_DT", nullable = true)
	private Date dateTimeProcessed;
	
	@Column(name = "NTWK_CD", nullable = true)
	private String network;
	
	@Column(name = "NTWK_TIER_NM", nullable = true)
	private String networkTier;
	
	@Column(name = "PLN_ID", nullable = true)
	private Integer planID;
	
	@Column(name = "ALWD_AMT", nullable = true)
	private Double allowedAmount;
	
	@Column(name = "MBR_ID", nullable = true)
	private String memberID;
	
	/*@Column(name = "SUB_ID", nullable = true)
	private Integer patientID;*/
	
	@Column(name = "SUB_ID", nullable = true)
	private String subscriberID;
	
	@Column(name = "UOM_NM", nullable = true)
	private String unitOfMeasure;
	
	@Column(name = "ACCUM_TYP_NM", nullable = true)
	private String accumType;

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
	public String getVendorTaxID() {
		return vendorTaxID;
	}

	/**
	 * @param vendorTaxID
	 */
	public void setVendorTaxID(String vendorTaxID) {
		this.vendorTaxID = vendorTaxID;
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
	public Integer getClaimLine() {
		return claimLine;
	}

	/**
	 * @param claimLine
	 */
	public void setClaimLine(Integer claimLine) {
		this.claimLine = claimLine;
	}

	/**
	 * @return
	 */
	public Integer getServiceID() {
		return serviceID;
	}

	/**
	 * @param serviceID
	 */
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
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
	public Date getDateTimeProcessed() {
		return dateTimeProcessed;
	}

	/**
	 * @param dateTimeProcessed
	 */
	public void setDateTimeProcessed(Date dateTimeProcessed) {
		this.dateTimeProcessed = dateTimeProcessed;
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
	public Integer getPlanID() {
		return planID;
	}

	/**
	 * @param planID
	 */
	public void setPlanID(Integer planID) {
		this.planID = planID;
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
	
	

	}
