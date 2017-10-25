package com.ccsp.accums.ledger.summary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.ILedgerSummaryRepository;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerSummaryService extends CommonServiceImpl<LedgerSummaryDTO, LedgerSummaryEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ILedgerSummaryRepository ledgerSummaryRepository;

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerSummaryDTO, LedgerSummaryEntity> getMapper() {
		return LedgerSummaryMapper.INSTANCE;
	}

	/**
	 * Creates the provided Ledger Entry.
	 * It expects ledger header id along with other attributes.
	 * @param dto
	 * @return T
	 */
	@Override
	public LedgerSummaryDTO create(LedgerSummaryDTO dto) {
		
		LedgerSummaryEntity ledgerSummaryEntity = getMapper().convertToEntity(dto);
		
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(dto.getLedgerHeaderID());
		ledgerSummaryEntity.setLedgerHeader(ledger);
		
		ledgerSummaryEntity = ledgerSummaryRepository.save(ledgerSummaryEntity);
		
		return getMapper().convertToDTO(ledgerSummaryEntity);
	}
	
	
	public void createSummary(LedgerSummaryEntity ledgerSummaryEntity) {
		LedgerSummaryEntity result = null;
		result = ledgerSummaryRepository.findLedgerSummary(ledgerSummaryEntity.getMemberID(),ledgerSummaryEntity.getAccumType(),ledgerSummaryEntity.getNetwork(),ledgerSummaryEntity.getNetworkTier());
		if(result != null)
		{
			result.setAmount(result.getAmount()+ledgerSummaryEntity.getAmount());
			ledgerSummaryRepository.save(result);
		}else {
			result = ledgerSummaryEntity;
			result.setEffectiveDt(new Date());
			result.setEndDt(new Date());
			result.setMaxAmount(10000d);
			result.setMaxVisit(100);
			result.setPlanID(10l);
			ledgerSummaryRepository.save(result);
		}
		ledgerSummaryRepository.flush();
	}
	
	/**
	 * Persists provided list of data.
	 * Populates the required entities like header entity and primary reportable entity.
	 * @param ledgerEntries
	 * @return
	 */
	@Override
	public List<LedgerSummaryDTO> create(List<LedgerSummaryDTO> dtoList){
		List<LedgerSummaryEntity> summaryEntities = new ArrayList<LedgerSummaryEntity>();
		
		boolean isFirst = true;
		LedgerHeaderEntity ledgerHeader = null;
		
		for(LedgerSummaryDTO summaryDTO : dtoList) {
			LedgerSummaryEntity summaryEntity = getMapper().convertToEntity(summaryDTO);
			if (isFirst) {
				ledgerHeader = ledgerHeaderRepository.findOne(summaryDTO.getLedgerHeaderID());
				isFirst = false;
			}
			summaryEntity.setLedgerHeader(ledgerHeader);
			summaryEntities.add(summaryEntity);
		}
		
		getJPARepository().save(summaryEntities);
		
		List<LedgerSummaryDTO> summaryDTOResults = new ArrayList<LedgerSummaryDTO>();
		
		for(LedgerSummaryEntity summaryEntity : summaryEntities) {
			LedgerSummaryDTO dto = getMapper().convertToDTO(summaryEntity);
			if (summaryEntity.getLedgerHeader() != null) {
				dto.setLedgerHeaderID(summaryEntity.getLedgerHeader().getId());
			}
			summaryDTOResults.add(dto);
		}
		return summaryDTOResults;
	}
	
	@Override
	public JpaRepository<LedgerSummaryEntity, Long> getJPARepository() {
		// TODO Auto-generated method stub
		return ledgerSummaryRepository;
	}
}
