package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class LedgerHeaderMapper implements IBaseMapper<LedgerHeader, LedgerHeaderDTO>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final LedgerHeaderMapper INSTANCE = Mappers.getMapper(LedgerHeaderMapper.class);
}
