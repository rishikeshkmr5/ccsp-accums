package com.ccsp.accums.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumsEntryDTO;
import com.ccsp.accums.ledger.dto.AccumsEntryPeriodDTO;

import com.ccsp.accums.ledger.entity.AccumsEntry;
import com.ccsp.accums.ledger.entity.AccumsEntryPeriod;
import com.ccsp.accums.ledger.entity.AccumsEntryPeriodEmbedd;

import com.ccsp.accums.ledger.repository.AccumsEntryPeriodRepository;
import com.ccsp.accums.ledger.repository.AccumsEntryRepository;

import com.ccsp.accums.mapper.AccumsEntryPeriodMapper;

import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;
@Component
public class AccumsLedgerServicePeriodImpl extends CommonServiceImpl{
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private AccumsEntryPeriodRepository accumsEntryPeriodRepository;
	@Resource
	private AccumsEntryRepository accumsEntryRepository;
	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumsEntryPeriod, Long> getJPARepository() {
		return accumsEntryPeriodRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumsEntryPeriod, AccumsEntryPeriodDTO> getMapper() {
		return AccumsEntryPeriodMapper.INSTANCE;
	}	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		AccumsEntryPeriodDTO accumsEntryPeriodDTO = (AccumsEntryPeriodDTO) dto;
		AccumsEntry accumsEntry = accumsEntryRepository.findOne(accumsEntryPeriodDTO.getAccumsEntryId());
		
		AccumsEntryPeriod accumsEntryPeriod = getMapper().convertToEntity(accumsEntryPeriodDTO);
		
		accumsEntryPeriod.setAccumsEntry(accumsEntry);
		
		AccumsEntryPeriodEmbedd accumsEntryPeriodEmbeddPk =  new AccumsEntryPeriodEmbedd();
		
		accumsEntryPeriodEmbeddPk.setAccumEntryId(accumsEntryPeriod.getAccumsEntry().getAccumEntryId());
		accumsEntryPeriodEmbeddPk.setPeriodQuantity(accumsEntryPeriodDTO.getPeriodQuantity());
		accumsEntryPeriodEmbeddPk.setPeriodTypeCode(accumsEntryPeriodDTO.getPeriodTypeCode());		
		accumsEntryPeriod.setAccumsEntryPeriodEmbeddPk(accumsEntryPeriodEmbeddPk);
		
		
		if(accumsEntryPeriod != null){
			accumsEntryPeriod = getJPARepository().saveAndFlush(accumsEntryPeriod);
		}
		
		ICommonDTO resultDTO =  getMapper().convertToDTO(accumsEntryPeriod);
		return (T) resultDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<AccumsEntryPeriodDTO> accumsEntriesPeriodDTO = new ArrayList<>(); 
		List<AccumsEntryPeriod> accumssEntriesPeriod= accumsEntryPeriodRepository.findAll();
		
		if(accumssEntriesPeriod == null || accumssEntriesPeriod.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		
		for(AccumsEntryPeriod ledgerEntryPeriod: accumssEntriesPeriod) {
			
			AccumsEntryPeriodDTO ledgerEntryDTO=getMapper().convertToDTO(ledgerEntryPeriod);
			ledgerEntryDTO.setAccumsEntryId(ledgerEntryPeriod.getAccumsEntryPeriodEmbeddPk().getAccumEntryId());
			ledgerEntryDTO.setPeriodQuantity(ledgerEntryPeriod.getAccumsEntryPeriodEmbeddPk().getPeriodQuantity());
			ledgerEntryDTO.setPeriodTypeCode(ledgerEntryPeriod.getAccumsEntryPeriodEmbeddPk().getPeriodTypeCode());		
			accumsEntriesPeriodDTO.add(ledgerEntryDTO);
			
		}
		return (List<T>) accumsEntriesPeriodDTO;
}
	
}