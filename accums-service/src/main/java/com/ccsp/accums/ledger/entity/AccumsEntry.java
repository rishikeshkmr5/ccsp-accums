package com.ccsp.accums.ledger.entity;
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
@Table(name = "ACCUMLN_ENTRY")
public class AccumsEntry  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCUMLN_ENTRY_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private Long accumEntryId;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AccumulationHeader.class, fetch = FetchType.EAGER)
	@JoinColumn(name="ACCUMLN_HDR_ID",referencedColumnName="ACCUMLN_HDR_ID", insertable = true, updatable = true)
	private AccumulationHeader ledgerHeader;
	
	
	
	@Column(name = "ACCUMLN_TYP_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private Long accumTypeId;
	
	@Column(name = "INWK_IND", unique = true, nullable = false, precision = 20, scale = 0)
	private String inNetInd;
	
	@Column(name = "BNFT_TIER_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private Long benefitTierId;
	
	@Column(name = "FAM_TIER_CD", unique = true, nullable = false, precision = 20, scale = 0)
	private String famTierCd;
	
	@Column(name = "CSR_VRNT_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private String csrVrntId;
	
	@Column(name = "FDG_ACCUMLN_ENTRY_ID", unique = true, nullable = false, precision = 20, scale = 0)
	private Long fdgAccumEntryId;
	
	@Column(name = "AMT", unique = true, nullable = false, precision = 20, scale = 0)
	private Double amt;
	
	
	
	
	public Long getAccumEntryId() {
		return accumEntryId;
	}
	public void setAccumEntryId(Long accumEntryId) {
		this.accumEntryId = accumEntryId;
	}
	
	public AccumulationHeader getLedgerHeader() {
		return ledgerHeader;
	}
	public void setLedgerHeader(AccumulationHeader ledgerHeader) {
		this.ledgerHeader = ledgerHeader;
	}
	public Long getAccumTypeId() {
		return accumTypeId;
	}
	public void setAccumTypeId(Long accumTypeId) {
		this.accumTypeId = accumTypeId;
	}
	public String getInNetInd() {
		return inNetInd;
	}
	public void setInNetInd(String inNetInd) {
		this.inNetInd = inNetInd;
	}
	public Long getBenefitTierId() {
		return benefitTierId;
	}
	public void setBenefitTierId(Long benefitTierId) {
		this.benefitTierId = benefitTierId;
	}
	public String getFamTierCd() {
		return famTierCd;
	}
	public void setFamTierCd(String famTierCd) {
		this.famTierCd = famTierCd;
	}
	public String getCsrVrntId() {
		return csrVrntId;
	}
	public void setCsrVrntId(String csrVrntId) {
		this.csrVrntId = csrVrntId;
	}
	public Long getFdgAccumEntryId() {
		return fdgAccumEntryId;
	}
	public void setFdgAccumEntryId(Long fdgAccumEntryId) {
		this.fdgAccumEntryId = fdgAccumEntryId;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	
}
