package com.ccsp.accums.ledger.header.dto;

import com.ccsp.common.dto.ICommonDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize
public interface ILedgerHeaderDTO extends ICommonDTO{
	
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
