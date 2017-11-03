package com.ccsp.accums.utilization.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.ccsp.common.dto.ICommonDTO;

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
	
	@XmlElement(name="serviceDate")
	private Date serviceDate;
	
	@XmlElement(name="processedDate")
	private Date processedDate;
	
	@XmlElement(name="amount")
	private Double amount;
	
	@XmlElement(name="runningTotal")
	private Double runningTotal;
	
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
	public Double getRunningTotal() {
		return runningTotal;
	}
	/**
	 * @param runningTotal
	 */
	public void setRunningTotal(Double runningTotal) {
		this.runningTotal = runningTotal;
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
}
