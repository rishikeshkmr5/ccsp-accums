package com.ccsp.accums.ledger.benefit.dto;

import java.util.Date;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Benefit Balance
 *
 */
public class BenefitBalanceDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;

	private String accumName;
	
	private String accumType;
	
	private String network;
	
	private Double maxAmount;
	
	private Date startDt;
	
	private Date endDt;


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
