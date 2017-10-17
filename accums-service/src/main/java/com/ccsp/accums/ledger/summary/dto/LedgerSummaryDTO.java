package com.ccsp.accums.ledger.summary.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
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
public class LedgerSummaryDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	private Long summaryID;
	
	@NotNull(message = "Ledger header ID cannot be empty")
	private Long ledgerHeaderID;
	
	private String subscriberID;
	
	private String memberID;
	
	private String planID;
		
	@NotNull(message = "AccumTypeName cannot be empty")
	private String accumTypeName;
	
	private Double amount;
	
	private String network;
	
	private String networkTierName;
	
	private String unitOfMeasure;
	
	private Double maxAmount;
	
	private Integer maxVisit;
	
	private Date effectiveDt;
	
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
	public Date getEndDt() {
		return endDt;
	}

	/**
	 * @param endDt
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	/**
	 * @return
	 */
	public String getNetworkTierName() {
		return networkTierName;
	}

	/**
	 * @param networkTierName
	 */
	public void setNetworkTierName(String networkTierName) {
		this.networkTierName = networkTierName;
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
	public String getAccumTypeName() {
		return accumTypeName;
	}
	/**
	 * @param accumTypeName
	 */
	public void setAccumTypeName(String accumTypeName) {
		this.accumTypeName = accumTypeName;
	}
	
	
}
