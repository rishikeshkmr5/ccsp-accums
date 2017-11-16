package com.ccsp.accums.utilization.dto;

import java.util.List;

public class FamilyUtilizationDTO {

	private String subscriberId;
	
	private String accumType;
	
	List<UtilizationPeriodDetailDTO> utilizationPeriodDetailDTOList;
	
	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getAccumType() {
		return accumType;
	}

	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}

	public List<UtilizationPeriodDetailDTO> getUtilizationPeriodDetailDTOList() {
		return utilizationPeriodDetailDTOList;
	}

	public void setUtilizationPeriodDetailDTOList(List<UtilizationPeriodDetailDTO> utilizationPeriodDetailDTOList) {
		this.utilizationPeriodDetailDTOList = utilizationPeriodDetailDTOList;
	}

	
	
	
}
