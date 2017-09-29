package com.ccsp.accums.ledger.dto;

import java.util.Date;

public class LedgerHeaderDTO {

	private Long ledgerId;
	private Long claimLine;
	private Long serviceId;
	private String serviceName;
	private Date dateOfService;
	private Date dateTimeProcessed;
	private String network;
	private String networkTier;
	private Long planId;
	private Double allowedAmount;
	private String member;
	private String subscriber;
	/**
	 * @return ledgerId
	 */
	public Long getLedgerId() {
		return ledgerId;
	}
	/**
	 * @param ledgerId
	 */
	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
	}
	/**
	 * @return claimLine
	 */
	public Long getClaimLine() {
		return claimLine;
	}
	/**
	 * @param claimLine
	 */
	public void setClaimLine(Long claimLine) {
		this.claimLine = claimLine;
	}
	/**
	 * @return serviceId
	 */
	public Long getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId
	 */
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @return serviceName
	 */
	public String getserviceName() {
		return serviceName;
	}
	/**
	 * @param serviceName
	 */
	public void setserviceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return dateOfService
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
	 * @return dateTimeProcessed
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
	 * @return network
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
	 * @return networkTier
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
	 * @return planId
	 */
	public Long getPlanId() {
		return planId;
	}
	/**
	 * @param planId
	 */
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	/**
	 * @return allowedAmount
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
	 * @return member
	 */
	public String getMember() {
		return member;
	}
	/**
	 * @param member
	 */
	public void setMember(String member) {
		this.member = member;
	}
	/**
	 * @return subscriber
	 */
	public String getSubscriber() {
		return subscriber;
	}
	/**
	 * @param subscriber
	 */
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
}
