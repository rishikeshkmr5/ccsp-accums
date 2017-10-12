package com.ccsp.accums.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class BenefitSpendingMapper implements IBaseMapper<AccumulationSummary, BenefitSpendingDTO>{

	/**
	 * Instance of BenefitBalanceMapper
	 * 
	 */
	public static final BenefitSpendingMapper INSTANCE = Mappers.getMapper(BenefitSpendingMapper.class);
	
}
