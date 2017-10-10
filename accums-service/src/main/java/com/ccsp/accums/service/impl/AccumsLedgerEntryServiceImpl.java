package com.ccsp.accums.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumsEntryDTO;

import com.ccsp.accums.ledger.entity.AccumsEntry;
import com.ccsp.accums.ledger.entity.AccumulationHeader;

import com.ccsp.accums.ledger.repository.AccumsEntryRepository;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;

import com.ccsp.accums.mapper.AccumsEntryMapper;

import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;
@Component
public class AccumsLedgerEntryServiceImpl extends CommonServiceImpl  {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private AccumsEntryRepository accumsEntryRepository;
	@Resource
	private AccumulationHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<AccumsEntry, Long> getJPARepository() {
		return accumsEntryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<AccumsEntry, AccumsEntryDTO> getMapper() {
		return AccumsEntryMapper.INSTANCE;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		AccumsEntryDTO accumsEntryDTO = (AccumsEntryDTO) dto;
		AccumulationHeader ledger= ledgerHeaderRepository.findOne(accumsEntryDTO.getAccumHeaderId());
		
		AccumsEntry accumsEntry = getMapper().convertToEntity(accumsEntryDTO);
		
		accumsEntry.setLedgerHeader(ledger);
		
		if(accumsEntry != null){
			accumsEntry = getJPARepository().saveAndFlush(accumsEntry);
		}
		
		ICommonDTO resultDTO =  getMapper().convertToDTO(accumsEntry);
		return (T) resultDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<AccumsEntryDTO> accumsEntriesDTO = new ArrayList<>(); 
		List<AccumsEntry> accumssEntries= accumsEntryRepository.findAll();
		
		if(accumssEntries == null || accumssEntries.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		
		for(AccumsEntry ledgerEntry: accumssEntries) {
			
			AccumsEntryDTO ledgerEntryDTO=getMapper().convertToDTO(ledgerEntry);
			ledgerEntryDTO.setAccumHeaderId(ledgerEntry.getLedgerHeader().getLedgerID());
			accumsEntriesDTO.add(ledgerEntryDTO);
			
		}
		
		
		return (List<T>) accumsEntriesDTO;
		
	}


}
