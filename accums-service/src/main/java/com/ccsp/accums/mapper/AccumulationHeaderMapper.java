package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class AccumulationHeaderMapper implements IBaseMapper<AccumulationHeader, AccumulationHeaderDTO>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final AccumulationHeaderMapper INSTANCE = Mappers.getMapper(AccumulationHeaderMapper.class);
	
}
