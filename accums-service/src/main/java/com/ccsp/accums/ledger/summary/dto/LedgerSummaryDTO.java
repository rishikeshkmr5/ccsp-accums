package com.ccsp.accums.ledger.summary.dto;

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
public class LedgerSummaryDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 4325638042231113322L;

	private Long id;
	
	@NotNull(message = "Ledger header ID cannot be empty")
	private Long ledgerHeaderID;
	
	private String subscriberID;
	
	private String memberID;
	
	private Long planID;
		
	@NotNull(message = "AccumTypeName cannot be empty")
	private String accumType;
	
	private Double amount;
	
	private String network;
	
	private String networkTier;
	
	private String unitOfMeasure;
	
	private Double maxAmount;
	
	private Integer maxVisit;
	
	private Date effectiveDt;
	
	private Date endDt;

	/**
	 * Default constructor.
	 */
	public LedgerSummaryDTO() { }

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
	public Long getPlanID() {
		return planID;
	}

	/**
	 * @param planID
	 */
	public void setPlanID(Long planID) {
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
	 * @return the networkTier
	 */
	public String getNetworkTier() {
		return networkTier;
	}

	/**
	 * @param networkTier the networkTier to set
	 */
	public void setNetworkTier(String networkTier) {
		this.networkTier = networkTier;
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
	 * @return the accumType
	 */
	public String getAccumType() {
		return accumType;
	}

	/**
	 * @param accumType the accumType to set
	 */
	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}
}
