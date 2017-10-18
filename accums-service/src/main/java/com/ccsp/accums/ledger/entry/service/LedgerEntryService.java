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
@Component
public class LedgerEntryService extends CommonServiceImpl  {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerEntryRepository ledgerEntryRepository;
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<LedgerEntryEntity, Long> getJPARepository() {
		return ledgerEntryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<LedgerEntryEntity, LedgerEntryDTO> getMapper() {
		return LedgerEntryMapper.INSTANCE;
	}	
	
	/**
	 * Creates the provided Ledger Entry.
	 * It expects ledger header id and primary ledger entry id along with other attributes.
	 * @param dto
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		
		LedgerEntryDTO accumsEntryDTO = (LedgerEntryDTO) dto;
		LedgerEntryEntity ledgerEntry = getMapper().convertToEntity(accumsEntryDTO);
		
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(accumsEntryDTO.getLedgerHeaderID());
		ledgerEntry.setLedgerHeader(ledger);
		
		if(accumsEntryDTO.getPrimaryLedgerEntryID() != null) {
			LedgerEntryEntity primaryLedgerEntry = getJPARepository().findOne(accumsEntryDTO.getPrimaryLedgerEntryID());
			ledgerEntry.setPrimaryLedgerEntry(primaryLedgerEntry);
		}
		
		ledgerEntry = getJPARepository().saveAndFlush(ledgerEntry);
		
		ICommonDTO resultDTO =  getMapper().convertToDTO(ledgerEntry);
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
		List<LedgerEntryDTO> ledgerEntries = (List<LedgerEntryDTO>) dtoList;
		List<LedgerEntryEntity> entities = new ArrayList<LedgerEntryEntity>();
		
		boolean isFirst = true;
		LedgerEntryEntity primaryLedgerEntry = null;
		LedgerHeaderEntity ledgerHeader = null;
		
		for(LedgerEntryDTO ledgerEntry : ledgerEntries) {
			LedgerEntryEntity entity = getMapper().convertToEntity(ledgerEntry);
			if (isFirst) {
				primaryLedgerEntry = entity;
				ledgerHeader = ledgerHeaderRepository.findOne(ledgerEntry.getLedgerHeaderID());
				isFirst = false;
			} else { 
				entity.setPrimaryLedgerEntry(primaryLedgerEntry);
			}
			entity.setLedgerHeader(ledgerHeader);
			entities.add(entity);
		}
		
		getJPARepository().save(entities);
		
		List<LedgerEntryDTO> ledgerEntryResults = new ArrayList<LedgerEntryDTO>();
		
		for(LedgerEntryEntity entryEntity : entities) {
			LedgerEntryDTO dto = getMapper().convertToDTO(entryEntity);
			if (entryEntity.getPrimaryLedgerEntry() != null) {
				dto.setPrimaryLedgerEntryID(entryEntity.getPrimaryLedgerEntry().getId());
			}
			if (entryEntity.getLedgerHeader() != null) {
				dto.setLedgerHeaderID(entryEntity.getLedgerHeader().getId());
			}
			ledgerEntryResults.add(dto);
		}
		return (List<T>) ledgerEntryResults;
	}
}
