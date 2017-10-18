package com.ccsp.accums.ledger.summary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.LedgerSummaryRepository;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerSummaryService extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerSummaryRepository ledgerSummaryRepository;

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<LedgerSummaryEntity, Long> getJPARepository() {
		return ledgerSummaryRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<LedgerSummaryEntity, LedgerSummaryDTO> getMapper() {
		return LedgerSummaryMapper.INSTANCE;
	}

	/**
	 * Creates the provided Ledger Entry.
	 * It expects ledger header id along with other attributes.
	 * @param dto
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		LedgerSummaryDTO ledgerSummaryDTO = (LedgerSummaryDTO) dto;
		LedgerSummaryEntity ledgerSummaryEntity = getMapper().convertToEntity(ledgerSummaryDTO);
		
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(ledgerSummaryDTO.getLedgerHeaderID());
		ledgerSummaryEntity.setLedgerHeader(ledger);
		
		ledgerSummaryEntity = getJPARepository().saveAndFlush(ledgerSummaryEntity);
		
		ICommonDTO resultDTO =  getMapper().convertToDTO(ledgerSummaryEntity);
		return (T) resultDTO;
	}
	
	/**
	 * Persists provided list of data.
	 * Populates the required entities like header entity and primary reportable entity.
	 * @param ledgerEntries
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> create(List<T> dtoList){
		List<LedgerSummaryDTO> summaryDTOList = (List<LedgerSummaryDTO>) dtoList;
		List<LedgerSummaryEntity> summaryEntities = new ArrayList<LedgerSummaryEntity>();
		
		boolean isFirst = true;
		LedgerHeaderEntity ledgerHeader = null;
		
		for(LedgerSummaryDTO summaryDTO : summaryDTOList) {
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
		return (List<T>) summaryDTOResults;
	}
}
