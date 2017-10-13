package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class AccumulationSummaryMapper implements IBaseMapper<AccumulationSummary, AccumulationSummaryDTO>{

	/**
	 * Instance of AccumulationSummaryMapper
	 * 
	 */
	public static final AccumulationSummaryMapper INSTANCE = Mappers.getMapper(AccumulationSummaryMapper.class);

	/* (non-Javadoc)
	 * @see com.ccsp.common.mapper.IBaseMapper#convertToEntity(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	@Mappings({
		@Mapping(target = "summaryID", ignore = true)
	})
	public abstract AccumulationSummary convertToEntity(AccumulationSummaryDTO dto);
}
