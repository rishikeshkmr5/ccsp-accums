package com.ccsp.accums.ledger.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
@XmlRootElement(name = "accumulationheader")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccumulationHeaderDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Ledger Id cannot be null")
	@XmlElement(name ="ledgerID") 
	private Long ledgerID;
	
	@NotNull(message = "Vendor Tax ID cannot be null")
	@XmlElement(name="vendorTaxID")
	private String vendorTaxID;
	
	@NotNull(message = "DCN cannot be null")
	@XmlElement(name="dcn")  
	private String dcn;
	
	@NotNull(message = "Claim Line cannot be null")
	@XmlElement(name="claimLine")  
	private Integer claimLine;

	@NotNull(message = "Service Id cannot be null")
	@XmlElement(name="serviceID")  
	private Integer serviceID;
	
	@NotNull(message = "Service cannot be null")
	@XmlElement(name="service")  
	private String service;
	
	@NotNull(message = "Service Date cannot be null")
	@XmlElement(name="dateOfService")  
	private Date dateOfService;
	
	@NotNull(message = "Processed Date cannot be null")
	@XmlElement(name="dateTimeProcessed")  
	private Date dateTimeProcessed;
	
	@NotNull(message = "Network cannot be null")
	@XmlElement(name="network")  
	private String network;
	
	@NotNull(message = "NetworkTier cannot be null")
	@XmlElement(name="networkTier")  
	private String networkTier;
	
	@NotNull(message = "Plan ID cannot be null")
	@XmlElement(name="planID")  
	private Integer planID;
	
	@NotNull(message = "Allowed Amount cannot be null")
	@XmlElement(name="allowedAmount")  
	private Double allowedAmount;
	
	@NotNull(message = "Member ID cannot be null")
	@XmlElement(name="memberID")  
	private String memberID;
	
	@NotNull(message = "Patient ID cannot be null")
	@XmlElement(name="patientID")  
	private Integer patientID;
	
	@NotNull(message = "Subscriber ID cannot be null")
	@XmlElement(name="subscriberID")  
	private String subscriberID;
	
	@NotNull(message = "Unit of Measure cannot be null")
	@XmlElement(name="unitOfMeasure")  
	private String unitOfMeasure;
	
	@NotNull(message = "Accumulator Type cannot be null")
	@XmlElement(name="accumulatorType")  
	private String accumulatorType;

	/**
	 * @return
	 */
	public Long getLedgerID() {
		return ledgerID;
	}

	/**
	 * @param ledgerID
	 */
	public void setLedgerID(Long ledgerID) {
		this.ledgerID = ledgerID;
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
	 * @return
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return
	 */
	public Date getDateOfService() {
		return dateOfService;
	}

	/**
	 * @param dateOfService
	 */
	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
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
	public Integer getPatientID() {
		return patientID;
	}

	/**
	 * @param patientID
	 */
	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
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
	 * @return
	 */
	public String getAccumulatorType() {
		return accumulatorType;
	}

	/**
	 * @param accumulatorType
	 */
	public void setAccumulatorType(String accumulatorType) {
		this.accumulatorType = accumulatorType;
	}

	}
