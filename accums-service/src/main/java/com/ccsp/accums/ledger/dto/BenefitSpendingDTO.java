package com.ccsp.accums.ledger.dto;

import java.util.Date;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author Vaibhav
 * DTO class for Benefit Spending
 *
 */
public class BenefitSpendingDTO  implements ICommonDTO {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;

	private String accumName;
	
	private String services;
	
	private String network;
	
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

	/**
	 * @return
	 */
	public String getServices() {
		return services;
	}

	/**
	 * @param services
	 */
	public void setServices(String services) {
		this.services = services;
	}

	
	
}
