package com.ccsp.accums.utilization.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClaimDetailDTO implements ICommonDTO{

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
		
	@XmlElement(name="member")  
	private String member;	
	
	@XmlElement(name="subscriber")  
	private String subscriber;
	
	
	@XmlElement(name="claim")  
	private String claim;
	
	@XmlElement(name="claimLine")  
	private Integer claimLine;
	
	@XmlElement(name="service")  
	private String service;
	
	
	@XmlElement(name="network")  
	private String network;
	
	
	@XmlElement(name="serviceDate")  
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date serviceDt;
	
	
	@XmlElement(name="processedDate") 
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date processedDt;
	

	@XmlElement(name="amount")  
	private Double amount;
	
	@XmlElement(name="provider")
	private String provider;

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

	public String getClaim() {
		return claim;
	}

	public void setClaim(String string) {
		this.claim = string;
	}

	public Integer getClaimLine() {
		return claimLine;
	}

	public void setClaimLine(Integer claimLine) {
		this.claimLine = claimLine;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Date getServiceDt() {
		return serviceDt;
	}

	public void setServiceDt(Date serviceDt) {
		this.serviceDt = serviceDt;
	}

	public Date getProcessedDt() {
		return processedDt;
	}

	public void setProcessedDt(Date processedDt) {
		this.processedDt = processedDt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	
	
		
}
