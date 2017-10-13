package com.ccsp.accums.ledger.dto;

import java.util.List;

public class ClaimAccumEntryDTO {
	
	private List<AccumsEntryDTO> accumEntryList;

	public List<AccumsEntryDTO> getAccumEntryList() {
		return accumEntryList;
	}

	public void setAccumEntryList(List<AccumsEntryDTO> accumEntryList) {
		this.accumEntryList = accumEntryList;
	}	
}
