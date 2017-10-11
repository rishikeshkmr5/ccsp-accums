package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class BenefitBalanceMapper implements IBaseMapper<AccumulationSummary, BenefitBalanceDTO>{

	/**
	 * Instance of BenefitBalanceMapper
	 * 
	 */
	public static final BenefitBalanceMapper INSTANCE = Mappers.getMapper(BenefitBalanceMapper.class);
	
}
