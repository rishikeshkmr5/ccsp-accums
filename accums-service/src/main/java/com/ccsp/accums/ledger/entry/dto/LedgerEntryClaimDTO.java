package com.ccsp.accums.ledger.entry.dto;

import java.util.List;

public class LedgerEntryClaimDTO {
	
	private List<LedgerEntryDTO> accumEntryList;

	public List<LedgerEntryDTO> getAccumEntryList() {
		return accumEntryList;
	}

	public void setAccumEntryList(List<LedgerEntryDTO> accumEntryList) {
		this.accumEntryList = accumEntryList;
	}	
}
