package com.ccsp.accums.ledger.header.service;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerHeaderService extends CommonServiceImpl<LedgerHeaderDTO, LedgerHeaderEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@Override
	public JpaRepository<LedgerHeaderEntity, Long> getJPARepository() {
		return ledgerHeaderRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerHeaderDTO, LedgerHeaderEntity> getMapper() {
		return LedgerHeaderMapper.INSTANCE;
	}	
}
