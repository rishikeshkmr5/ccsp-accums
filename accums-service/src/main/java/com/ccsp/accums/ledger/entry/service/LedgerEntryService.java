package com.ccsp.accums.ledger.entry.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.mapper.LedgerEntryMapper;
import com.ccsp.accums.ledger.entry.repository.LedgerEntryRepository;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;
@Component
public class LedgerEntryService extends CommonServiceImpl  {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerEntryRepository accumsEntryRepository;
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<LedgerEntryEntity, Long> getJPARepository() {
		return accumsEntryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<LedgerEntryEntity, LedgerEntryDTO> getMapper() {
		return LedgerEntryMapper.INSTANCE;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		LedgerEntryDTO accumsEntryDTO = (LedgerEntryDTO) dto;
		LedgerEntryEntity accumsEntry = getMapper().convertToEntity(accumsEntryDTO);
		
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(accumsEntryDTO.getAccumHeaderId());
		
		
		
		accumsEntry.setLedgerHeader(ledger);
		
		if(accumsEntryDTO.getLinkToPrimary() != null) {
			LedgerEntryEntity linkAccums = accumsEntryRepository.findOne(accumsEntryDTO.getLinkToPrimary());
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
		List<LedgerEntryDTO> accumsEntriesDTO = new ArrayList<>(); 
		List<LedgerEntryEntity> accumssEntries= accumsEntryRepository.findAll();
		
		if(accumssEntries == null || accumssEntries.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		
		for(LedgerEntryEntity ledgerEntry: accumssEntries) {
			
			LedgerEntryDTO ledgerEntryDTO=getMapper().convertToDTO(ledgerEntry);
			ledgerEntryDTO.setAccumHeaderId(ledgerEntry.getLedgerHeader().getLedgerID());
			if(ledgerEntry.getAccumsEntry()  != null) {
				ledgerEntryDTO.setLinkToPrimary(ledgerEntry.getAccumsEntry().getLedgerLineId());
			}
			accumsEntriesDTO.add(ledgerEntryDTO);
			
		}
		
		return (List<T>) accumsEntriesDTO;		
	}
	
	public List<LedgerEntryDTO> create(List<? extends ICommonDTO> accumsEntryList){
		List<LedgerEntryEntity> accumsEntry = new ArrayList<>();
		List<LedgerEntryDTO> entryDTOList = new ArrayList<>();
		int counter = 1;
		LedgerEntryEntity baseEntry = null;
		for(ICommonDTO dto : accumsEntryList) {
			LedgerEntryEntity entry = new LedgerEntryEntity();
			LedgerEntryDTO accumsEntryDTO = (LedgerEntryDTO)dto;
			entry = getMapper().convertToEntity(accumsEntryDTO);
			if(counter == 1) 
				baseEntry = entry;
			else
				entry.setAccumsEntry(baseEntry);
			accumsEntry.add(entry);
			counter++;
		}
		if(accumsEntry.size() > 0) {
			for(LedgerEntryEntity entryEntity : accumsEntry) {
				accumsEntryRepository.save(entryEntity);
			}			
		}
		for(LedgerEntryEntity entryEntity : accumsEntry) {
			LedgerEntryDTO dto = new LedgerEntryDTO();
			dto = getMapper().convertToDTO(entryEntity);
			if(entryEntity.getAccumsEntry() != null)
				dto.setLinkToPrimary(entryEntity.getAccumsEntry().getLedgerLineId());
			entryDTOList.add(dto);			
		}
		return entryDTOList;
	}
}
