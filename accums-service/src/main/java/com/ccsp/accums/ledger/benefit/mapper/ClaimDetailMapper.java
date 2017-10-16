package com.ccsp.accums.ledger.benefit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.benefit.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.common.mapper.IBaseMapper;


@Mapper
public  abstract class ClaimDetailMapper implements IBaseMapper<LedgerHeaderEntity, ClaimDetailsForAccumTypeDTO>{
	
	public static final ClaimDetailMapper INSTANCE = Mappers.getMapper(ClaimDetailMapper.class);

}
