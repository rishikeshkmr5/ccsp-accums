package com.ccsp.accums.ledger.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
public class AccumulationHeaderDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
	private Long ledgerID;
	
	private String vendorTaxID;
	
	private String dcn;
	
	private Integer claimLine;

	private Integer serviceID;
	
	private String service;
	
	private Date dateOfService;
	
	private Date dateTimeProcessed;
	
	private String network;
	
	private String networkTier;
	
	private Integer planID;
	
	private Double allowedAmount;
	
	private String memberID;
	
	private Integer patientID;
	
	private String subscriberID;
	
	private String unitOfMeasure;
	
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
