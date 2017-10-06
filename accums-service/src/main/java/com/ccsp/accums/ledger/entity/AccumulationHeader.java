package com.ccsp.accums.ledger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vaibhav
 * Entity class for Accumulation Header table
 *
 */
@Entity
@Table(name = "ACCUMLN_HDR", schema="ccsp")
public class AccumulationHeader  implements java.io.Serializable {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 8510561406430816669L;
	
	@Id
	@Column(name = "ACCUMLN_HDR_ID", unique = true, nullable = false)
	private Long accumln_hdr_id;
	
	@Column(name = "MBR_MID", unique=true, nullable = false)
	private Long mbr_mid;
	
	@Column(name = "CLM_ID", nullable = true)
	private Long clm_id;
	
	@Column(name = "CLM_LN_NBR", nullable = true)
	private Long clm_ln_nbr;
	
	@Column(name = "SVC_FR_DT", nullable = true)
	private Date svc_fr_dt;
	
	@Column(name = "SVC_TO_DT", nullable = true)
	private Date svc_to_dt;
	
	@Column(name = "PROV_ID", nullable = true)
	private Long prov_id;
	
	@Column(name = "ADJCTN_TS", nullable = false)
	private Date adjctn_ts;
	
	@Column(name = "PLN_ID", nullable = false, unique = true)
	private Long pln_id;
	
	@Column(name = "BNFT_SVC_ID", nullable = false, unique = true)
	private Long bnft_svc_id;
	
	@Column(name = "OPER_ID", nullable = false, length = 50)
	private String oper_id;
	
	@Column(name = "SUB_MID", nullable = false, unique = true)
	private Long sub_mid;
	
	@Column(name = "ACCT_ID", unique=true, nullable = false, length = 6)
	private String acct_ID;
	
	@Column(name = "VEND_ID", nullable = true)
	private Long vend_id;

	
	/**
	 * @return
	 */
	public Long getAccumln_hdr_id() {
		return accumln_hdr_id;
	}

	
	/**
	 * @param accumln_hdr_id
	 */
	public void setAccumln_hdr_id(Long accumln_hdr_id) {
		this.accumln_hdr_id = accumln_hdr_id;
	}

	/**
	 * @return
	 */
	public Long getMbr_mid() {
		return mbr_mid;
	}

	/**
	 * 
	 * @param mbr_mid
	 */
	public void setMbr_mid(Long mbr_mid) {
		this.mbr_mid = mbr_mid;
	}

	/**
	 * 
	 * @return
	 */
	public Long getClm_id() {
		return clm_id;
	}

	/**
	 * 
	 * @param clm_id
	 */
	public void setClm_id(Long clm_id) {
		this.clm_id = clm_id;
	}

	/**
	 * 
	 * @return
	 */
	public Long getClm_ln_nbr() {
		return clm_ln_nbr;
	}

	/**
	 * 
	 * @param clm_ln_nbr
	 */
	public void setClm_ln_nbr(Long clm_ln_nbr) {
		this.clm_ln_nbr = clm_ln_nbr;
	}

	/**
	 * 
	 * @return
	 */
	public Date getSvc_fr_dt() {
		return svc_fr_dt;
	}

	/**
	 * 
	 * @param svc_fr_dt
	 */
	public void setSvc_fr_dt(Date svc_fr_dt) {
		this.svc_fr_dt = svc_fr_dt;
	}

	/**
	 * 
	 * @return
	 */
	public Date getSvc_to_dt() {
		return svc_to_dt;
	}

	/**
	 * 
	 * @param svc_to_dt
	 */
	public void setSvc_to_dt(Date svc_to_dt) {
		this.svc_to_dt = svc_to_dt;
	}

	/**
	 * 
	 * @return
	 */
	public Long getProv_id() {
		return prov_id;
	}

	/**
	 * 
	 * @param prov_id
	 */
	public void setProv_id(Long prov_id) {
		this.prov_id = prov_id;
	}

	/**
	 * 
	 * @return
	 */
	public Date getAdjctn_ts() {
		return adjctn_ts;
	}

	/**
	 * 
	 * @param adjctn_ts
	 */
	public void setAdjctn_ts(Date adjctn_ts) {
		this.adjctn_ts = adjctn_ts;
	}

	/**
	 * 
	 * @return
	 */
	public Long getPln_id() {
		return pln_id;
	}

	/**
	 * 
	 * @param pln_id
	 */
	public void setPln_id(Long pln_id) {
		this.pln_id = pln_id;
	}

	/**
	 * 
	 * @return
	 */
	public Long getBnft_svc_id() {
		return bnft_svc_id;
	}

	/**
	 * 
	 * @param bnft_svc_id
	 */
	public void setBnft_svc_id(Long bnft_svc_id) {
		this.bnft_svc_id = bnft_svc_id;
	}

	/**
	 * 
	 * @return
	 */
	public String getOper_id() {
		return oper_id;
	}

	/**
	 * 
	 * @param oper_id
	 */
	public void setOper_id(String oper_id) {
		this.oper_id = oper_id;
	}

	/**
	 * 
	 * @return
	 */
	public Long getSub_mid() {
		return sub_mid;
	}

	/**
	 * 
	 * @param sub_mid
	 */
	public void setSub_mid(Long sub_mid) {
		this.sub_mid = sub_mid;
	}

	/**
	 * 
	 * @return
	 */
	public String getAcct_ID() {
		return acct_ID;
	}

	/**
	 * 
	 * @param acct_ID
	 */
	public void setAcct_ID(String acct_ID) {
		this.acct_ID = acct_ID;
	}

	/**
	 * 
	 * @return
	 */
	public Long getVend_id() {
		return vend_id;
	}

	/**
	 * 
	 * @param vend_id
	 */
	public void setVend_id(Long vend_id) {
		this.vend_id = vend_id;
	}
	
}
