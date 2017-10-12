package com.ccsp.accums.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.ledger.repository.BenefitSpendingRepository;
import com.ccsp.accums.mapper.BenefitSpendingMapper;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Component
public class BenefitSpendingServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private BenefitSpendingRepository benefitSpendingRepository;
	
	@Resource
	private AccumulationHeaderRepository accumulationHeaderRepository;


	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumulationSummary, Long> getJPARepository() {
		return benefitSpendingRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumulationSummary, BenefitSpendingDTO> getMapper() {
		return BenefitSpendingMapper.INSTANCE;
	}

	/**
	 * Method to get Benefit balance based on subscriber or member id
	 * 
	 * @param subscriberID
	 * @param memberID
	 * @return
	 * @throws NotFoundException
	 */
	public List<BenefitSpendingDTO> getBenefitSpending(String memberID) throws NotFoundException {
		List<AccumulationSummary> summaries = null;
		List<BenefitSpendingDTO> benefitSpendingDTOs = new ArrayList<BenefitSpendingDTO>();
			summaries = benefitSpendingRepository.findBymemberID(memberID);
			if (summaries.isEmpty()) 
				throw new NotFoundException(
						"There are no Summaries Balance Benefit available for memberid : " + memberID);
			for(AccumulationSummary accumulationSummary : summaries) {
				
				BenefitSpendingDTO benefitSpendingDTO = getMapper().convertToDTO(accumulationSummary);
				benefitSpendingDTO.setServices(accumulationSummary.getLedgerHeader().getService());
				benefitSpendingDTOs.add(benefitSpendingDTO);
			}
			return benefitSpendingDTOs;
	}


}
