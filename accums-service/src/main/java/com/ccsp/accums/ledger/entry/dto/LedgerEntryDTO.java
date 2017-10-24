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
	
	private Long id;
	
	@NotNull(message = "Accums Header cannot be empty")
	private Long ledgerHeaderID;
	
	@NotNull(message = "Accums Type cannot be empty")
	private String accumType;
	
	@NotNull(message = "Role cannot be empty")
	private String role;
	
	@NotNull(message = "CostShareTier cannot be empty")
	private String costShareTier;
	
	@NotNull(message = "Amount cannot be empty")
	private Double amount;
	
	@NotNull(message = "Network cannot be empty")
	private String network;
	
	@NotNull(message = "SnapshotSummary cannot be empty")
	private double snapshotSummmary;
	
	@NotNull(message = "Unit of measure cannot be empty")
	private String unitOfMeasure;
	
	@NotNull(message = "Service Date cannot be empty")
	private Date serviceDate;
	
	private Long primaryLedgerEntryID;
	
	/**
	 * Default constructor.
	 */
	public LedgerEntryDTO() { }
	
	/**
	 * 
	 * @return
	 */
	public Long getLedgerHeaderID() {
		return ledgerHeaderID;
	}
	/**
	 * 
	 * @param ledgerHeaderID
	 */
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
