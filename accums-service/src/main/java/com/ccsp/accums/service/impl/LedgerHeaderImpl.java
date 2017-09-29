package com.ccsp.accums.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.accums.ledger.repository.LedgerHeaderRepository;
import com.ccsp.accums.mapper.LedgerHeaderMapper;
import com.ccsp.accums.service.LedgerHeaderService;

@Component
public class LedgerHeaderImpl implements LedgerHeaderService{

	
	@Resource
	private LedgerHeaderRepository ledgerHeaderRepository;

	@Override
	public void setAdministrativePlan(LedgerHeaderDTO ledgerHeaderDTO) {
		LedgerHeader ledgerHeader = LedgerHeaderMapper.INSTANCE.toLedgerHeaderEntity(ledgerHeaderDTO);
		if(ledgerHeader != null){
			ledgerHeaderRepository.saveAndFlush(ledgerHeader);
		}		
	}
	
	
}
