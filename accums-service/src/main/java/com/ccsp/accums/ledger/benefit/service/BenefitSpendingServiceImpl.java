package com.ccsp.accums.ledger.benefit.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.benefit.dto.BenefitSpendingDTO;
import com.ccsp.accums.ledger.benefit.mapper.BenefitSpendingMapper;
import com.ccsp.accums.ledger.benefit.repository.BenefitSpendingRepository;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Component
public class BenefitSpendingServiceImpl extends CommonServiceImpl<BenefitSpendingDTO, LedgerSummaryEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private BenefitSpendingRepository benefitSpendingRepository;
	
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;


	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@Override
	public JpaRepository<LedgerSummaryEntity, Long> getJPARepository() {
		return benefitSpendingRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<BenefitSpendingDTO, LedgerSummaryEntity> getMapper() {
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
		List<LedgerSummaryEntity> summaries = null;
		List<BenefitSpendingDTO> benefitSpendingDTOs = new ArrayList<BenefitSpendingDTO>();
			summaries = benefitSpendingRepository.findBymemberId(memberID);
			if (summaries.isEmpty()) 
				throw new NotFoundException(
						"There are no Summaries Balance Benefit available for memberid : " + memberID);
			for(LedgerSummaryEntity accumulationSummary : summaries) {
				
				BenefitSpendingDTO benefitSpendingDTO = getMapper().convertToDTO(accumulationSummary);
				benefitSpendingDTO.setServices(accumulationSummary.getLedgerHeader().getServiceName());
				benefitSpendingDTOs.add(benefitSpendingDTO);
			}
			return benefitSpendingDTOs;
	}


}
