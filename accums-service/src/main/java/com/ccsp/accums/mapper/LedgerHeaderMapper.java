package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;

@Mapper
public abstract class LedgerHeaderMapper {

	public static final LedgerHeaderMapper INSTANCE = Mappers.getMapper(LedgerHeaderMapper.class);
	
	/*@Mappings({
		@Mapping(target="dateTimeProcessed", source="dateTimeProcessed")
	})*/
	public abstract LedgerHeader toLedgerHeaderEntity(LedgerHeaderDTO ledgerHeaderDTO);
}
