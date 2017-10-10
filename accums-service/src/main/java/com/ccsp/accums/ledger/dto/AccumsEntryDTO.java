package com.ccsp.accums.ledger.dto;

import java.util.Date;

import com.ccsp.common.dto.ICommonDTO;

public class AccumsEntryDTO implements ICommonDTO{

	
	private Long ledgerLineId;
	private Long accumHeaderId;
	private String accumKey;
	private String accumType;
	private String role;
	private String costShareTier;
	private Double amt;
	private String network;
	private double snapshotSummmary;
	private String UOM;
	private Date serviceDate;
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
	public String getAccumKey() {
		return accumKey;
	}
	/**
	 * 
	 * @param accumKey
	 */
	public void setAccumKey(String accumKey) {
		this.accumKey = accumKey;
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
	
}
