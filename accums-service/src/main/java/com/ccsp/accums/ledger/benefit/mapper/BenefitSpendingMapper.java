package com.ccsp.accums.ledger.benefit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.benefit.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class BenefitSpendingMapper implements IBaseMapper<BenefitSpendingDTO, LedgerSummaryEntity>{

	/**
	 * Instance of BenefitBalanceMapper
	 * 
	 */
	public static final BenefitSpendingMapper INSTANCE = Mappers.getMapper(BenefitSpendingMapper.class);
	
}
