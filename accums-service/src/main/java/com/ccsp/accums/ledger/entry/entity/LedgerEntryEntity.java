package com.ccsp.accums.ledger.entry.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

@Entity
@Table(name = "LDGR_ENTRY")
public class LedgerEntryEntity  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LDGR_ENTRY")
	@SequenceGenerator(name = "SEQ_LDGR_ENTRY", sequenceName = "SEQ_LDGR_ENTRY", allocationSize = 1)
	@Column(name = "LDGR_ENTRY_ID", unique = true, nullable = false)
	private Long ledgerLineId;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="PRIMY_LDGR_ENTRY_ID")
	private LedgerEntryEntity accumsEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = LedgerHeaderEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name="LDGR_ID",referencedColumnName="LDGR_ID")
	private LedgerHeaderEntity ledgerHeader;
	
	@Column(name = "ACCUM_TYP_NM", nullable = true)
	private String accumType;
	
	@Column(name = "ROLE_NM",nullable = true)
	private String role;
	
	@Column(name = "CST_SHR_TIER_NM", nullable = true)
	private String costShareTier;
	
	@Column(name = "AMT", nullable = true)
	private Double amt;
	
	@Column(name = "NTWK_CD",nullable = true)
	private String network;
	
	@Column(name = "SNPSHT_SUM_AMT", nullable = true)
	private double snapshotSummmary;
	
	@Column(name = "UOM_NM", nullable = true)
	private String UOM;
	
	@Column(name = "SVC_DT", nullable = true)
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

	public LedgerHeaderEntity getLedgerHeader() {
		return ledgerHeader;
	}
	
	/**
	 * 
	 * @param ledgerHeader
	 */

	public void setLedgerHeader(LedgerHeaderEntity ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
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
	public LedgerEntryEntity getAccumsEntry() {
		return accumsEntry;
	}
	public void setAccumsEntry(LedgerEntryEntity accumsEntry) {
		this.accumsEntry = accumsEntry;
	}
	
	
}
