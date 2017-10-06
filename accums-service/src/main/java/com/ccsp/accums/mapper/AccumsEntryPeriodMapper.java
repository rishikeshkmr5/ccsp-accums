package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.AccumsEntryPeriodDTO;
import com.ccsp.accums.ledger.entity.AccumsEntryPeriod;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class AccumsEntryPeriodMapper implements IBaseMapper<AccumsEntryPeriod, AccumsEntryPeriodDTO> {
	
	public static final AccumsEntryPeriodMapper INSTANCE = Mappers.getMapper(AccumsEntryPeriodMapper.class);

	

}
