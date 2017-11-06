package com.ccsp.accums.ledger.header.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LedgerHeaderDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
		
	@XmlElement(name="transactionCode")
	private String transactionCode;
	
	
	@XmlElement(name="dcn")  
	private String dcn;
	
	
	@XmlElement(name="claimLineId")  
	private Integer claimLineId;

	
	@XmlElement(name="serviceId")  
	private Integer serviceId;
	
	
	@XmlElement(name="service")  
	private String serviceName;
	
	
	@XmlElement(name="serviceDate")  
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date serviceDate;
	
	
	@XmlElement(name="processedDate") 
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date processedDate;
	
	
	@XmlElement(name="networkCode")  
	private String networkCode;
	
	@XmlElement(name="networkTier")  
	private String networkTier;
	
	@XmlElement(name="planId")  
	private Integer planId;
	
	@XmlElement(name="allowedAmount")  
	private Double allowedAmount;
	
	@XmlElement(name="memberId")  
	private String memberId;	
	
	@XmlElement(name="subscriberId")  
	private String subscriberId;	

	@XmlElement(name="unitOfMeasure")  
	private String unitOfMeasure;	
	
	@XmlElement(name="endDate")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	
	@XmlElement(name="effectiveDate")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date effectiveDate;
	
	@XmlElement(name="maxAmount")
	private double maxAmount;
	
	@XmlElement(name="maxVisit")
	private int maxVisit;
	

	@XmlElement(name = "serviceLines")
	private List<LedgerEntryDTO> serviceLines;
	/**
	 * Default constructor.
	 */
	public LedgerHeaderDTO() { }

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
	public Date getProcessedDate() {
		return processedDate;
	}

	/**
	 * @param dateTimeProcessed
	 */
	public void setProcessedDate(Date dateTimeProcessed) {
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

	public List<LedgerEntryDTO> getServiceLines() {
		return serviceLines;
	}

	public void setServiceLines(List<LedgerEntryDTO> serviceLines) {
		this.serviceLines = serviceLines;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public int getMaxVisit() {
		return maxVisit;
	}

	public void setMaxVisit(int maxVisit) {
		this.maxVisit = maxVisit;
	}	
	
}
