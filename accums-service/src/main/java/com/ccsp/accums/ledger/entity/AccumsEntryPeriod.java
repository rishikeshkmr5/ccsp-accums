package com.ccsp.accums.ledger.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCUMLN_ENTRY_PRD")
public class AccumsEntryPeriod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected AccumsEntryPeriodEmbedd accumsEntryPeriodEmbeddPk;
	
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AccumsEntry.class, fetch = FetchType.EAGER)
	@JoinColumn(name="ACCUMLN_ENTRY_ID",referencedColumnName="ACCUMLN_ENTRY_ID", insertable = false, updatable = false)
	private AccumsEntry accumsEntry;
	
	/*@JoinColumn(name="PRD_TYP_CD",nullable = false,insertable = true, updatable = true)
	private String periodTypeCode;
	
	
	
	
	@Column(name = "PRD_QTY",nullable = false, insertable = false, updatable = false)
	private Long periodQuantity;*/
	
	
	
	@Column(name = "LMT_AMT", nullable = false, insertable = true, updatable = true)
	private Double limitAmtt;
	
	@Column(name = "BAL_AMT",nullable = false, insertable = true, updatable = true)
	private Double amt;

	public AccumsEntryPeriodEmbedd getAccumsEntryPeriodEmbeddPk() {
		return accumsEntryPeriodEmbeddPk;
	}

	public void setAccumsEntryPeriodEmbeddPk(AccumsEntryPeriodEmbedd accumsEntryPeriodEmbeddPk) {
		this.accumsEntryPeriodEmbeddPk = accumsEntryPeriodEmbeddPk;
	}

	public AccumsEntry getAccumsEntry() {
		return accumsEntry;
	}

	public void setAccumsEntry(AccumsEntry accumsEntry) {
		this.accumsEntry = accumsEntry;
	}

	public Double getLimitAmtt() {
		return limitAmtt;
	}

	public void setLimitAmtt(Double limitAmtt) {
		this.limitAmtt = limitAmtt;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	
	
	
	
	
	
	
	
	



}
