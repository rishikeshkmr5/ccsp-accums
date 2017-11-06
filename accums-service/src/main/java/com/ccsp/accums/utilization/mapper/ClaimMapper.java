package com.ccsp.accums.utilization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.common.mapper.IBaseMapper;

@Mapper
public abstract class ClaimMapper implements IBaseMapper<ClaimDetailDTO, LedgerHeaderDTO>{

	/**
	 * Instance of ClaimDetailMapper
	 * 
	 */
	public static final ClaimMapper INSTANCE = Mappers.getMapper(ClaimMapper.class);

	
	@Mappings({
		@Mapping(target = "member", source = "memberId"),
		@Mapping(target = "subscriber", source = "subscriberId"),
		@Mapping(target = "claim", source = "dcn"),
		@Mapping(target = "claimLine", source = "claimLineId"),
		@Mapping(target = "service", source = "serviceName"),
		@Mapping(target = "network", source = "networkCode"),
		@Mapping(target = "serviceDt", source = "serviceDate"),
		@Mapping(target = "processedDt", source = "processedDate"),
		@Mapping(target = "amount", source = "allowedAmount"),
		@Mapping(target = "provider", ignore = true)
	})
	@Override
	public abstract ClaimDetailDTO convertToDTO(LedgerHeaderDTO ledgerHeaderDTO) ;
}