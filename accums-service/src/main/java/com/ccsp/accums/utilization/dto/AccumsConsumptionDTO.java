package com.ccsp.accums.utilization.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author nnarayanaperumaln
 *
 */
public class AccumsConsumptionDTO implements ICommonDTO{
	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="claim")
	private String dcn;
	
	@XmlElement(name="network")
	private String networkCode;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	@XmlElement(name="serviceDate")
	private Date serviceDate;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	@XmlElement(name="processedDate")
	private Date processedDate;
	
	@XmlElement(name="amount")
	private Double allowedAmount;
	
	@XmlElement(name="runningTotal")
	private Double amount;
	
	@XmlElement(name="member")
	private String memberId;
	
	@XmlElement(name="subscriber")
	private String subscriberId;
	
	@XmlElement(name="detail")
	private String accumType;
	
	/**
	 * @return
	 */
	public Date getServiceDate() {
		return serviceDate;
	}
	/**
	 * @param serviceDate
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
	 * @param processedDate
	 */
	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return
	 */
	public String getNetworkCode() {
		return networkCode;
	}
	/**
	 * @param networkCode
	 */
	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
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
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return
	 */
	public String getSubscriberId() {
		return subscriberId;
	}
	/**
	 * @param subscriberId
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	/**
	 * @return
	 */
	public String getAccumType() {
		return accumType;
	}
	/**
	 * @param accumType
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
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
}
