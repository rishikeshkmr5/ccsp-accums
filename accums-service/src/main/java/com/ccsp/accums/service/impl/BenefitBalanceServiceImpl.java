package com.ccsp.accums.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.BenefitBalanceRepository;
import com.ccsp.accums.mapper.BenefitBalanceMapper;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Component
public class BenefitBalanceServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private BenefitBalanceRepository benefitBalanceRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumulationSummary, Long> getJPARepository() {
		return benefitBalanceRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumulationSummary, BenefitBalanceDTO> getMapper() {
		return BenefitBalanceMapper.INSTANCE;
	}

	/**
	 * Method to get Benefit balance based on subscriber or member id
	 * 
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	public List<BenefitBalanceDTO> getBenefitBalance(String subscriberID, String memberID) throws NotFoundException {
		List<AccumulationSummary> summaries = null;
		if (subscriberID != null && subscriberID.length() > 0) {
			summaries = benefitBalanceRepository.findBysubscriberID(subscriberID);
			if (summaries.isEmpty())
				throw new NotFoundException(
						"There are no Summaries Balance Benefit available for subscriberid : " + subscriberID);
		} else if (memberID != null && memberID.length() > 0) {
			summaries = benefitBalanceRepository.findBymemberID(memberID);
			if (summaries.isEmpty())
				throw new NotFoundException(
						"There are no Summaries Balance Benefit available for memberid : " + memberID);
		} else {
			throw new NotFoundException("There are no Summaries Balance Benefit available");
		}
		return getMapper().convertToDTOList(summaries);
	}
}
