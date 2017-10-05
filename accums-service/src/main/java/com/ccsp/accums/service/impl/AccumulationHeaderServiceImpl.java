package com.ccsp.accums.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.mapper.AccumulationHeaderMapper;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class AccumulationHeaderServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private AccumulationHeaderRepository accumulationHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumulationHeader, Long> getJPARepository() {
		return accumulationHeaderRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumulationHeader, AccumulationHeaderDTO> getMapper() {
		return AccumulationHeaderMapper.INSTANCE;
	}	
}
