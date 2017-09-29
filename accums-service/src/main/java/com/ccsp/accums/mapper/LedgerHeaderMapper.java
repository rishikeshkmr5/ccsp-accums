package com.ccsp.accums.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;

@Mapper
public abstract class LedgerHeaderMapper {

	public static final LedgerHeaderMapper INSTANCE = Mappers.getMapper(LedgerHeaderMapper.class);
	
	public abstract LedgerHeader toLedgerHeaderEntity(LedgerHeaderDTO ledgerHeaderDTO);
	
	@Named(value = "toDto")
	public abstract LedgerHeaderDTO toLedgerHeaderDTO(LedgerHeader ledgerHeader);
	
	@IterableMapping(qualifiedByName = "toDto")
	public abstract List<LedgerHeaderDTO> toLedgerHeaderList(List<LedgerHeader> ledgerHeader);
}
