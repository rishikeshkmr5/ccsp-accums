package com.ccsp.accums.ledger.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Accumulation Header
 *
 */
/**
 * @author vamehta
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccumulationSummaryDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;

	private Long summaryID;
	
	@NotNull(message = "Ledger header ID cannot be empty")
	private Long ledgerHeaderID;
	
	private String subscriberID;
	
	private String memberID;
	
	private String planID;
	
	private String accumKey;
	
	private String accumName;
	
	@NotNull(message = "Accum type cannot be empty")
	private String accumType;
	
	private Double amount;
	
	private String network;
	
	private String unitOfMeasure;
	
	private Double maxAmount;
	
	private Integer maxVisit;
	
	private Date effectiveDt;
	
	private Date startDt;
	
	private Date endDt;

	/**
	 * @return
	 */
	public Long getSummaryID() {
		return summaryID;
	}

	/**
	 * @param summaryID
	 */
	public void setSummaryID(Long summaryID) {
		this.summaryID = summaryID;
	}

	/**
	 * @return
	 */
	public String getSubscriberID() {
		return subscriberID;
	}

	/**
	 * @param subscriberID
	 */
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	/**
	 * @return
	 */
	public String getMemberID() {
		return memberID;
	}

	/**
	 * @param memberID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * @return
	 */
	public String getPlanID() {
		return planID;
	}

	/**
	 * @param planID
	 */
	public void setPlanID(String planID) {
		this.planID = planID;
	}

	/**
	 * @return
	 */
	public String getAccumKey() {
		return accumKey;
	}

	/**
	 * @param accumKey
	 */
	public void setAccumKey(String accumKey) {
		this.accumKey = accumKey;
	}

	/**
	 * @return
	 */
	public String getAccumName() {
		return accumName;
	}

	/**
	 * @param accumName
	 */
	public void setAccumName(String accumName) {
		this.accumName = accumName;
	}

	/**
	 * @return
	 */
	public String getAccumType() {
		return accumType;
	}

	/**
	 * @param accumType
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}

	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @return
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return
	 */
	public Double getMaxAmount() {
		return maxAmount;
	}

	/**
	 * @param maxAmount
	 */
	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * @return
	 */
	public Integer getMaxVisit() {
		return maxVisit;
	}

	/**
	 * @param maxVisit
	 */
	public void setMaxVisit(Integer maxVisit) {
		this.maxVisit = maxVisit;
	}

	/**
	 * @return
	 */
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	/**
	 * @param effectiveDt
	 */
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	/**
	 * @return
	 */
	public Long getLedgerHeaderID() {
		return ledgerHeaderID;
	}

	/**
	 * @param ledgerHeaderID
	 */
	public void setLedgerHeaderID(Long ledgerHeaderID) {
		this.ledgerHeaderID = ledgerHeaderID;
	}

	/**
	 * @return
	 */
	public Date getStartDt() {
		return startDt;
	}

	/**
	 * @param startDt
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	/**
	 * @return
	 */
	public Date getEndDt() {
		return endDt;
	}

	/**
	 * @param endDt
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	
}
