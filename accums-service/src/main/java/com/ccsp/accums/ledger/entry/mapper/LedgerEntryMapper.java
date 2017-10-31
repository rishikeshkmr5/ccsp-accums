package com.ccsp.accums.ledger.entry.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class LedgerEntryMapper implements IBaseMapper<LedgerEntryDTO, LedgerEntryEntity>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final LedgerEntryMapper INSTANCE = Mappers.getMapper(LedgerEntryMapper.class);

}
