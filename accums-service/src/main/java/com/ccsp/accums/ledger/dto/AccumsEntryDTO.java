package com.ccsp.accums.ledger.dto;

import com.ccsp.common.dto.ICommonDTO;

public class AccumsEntryDTO implements ICommonDTO{

	
	private Long accumEntryId;
	private Long accumHeaderId;
	private Long accumTypeId;
	private String inNetInd;
	private Long benefitTierId;
	private String famTierCd;
	private String csrVrntId;
	private Long fdgAccumEntryId;
	private Double amt;
	public Long getAccumEntryId() {
		return accumEntryId;
	}
	public void setAccumEntryId(Long accumEntryId) {
		this.accumEntryId = accumEntryId;
	}
	public Long getAccumHeaderId() {
		return accumHeaderId;
	}
	public void setAccumHeaderId(Long accumHeaderId) {
		this.accumHeaderId = accumHeaderId;
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
