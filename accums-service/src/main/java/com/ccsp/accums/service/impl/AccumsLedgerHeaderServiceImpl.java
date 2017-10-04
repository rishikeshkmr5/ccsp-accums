package com.ccsp.accums.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.accums.ledger.repository.LedgerHeaderRepository;
import com.ccsp.accums.mapper.LedgerHeaderMapper;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author nnarayanaperumaln
 *
 */
@Component
public class AccumsLedgerHeaderServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<LedgerHeader, Long> getJPARepository() {
		return ledgerHeaderRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<LedgerHeader, LedgerHeaderDTO> getMapper() {
		return LedgerHeaderMapper.INSTANCE;
	}	
}
