package com.ccsp.accums.utilization.dto;

import java.util.List;

public class IndividualUtilizationDTO {
	private String memberID;
	
	private String accumType;
	
	List<UtilizationPeriodDetailDTO> individualUtilizationPeriodDetailDTOList;
	
	

	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getAccumType() {
		return accumType;
	}

	public void setAccumType(String accumType) {
		this.accumType = accumType;
	}

	public List<UtilizationPeriodDetailDTO> getIndividualUtilizationPeriodDetailDTOList() {
		return individualUtilizationPeriodDetailDTOList;
	}

	public void setIndividualUtilizationPeriodDetailDTOList(
			List<UtilizationPeriodDetailDTO> individualUtilizationPeriodDetailDTOList) {
		this.individualUtilizationPeriodDetailDTOList = individualUtilizationPeriodDetailDTOList;
	}
	
	

}
