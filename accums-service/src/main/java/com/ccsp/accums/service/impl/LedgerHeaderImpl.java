package com.ccsp.accums.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.accums.ledger.repository.LedgerHeaderRepository;
import com.ccsp.accums.mapper.LedgerHeaderMapper;
import com.ccsp.accums.service.LedgerHeaderService;

import javassist.NotFoundException;

@Component
public class LedgerHeaderImpl implements LedgerHeaderService{

	
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.accums.service.LedgerHeaderService#setAdministrativePlan(com.ccsp.accums.ledger.dto.LedgerHeaderDTO)
	 * Persist the ledgerHeader in database
	 */
	@Override
	public void setLedgerHeader(LedgerHeaderDTO ledgerHeaderDTO) {
		LedgerHeader ledgerHeader = LedgerHeaderMapper.INSTANCE.toLedgerHeaderEntity(ledgerHeaderDTO);
		if(ledgerHeader != null){
			ledgerHeaderRepository.saveAndFlush(ledgerHeader);
		}		
	}

	/**
	 * @see com.ccsp.accums.service.LedgerHeaderService#getAllLedgerHeader()
	 * Get all ledgerHeader from database
	 */
	@Override
	public List<LedgerHeaderDTO> getAllLedgerHeader() throws NotFoundException {
		List<LedgerHeader> ledgerHeaders=ledgerHeaderRepository.findAll();
		if(ledgerHeaders == null || ledgerHeaders.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		return LedgerHeaderMapper.INSTANCE.toLedgerHeaderList(ledgerHeaders);
	}
	
	
}