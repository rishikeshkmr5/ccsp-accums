package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.ccsp.accums.ledger.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.common.mapper.IBaseMapper;


@Mapper
public  abstract class ClaimDetailMapper implements IBaseMapper<AccumulationHeader, ClaimDetailsForAccumTypeDTO>{
	
	public static final ClaimDetailMapper INSTANCE = Mappers.getMapper(ClaimDetailMapper.class);

}
