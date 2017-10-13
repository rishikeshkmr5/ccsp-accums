package com.ccsp.accums.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumsEntryDTO;
import com.ccsp.accums.ledger.dto.ClaimDetailsForAccumTypeDTO;
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
		AccumsEntry accumsEntry = getMapper().convertToEntity(accumsEntryDTO);
		
		AccumulationHeader ledger= ledgerHeaderRepository.findOne(accumsEntryDTO.getAccumHeaderId());
		
		
		
		accumsEntry.setLedgerHeader(ledger);
		
		if(accumsEntryDTO.getLinkToPrimary() != null) {
			AccumsEntry linkAccums = accumsEntryRepository.findOne(accumsEntryDTO.getLinkToPrimary());
			accumsEntry.setAccumsEntry(linkAccums);
		}
		
		
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
			if(ledgerEntry.getAccumsEntry()  != null) {
				ledgerEntryDTO.setLinkToPrimary(ledgerEntry.getAccumsEntry().getLedgerLineId());
			}
			accumsEntriesDTO.add(ledgerEntryDTO);
			
		}
		
		return (List<T>) accumsEntriesDTO;		
	}
	
	public List<AccumsEntryDTO> create(List<? extends ICommonDTO> accumsEntryList){
		List<AccumsEntry> accumsEntry = new ArrayList<>();
		List<AccumsEntryDTO> entryDTOList = new ArrayList<>();
		int counter = 1;
		AccumsEntry baseEntry = null;
		for(ICommonDTO dto : accumsEntryList) {
			AccumsEntry entry = new AccumsEntry();
			AccumsEntryDTO accumsEntryDTO = (AccumsEntryDTO)dto;
			entry = getMapper().convertToEntity(accumsEntryDTO);
			if(counter == 1) 
				baseEntry = entry;
			else
				entry.setAccumsEntry(baseEntry);
			accumsEntry.add(entry);
			counter++;
		}
		if(accumsEntry.size() > 0)
			ledgerHeaderRepository.save(accumsEntry);
		for(AccumsEntry entryEntity : accumsEntry) {
			AccumsEntryDTO dto = new AccumsEntryDTO();
			dto = getMapper().convertToDTO(entryEntity);
			if(entryEntity.getAccumsEntry() != null)
				dto.setLinkToPrimary(entryEntity.getAccumsEntry().getLedgerLineId());
			entryDTOList.add(dto);			
		}
		return entryDTOList;
	}
}
