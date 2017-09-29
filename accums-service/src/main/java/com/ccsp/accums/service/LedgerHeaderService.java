package com.ccsp.accums.service;

import java.util.List;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;

import javassist.NotFoundException;

public interface LedgerHeaderService {
	
	void setAdministrativePlan(LedgerHeaderDTO ledgerHeaderDTO);
	List<LedgerHeaderDTO> getAllLedgerHeader() throws NotFoundException;
}