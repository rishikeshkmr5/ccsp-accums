package com.ccsp.accums.ledger.summary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class LedgerSummaryMapper implements IBaseMapper<LedgerSummaryEntity, LedgerSummaryDTO>{

	/**
	 * Instance of LedgerSummaryMapper
	 * 
	 */
	public static final LedgerSummaryMapper INSTANCE = Mappers.getMapper(LedgerSummaryMapper.class);
}
