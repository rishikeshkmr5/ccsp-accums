package com.ccsp.accums.ledger.entry.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.common.dto.ICommonDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LedgerEntryDTO implements ICommonDTO{

	/**
	*  Serial version UID
	*/
	private static final long serialVersionUID = 1L;

	private Long ledgerLineId;
	
	@NotNull(message = "Accums Header cannot be empty")
	private Long accumHeaderId;
	
	@NotNull(message = "Accums Type cannot be empty")
	private String accumType;
	
	@NotNull(message = "Role cannot be empty")
	private String role;
	
	@NotNull(message = "CostShareTier cannot be empty")
	private String costShareTier;
	
	@NotNull(message = "Amount cannot be empty")
	private Double amt;
	
	@NotNull(message = "Network cannot be empty")
	private String network;
	
	@NotNull(message = "SnapshotSummary cannot be empty")
	private double snapshotSummmary;
	
	@NotNull(message = "UOM cannot be empty")
	private String UOM;
	
	@NotNull(message = "Service Date cannot be empty")
	private Date serviceDate;
	
	
	private Long linkToPrimary;
	/**
	 * 
	 * @return
	 */
	public Long getLedgerLineId() {
		return ledgerLineId;
	}
	/**
	 * 
	 * @param ledgerLineId
	 */
	public void setLedgerLineId(Long ledgerLineId) {
		this.ledgerLineId = ledgerLineId;
	}
	/**
	 * 
	 * @return
	 */
	public Long getAccumHeaderId() {
		return accumHeaderId;
	}
	/**
	 * 
	 * @param accumHeaderId
	 */
	public void setAccumHeaderId(Long accumHeaderId) {
		this.accumHeaderId = accumHeaderId;
	}
	/**
	 * 
	 * @return
	 */
	public String getAccumType() {
		return accumType;
	}
	/**
	 * 
	 * @param accumType
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}
	/**
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 
	 * @return
	 */
	public String getCostShareTier() {
		return costShareTier;
	}
	/**
	 * 
	 * @param costShareTier
	 */
	public void setCostShareTier(String costShareTier) {
		this.costShareTier = costShareTier;
	}
	/**
	 * 
	 * @return
	 */
	public Double getAmt() {
		return amt;
	}
	/**
	 * 
	 * @param amt
	 */
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	/**
	 * 
	 * @return
	 */
	public String getNetwork() {
		return network;
	}
	/**
	 * 
	 * @param network
	 */
	public void setNetwork(String network) {
		this.network = network;
	}
	/**
	 * 
	 * @return
	 */
	public double getSnapshotSummmary() {
		return snapshotSummmary;
	}
	/**
	 * 
	 * @param snapshotSummmary
	 */
	public void setSnapshotSummmary(double snapshotSummmary) {
		this.snapshotSummmary = snapshotSummmary;
	}
	/**
	 * 
	 * @return
	 */
	public String getUOM() {
		return UOM;
	}
	/**
	 * 
	 * @param uOM
	 */
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	/**
	 * 
	 * @return
	 */
	public Date getServiceDate() {
		return serviceDate;
	}
	/**
	 * 
	 * @param serviceDate
	 */
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	public Long getLinkToPrimary() {
		return linkToPrimary;
	}
	public void setLinkToPrimary(Long linkToPrimary) {
		this.linkToPrimary = linkToPrimary;
	}
	
	
}
