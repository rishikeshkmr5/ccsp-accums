package com.ccsp.accums.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.ledger.repository.AccumulationSummaryRepository;
import com.ccsp.accums.mapper.AccumulationSummaryMapper;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Component
public class AccumulationSummaryServiceImpl extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private AccumulationSummaryRepository accumulationSummaryRepository;
	
	@Resource
	private AccumulationHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumulationSummary, Long> getJPARepository() {
		return accumulationSummaryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumulationSummary, AccumulationSummaryDTO> getMapper() {
		return AccumulationSummaryMapper.INSTANCE;
	}
	
	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#create(com.ccsp.common.dto.ICommonDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		AccumulationSummaryDTO accumulationSummaryDTO = (AccumulationSummaryDTO) dto;
		AccumulationHeader ledger= ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
		
		AccumulationSummary accumulationSummary = getMapper().convertToEntity(accumulationSummaryDTO);
		
		accumulationSummary.setLedgerHeader(ledger);
		
		if(accumulationSummary != null){
			accumulationSummary = getJPARepository().saveAndFlush(accumulationSummary);
		}
		
		ICommonDTO resultDTO =  getMapper().convertToDTO(accumulationSummary);
		return (T) resultDTO;
	}
	
	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#readAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<AccumulationSummaryDTO> accumulationSummaryDTOs = new ArrayList<>(); 
		List<AccumulationSummary> accumulationSummaries= accumulationSummaryRepository.findAll();
		
		if(accumulationSummaries == null || accumulationSummaries.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		
		for(AccumulationSummary accumulationSummary: accumulationSummaries) {
			
			AccumulationSummaryDTO accumulationSummaryDTO=getMapper().convertToDTO(accumulationSummary);
			accumulationSummaryDTO.setLedgerHeaderID(accumulationSummary.getLedgerHeader().getLedgerID());
			accumulationSummaryDTOs.add(accumulationSummaryDTO);
			
		}
		return (List<T>) accumulationSummaryDTOs;
		
	}
}


