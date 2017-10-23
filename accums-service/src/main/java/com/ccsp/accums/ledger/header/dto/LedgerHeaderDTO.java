package com.ccsp.accums.ledger.header.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
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
		
	@XmlElement(name="vendorTansactionCode")
	private String vendorTransactionCode;
	
	
	@XmlElement(name="dcn")  
	private String dcn;
	
	
	@XmlElement(name="claimLine")  
	private Integer claimLine;

	
	@XmlElement(name="serviceId")  
	private Integer serviceId;
	
	
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
	
	@XmlElement(name="planId")  
	private Integer planId;
	
	@XmlElement(name="allowedAmount")  
	private Double allowedAmount;
	
	@XmlElement(name="memberIdentifier")  
	private String memberIdentifier;
	
	
	@XmlElement(name="subscriberId")  
	private String subscriberId;
	

	@XmlElement(name="unitOfMeasure")  
	private String unitOfMeasure;
	
	
	@XmlElement(name="accumType")  
	private String accumType;

	@XmlElement(name = "serviceLines")
	private List<LedgerEntryDTO> serviceLines;
	/**
	 * Default constructor.
	 */
	public LedgerHeaderDTO() { }

	/**
	 * @return
	 */
	public String getVendorTransactionCode() {
		return vendorTransactionCode;
	}

	/**
	 * @param vendorTaxID
	 */
	public void setVendorTransactionCode(String vendorTaxID) {
		this.vendorTransactionCode = vendorTaxID;
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
	public String getMemberIdentifier() {
		return memberIdentifier;
	}

	/**
	 * @param memberID
	 */
	public void setMemberIdentifier(String memberID) {
		this.memberIdentifier = memberID;
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

	public List<LedgerEntryDTO> getServiceLines() {
		return serviceLines;
	}

	public void setServiceLines(List<LedgerEntryDTO> serviceLines) {
		this.serviceLines = serviceLines;
	}
	
	}
