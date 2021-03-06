package com.ccsp.accums.ledger.header.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class LedgerHeaderMapper implements IBaseMapper<LedgerHeaderDTO, LedgerHeaderEntity>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final LedgerHeaderMapper INSTANCE = Mappers.getMapper(LedgerHeaderMapper.class);
	
	public abstract SpendingSummaryDTO convertEntityToSpendingSummaryDTO(LedgerHeaderEntity entity);
	
	public abstract List<SpendingSummaryDTO> convertEntitiesToSpendingSummaryDTOs(List<LedgerHeaderEntity> entities);
	
	public abstract AccumsConsumptionDTO toAccumsConsumptionDTOList(@MappingTarget AccumsConsumptionDTO accumsConsumption, LedgerHeaderEntity entity);
}
