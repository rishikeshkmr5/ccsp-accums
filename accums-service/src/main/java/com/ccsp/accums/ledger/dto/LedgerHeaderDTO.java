package com.ccsp.accums.ledger.dto;

import java.util.Date;

public class LedgerHeaderDTO {

	private Long ledgerId;
	private Long claimLine;
	private Long serviceId;
	private String serviceName;
	private Date dateOfService;
	private Date dataTimeProcessed;
	private String network;
	private String networkTier;
	private Long planId;
	private Double allowedAmount;
	private String member;
	private String subscriber;
	public Long getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
	}
	public Long getClaimLine() {
		return claimLine;
	}
	public void setClaimLine(Long claimLine) {
		this.claimLine = claimLine;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public String getserviceName() {
		return serviceName;
	}
	public void setserviceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Date getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}
	public Date getDataTimeProcessed() {
		return dataTimeProcessed;
	}
	public void setDataTimeProcessed(Date dataTimeProcessed) {
		this.dataTimeProcessed = dataTimeProcessed;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getNetworkTier() {
		return networkTier;
	}
	public void setNetworkTier(String networkTier) {
		this.networkTier = networkTier;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public Double getAllowedAmount() {
		return allowedAmount;
	}
	public void setAllowedAmount(Double allowedAmount) {
		this.allowedAmount = allowedAmount;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
}
