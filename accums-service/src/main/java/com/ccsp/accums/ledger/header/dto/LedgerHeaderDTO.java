package com.ccsp.accums.ledger.header.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
@XmlRootElement(name = "accumulationheader")
@XmlAccessorType(XmlAccessType.FIELD)
public class LedgerHeaderDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
	
	@XmlElement(name ="id") 
	private Long id;
	
	
	@XmlElement(name="vendorTaxID")
	private String vendorTaxID;
	
	
	@XmlElement(name="dcn")  
	private String dcn;
	
	
	@XmlElement(name="claimLine")  
	private Integer claimLine;

	
	@XmlElement(name="serviceID")  
	private Integer serviceID;
	
	
	@XmlElement(name="service")  
	private String serviceName;
	
	
	@XmlElement(name="serviceDate")  
	private Date serviceDate;
	
	
	@XmlElement(name="dateTimeProcessed")  
	private Date dateTimeProcessed;
	
	
	@XmlElement(name="network")  
	private String network;
	
	@XmlElement(name="networkTier")  
	private String networkTier;
	
	@XmlElement(name="planID")  
	private Integer planID;
	
	@XmlElement(name="allowedAmount")  
	private Double allowedAmount;
	
	@XmlElement(name="memberID")  
	private String memberID;
	
	
	@XmlElement(name="subscriberID")  
	private String subscriberID;
	

	@XmlElement(name="unitOfMeasure")  
	private String unitOfMeasure;
	
	
	@XmlElement(name="accumType")  
	private String accumType;

	/**
	 * Default constructor.
	 */
	public LedgerHeaderDTO() { }

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
