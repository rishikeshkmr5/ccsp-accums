package com.ccsp.accums.ledger.entry.entity;
import java.sql.Date;

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
	 * Default serialization id
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LDGR_ENTRY_ID_SEQ")
	@SequenceGenerator(name = "LDGR_ENTRY_ID_SEQ", sequenceName = "LDGR_ENTRY_ID_SEQ", allocationSize = 1)
	@Column(name = "LDGR_ENTRY_ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="PRIMY_LDGR_ENTRY_ID")
	private LedgerEntryEntity primaryLedgerEntry;
	
	@Column(name = "PRIMY_LDGR_ENTRY_ID", insertable = false, updatable = false)
	private Long primaryLedgerEntryID;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = LedgerHeaderEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name="LDGR_ID",referencedColumnName="LDGR_ID")
	private LedgerHeaderEntity ledgerHeader;
	
	@Column(name = "LDGR_ID", insertable = false, updatable = false)
	private Long ledgerHeaderID;
	
	@Column(name = "ACCUM_TYP_NM", nullable = true)
	private String accumType;
	
	@Column(name = "ROLE_NM",nullable = true)
	private String role;
	
	@Column(name = "CST_SHR_TIER_NM", nullable = true)
	private String costShareTier;
	
	@Column(name = "AMT", nullable = true)
	private Double amount;
	
	@Column(name = "NTWK_CD",nullable = true)
	private String network;
	
	@Column(name = "SNPSHT_SUM_AMT", nullable = true)
	private double snapshotSummmary;
	
	@Column(name = "UOM_NM", nullable = true)
	private String unitOfMeasure;
	
	@Column(name = "SVC_DT", nullable = true)
	private Date serviceDate;

	/**
	 * Default constructor.
	 */
	public LedgerEntryEntity() { }
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return ledgerHeader
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
	
	public Long getLedgerHeaderID() {
		return ledgerHeaderID;
	}
	public void setLedgerHeaderID(Long ledgerHeaderID) {
		this.ledgerHeaderID = ledgerHeaderID;
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
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
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
	/**
	 * @return the primaryLedgerEntry
	 */
	public LedgerEntryEntity getPrimaryLedgerEntry() {
		return primaryLedgerEntry;
	}
	/**
	 * @param primaryLedgerEntry the primaryLedgerEntry to set
	 */
	public void setPrimaryLedgerEntry(LedgerEntryEntity primaryLedgerEntry) {
		this.primaryLedgerEntry = primaryLedgerEntry;
	}

	/**
	 * @return the primaryLedgerEntryID
	 */
	public Long getPrimaryLedgerEntryID() {
		return primaryLedgerEntryID;
	}

	/**
	 * @param primaryLedgerEntryID the primaryLedgerEntryID to set
	 */
	public void setPrimaryLedgerEntryID(Long primaryLedgerEntryID) {
		this.primaryLedgerEntryID = primaryLedgerEntryID;
	}
}
