package com.ccsp.accums.ledger.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccumsEntryPeriodEmbedd  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ACCUMLN_ENTRY_ID", nullable = false)
	private Long accumEntryId;	
	
	@Column(name = "PRD_TYP_CD", nullable = false)
	private String periodTypeCode;	
	
	@Column(name = "PRD_QTY", nullable = false)
	private Long periodQuantity;
	
	public AccumsEntryPeriodEmbedd(){
		
	}

	public AccumsEntryPeriodEmbedd(Long accumEntryId, String periodTypeCode, Long periodQuantity) {
		super();
		this.accumEntryId = accumEntryId;
		this.periodTypeCode = periodTypeCode;
		this.periodQuantity = periodQuantity;
	}

	public Long getAccumEntryId() {
		return accumEntryId;
	}

	public void setAccumEntryId(Long accumEntryId) {
		this.accumEntryId = accumEntryId;
	}

	public String getPeriodTypeCode() {
		return periodTypeCode;
	}

	public void setPeriodTypeCode(String periodTypeCode) {
		this.periodTypeCode = periodTypeCode;
	}

	public Long getPeriodQuantity() {
		return periodQuantity;
	}

	public void setPeriodQuantity(Long periodQuantity) {
		this.periodQuantity = periodQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accumEntryId == null) ? 0 : accumEntryId.hashCode());
		result = prime * result + ((periodQuantity == null) ? 0 : periodQuantity.hashCode());
		result = prime * result + ((periodTypeCode == null) ? 0 : periodTypeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccumsEntryPeriodEmbedd other = (AccumsEntryPeriodEmbedd) obj;
		if (accumEntryId == null) {
			if (other.accumEntryId != null)
				return false;
		} else if (!accumEntryId.equals(other.accumEntryId))
			return false;
		if (periodQuantity == null) {
			if (other.periodQuantity != null)
				return false;
		} else if (!periodQuantity.equals(other.periodQuantity))
			return false;
		if (periodTypeCode == null) {
			if (other.periodTypeCode != null)
				return false;
		} else if (!periodTypeCode.equals(other.periodTypeCode))
			return false;
		return true;
	}
	

	
	
	
	
	
}
