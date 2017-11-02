package com.ccsp.accums.utilization.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.accums.ledger.header.dto.ILedgerHeaderDTO;
import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author nnarayanaperumaln
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccumsUtilizationDTO implements ILedgerHeaderDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4382638042231113322L;

	public AccumsUtilizationDTO() {
		//do nothing
	}
	
	public AccumsUtilizationDTO(ILedgerHeaderDTO ledgerHeaderDTO) {
		this.accumulation = ledgerHeaderDTO.getAllowedAmount();
		this.member = ledgerHeaderDTO.getMemberId();
		this.subscriber = ledgerHeaderDTO.getSubscriberId();
		this.network = ledgerHeaderDTO.getNetworkCode();
		this.serviceName = ledgerHeaderDTO.getServiceName();
		this.unit = ledgerHeaderDTO.getAllowedAmount() > 0 ? 1.0 : 0.0;
	}
	
	private String member;

	private String subscriber;

	private String network;

	private String serviceName;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date startDate;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date endDate;

	private Double accumulation;

	private Double unit;

	private Long limit;

	@Override
	public Double getAllowedAmount() {

		return accumulation;
	}

	@Override
	public void setAllowedAmount(Double accumulation) {

		this.accumulation = accumulation;
	}

	@Override
	public String getMemberId() {

		return member;
	}

	@Override
	public void setMemberId(String member) {

		this.member = member;
	}

	@Override
	public String getSubscriberId() {

		return subscriber;
	}

	@Override
	public void setSubscriberId(String subscriber) {

		this.subscriber = subscriber;
	}

	@Override
	public String getServiceName() {

		return serviceName;
	}

	@Override
	public void setServiceName(String serviceName) {

		this.serviceName = serviceName;
	}

	@Override
	public String getNetworkCode() {

		return network;
	}

	@Override
	public void setNetworkCode(String network) {

		this.network = network;
	}

	/**
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return
	 */
	public Double getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 */
	public void setUnit(Double unit) {
		this.unit = unit;
	}

	/**
	 * @return
	 */
	public Long getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 */
	public void setLimit(Long limit) {
		this.limit = limit;
	}

}
