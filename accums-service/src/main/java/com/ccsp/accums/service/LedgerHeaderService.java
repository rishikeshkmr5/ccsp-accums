package com.ccsp.accums.service;

import java.util.List;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
public interface LedgerHeaderService {
	
	/**
	 * @param ledgerHeaderDTO
	 * 
	 */
	void setLedgerHeader(LedgerHeaderDTO ledgerHeaderDTO);
	
	
	/**
	 * @return List<LedgerHeaderDTO>
	 * @throws NotFoundException
	 * 
	 */
	List<LedgerHeaderDTO> getAllLedgerHeader() throws NotFoundException;
}