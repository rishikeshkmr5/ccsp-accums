package com.ccsp.accums.ledger.entry.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * Mapper to convert LedgerEntryEntity to LedgerEntryDTO
 * @author nnarayanaperumaln
 *
 */
@Mapper
public abstract class LedgerEntryMapper implements IBaseMapper<LedgerEntryDTO, LedgerEntryEntity>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final LedgerEntryMapper INSTANCE = Mappers.getMapper(LedgerEntryMapper.class);
	
	/**
	 * @param entity
	 * @return
	 */
	@Named("toDto")
	@Mappings({
	@Mapping(source = "ledgerHeader.dcn", target = "dcn"),
	@Mapping(source = "ledgerHeader.networkCode", target = "networkCode"),
	@Mapping(source = "ledgerHeader.serviceDate", target = "serviceDate"),
	@Mapping(source = "ledgerHeader.processedDate", target = "processedDate"),
	@Mapping(source = "ledgerHeader.allowedAmount", target = "allowedAmount"),
	@Mapping(source = "ledgerHeader.memberId", target = "memberId"),
	@Mapping(source = "ledgerHeader.subscriberId", target = "subscriberId")})
	public abstract AccumsConsumptionDTO toAccumsConsumptionDTO(LedgerEntryEntity entity);
	
	/**
	 * @param ledgerEntryEntityList
	 * @return
	 */
	@IterableMapping(qualifiedByName = "toDto")
	public abstract List<AccumsConsumptionDTO> toAccumsConsumptionDTOList(List<LedgerEntryEntity> ledgerEntryEntityList);

}
