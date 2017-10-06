package com.ccsp.accums.service.impl;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.AccumulationSummaryRepository;
import com.ccsp.accums.mapper.AccumulationSummaryMapper;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class AccumulationSummaryServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private AccumulationSummaryRepository accumulationSummaryRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumulationSummary, Long> getJPARepository() {
		return accumulationSummaryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumulationSummary, AccumulationSummaryDTO> getMapper() {
		return AccumulationSummaryMapper.INSTANCE;
	}	
}
