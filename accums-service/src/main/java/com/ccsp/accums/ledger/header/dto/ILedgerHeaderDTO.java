package com.ccsp.accums.ledger.header.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = LedgerHeaderDTO.class)
public interface ILedgerHeaderDTO {
	
	Double getAllowedAmount();
	void setAllowedAmount(Double allowedAmount);
	String getMemberId();
	void setMemberId(String memberID) ;
	String getSubscriberId();
	void setSubscriberId(String subscriberID);
	String getServiceName();
	void setServiceName(String serviceName);
	String getNetworkCode();
	void setNetworkCode(String network);
}
