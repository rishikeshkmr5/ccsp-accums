package com.ccsp.accums.ledger.entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCUMLATION_ENTRY")
public class AccumsEntry  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LEDGER_LINE_ID", unique = true, nullable = false)
	private Long ledgerLineId;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AccumulationHeader.class, fetch = FetchType.EAGER)
	@JoinColumn(name="LEDGER_ID",referencedColumnName="LEDGER_ID")
	private AccumulationHeader ledgerHeader;
	
	@Column(name = "ACCUM_KEY",  nullable = true)
	private String accumKey;
	
	@Column(name = "ACCUM_TYPE", nullable = true)
	private String accumType;
	
	@Column(name = "ROLE",nullable = true)
	private String role;
	
	@Column(name = "COST_SHARE_TIER", nullable = true)
	private String costShareTier;
	
	@Column(name = "AMOUNT", nullable = true)
	private Double amt;
	
	@Column(name = "NETWORK",nullable = true)
	private String network;
	
	@Column(name = "SNAPSHOT_SUMMARY", nullable = true)
	private double snapshotSummmary;
	
	@Column(name = "UNIT_OF_MEASURE", nullable = true)
	private String UOM;
	
	@Column(name = "SERVICE_DATE", nullable = true)
	private Date serviceDate;

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

	public AccumulationHeader getLedgerHeader() {
		return ledgerHeader;
	}
	
	/**
	 * 
	 * @param ledgerHeader
	 */

	public void setLedgerHeader(AccumulationHeader ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
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
