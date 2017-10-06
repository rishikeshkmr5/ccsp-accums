package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.AccumsEntryDTO;
import com.ccsp.accums.ledger.entity.AccumsEntry;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class AccumsEntryMapper implements IBaseMapper<AccumsEntry, AccumsEntryDTO>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final AccumsEntryMapper INSTANCE = Mappers.getMapper(AccumsEntryMapper.class);

	//public abstract AccumsEntry convertToEntity(AccumsEntryDTO accumsEntityDTO);
	
}
