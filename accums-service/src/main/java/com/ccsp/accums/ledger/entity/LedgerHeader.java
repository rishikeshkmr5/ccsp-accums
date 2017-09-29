package com.ccsp.accums.ledger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vaibhav
 * Entity class for LEDGER_HEADER table
 *
 */
@Entity
@Table(name = "LEDGER_HEADER")
public class LedgerHeader  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = -397838150359709350L;
	
	@Id
	@Column(name = "LEDGER_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private Long ledgerId;
	
	@Column(name = "CLAIM_LINE", nullable = false, precision = 20, scale = 0)
	private Long claimLine;
	
		@Column(name = "SERVICE_ID", nullable = false, precision = 20, scale = 0)
	private Long serviceId;
	
	@Column(name = "SERVICE_NAME", nullable = false, length = 60)
	private String serviceName;
	
	@Column(name = "DATE_OF_SERVICE", nullable = true)
	private Date dateOfService;
	
	@Column(name = "DATE_TIME_PROCESSED", nullable = true)
	private Date dateTimeProcessed; 
	
	@Column(name = "NETWORK", nullable = false, length = 60)
	private String network;
	
	@Column(name = "NETWORK_TIER", nullable = false, length = 60)
	private String networkTier;
	
	@Column(name = "PLAN_ID", nullable = false, precision = 20, scale = 0)
	private Long planId;
	
	@Column(name = "ALLOWED_AMOUNT", nullable = false)
	private Double allowedAmount;
	
	@Column(name = "MEMBER", nullable = false, length = 60)
	private String member;
	
	@Column(name = "SUBSCRIBER", nullable = false, length = 60)
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
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
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
