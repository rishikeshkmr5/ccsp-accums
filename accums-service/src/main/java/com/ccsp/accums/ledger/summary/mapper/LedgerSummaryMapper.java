package com.ccsp.accums.ledger.summary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author nnarayanaperumaln
 *
 */
@Mapper
public abstract class LedgerSummaryMapper implements IBaseMapper<LedgerSummaryDTO, LedgerSummaryEntity>{

	/**
	 * Instance of LedgerSummaryMapper
	 * 
	 */
	public static final LedgerSummaryMapper INSTANCE = Mappers.getMapper(LedgerSummaryMapper.class);
	
	/**
	 * @param ledgerHeaderDTO
	 * @return
	 */
	@Mappings({@Mapping(target = "id", ignore = true)})
	public abstract LedgerSummaryEntity convertHeaderDTOtoEntity(LedgerHeaderDTO ledgerHeaderDTO);
}
