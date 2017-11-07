package com.ccsp.accums.utilization.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nnarayanaperumaln
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpendingSummaryDTO implements ICommonDTO{

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4382638042231113322L;

	public SpendingSummaryDTO() {
		//do nothing
	}
	
	private String memberId;

	private String subscriberId;

	@XmlElement(name="network")
	@JsonProperty("network")
	private String networkCode;

	@XmlElement(name="benefit")
	@JsonProperty("benefit")
	private String serviceName;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date startDate;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date endDate;

	@XmlElement(name="accumulation")
	@JsonProperty("accumulation")
	private Double allowedAmount;

	@XmlElement(name="units")
	@JsonProperty("units")
	private Double unit;

	private Long limit;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getAllowedAmount() {
		return allowedAmount;
	}

	public void setAllowedAmount(Double allowedAmount) {
		this.allowedAmount = allowedAmount;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

}
