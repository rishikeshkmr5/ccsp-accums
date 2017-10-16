package com.ccsp.accums.ledger.benefit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.benefit.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class BenefitBalanceMapper implements IBaseMapper<LedgerSummaryEntity, BenefitBalanceDTO>{

	/**
	 * Instance of BenefitBalanceMapper
	 * 
	 */
	public static final BenefitBalanceMapper INSTANCE = Mappers.getMapper(BenefitBalanceMapper.class);
	
}
