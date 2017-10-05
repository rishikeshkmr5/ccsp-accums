package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class AccumulationHeaderMapper implements IBaseMapper<AccumulationHeader, AccumulationHeaderDTO>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final AccumulationHeaderMapper INSTANCE = Mappers.getMapper(AccumulationHeaderMapper.class);
	
	/* (non-Javadoc)
	 * @see com.ccsp.common.mapper.IBaseMapper#convertToEntity(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	@Mappings({
		@Mapping(target = "accumln_hdr_id", source = "accumulationHeaderID"),
		@Mapping(target = "mbr_mid", source = "memberMID"),
		@Mapping(target = "clm_id", source = "claimID"),
		@Mapping(target = "clm_ln_nbr", source = "claimLineNumber"),
		@Mapping(target = "svc_fr_dt", source = "serviceFromDate"),
		@Mapping(target = "svc_to_dt", source = "serviceToDate"),
		@Mapping(target = "prov_id", source = "providerID"),
		@Mapping(target = "adjctn_ts", source = "adjudicationTimestamp"),
		@Mapping(target = "pln_id", source = "planId"),
		@Mapping(target = "bnft_svc_id", source = "benefitServiceID"),
		@Mapping(target = "oper_id", source = "operatorID"),
		@Mapping(target = "sub_mid", source = "subscriberMID"),
		@Mapping(target = "acct_ID", source = "accountID"),
		@Mapping(target = "vend_id", source = "vendorID"),
	})
	public abstract AccumulationHeader convertToEntity(AccumulationHeaderDTO dto);
	
	/* (non-Javadoc)
	 * @see com.ccsp.common.mapper.IBaseMapper#convertToDTO(java.io.Serializable)
	 */
	@Override
	@Mappings({
		@Mapping(source = "accumln_hdr_id", target = "accumulationHeaderID"),
		@Mapping(source = "mbr_mid", target = "memberMID"),
		@Mapping(source = "clm_id", target = "claimID"),
		@Mapping(source = "clm_ln_nbr", target = "claimLineNumber"),
		@Mapping(source = "svc_fr_dt", target = "serviceFromDate"),
		@Mapping(source = "svc_to_dt", target = "serviceToDate"),
		@Mapping(source = "prov_id", target = "providerID"),
		@Mapping(source = "adjctn_ts", target = "adjudicationTimestamp"),
		@Mapping(source = "pln_id", target = "planId"),
		@Mapping(source = "bnft_svc_id", target = "benefitServiceID"),
		@Mapping(source = "oper_id", target = "operatorID"),
		@Mapping(source = "sub_mid", target = "subscriberMID"),
		@Mapping(source = "acct_ID", target = "accountID"),
		@Mapping(source = "vend_id", target = "vendorID"),
	})
	public abstract AccumulationHeaderDTO convertToDTO(AccumulationHeader entity);
	
}
