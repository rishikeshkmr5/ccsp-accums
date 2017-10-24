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
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;
@Component
public class LedgerEntryService extends CommonServiceImpl<LedgerEntryDTO, LedgerEntryEntity>  {
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
	@Override
	public JpaRepository<LedgerEntryEntity, Long> getJPARepository() {
		return ledgerEntryRepository;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerEntryDTO, LedgerEntryEntity> getMapper() {
		return LedgerEntryMapper.INSTANCE;
	}	
	
	/**
	 * Creates the provided Ledger Entry.
	 * It expects ledger header id and primary ledger entry id along with other attributes.
	 * @param dto
	 * @return T
	 */
	@Override
	public LedgerEntryDTO create(LedgerEntryDTO dto) {
		
		LedgerEntryEntity ledgerEntry = getMapper().convertToEntity(dto);
		
		LedgerHeaderEntity ledger= ledgerHeaderRepository.findOne(dto.getLedgerHeaderID());
		ledgerEntry.setLedgerHeader(ledger);
		
		if(dto.getPrimaryLedgerEntryID() != null) {
			LedgerEntryEntity primaryLedgerEntry = getJPARepository().findOne(dto.getPrimaryLedgerEntryID());
			ledgerEntry.setPrimaryLedgerEntry(primaryLedgerEntry);
		}
		
		ledgerEntry = getJPARepository().saveAndFlush(ledgerEntry);
		
		return getMapper().convertToDTO(ledgerEntry);
	}
	
	/**
	 * Persists provided list of data.
	 * Populates the required entities like header entity and primary reportable entity.
	 * @param ledgerEntries
	 * @return
	 */
	@Override
	public List<LedgerEntryDTO> create(List<LedgerEntryDTO> dtoList){
		List<LedgerEntryEntity> entities = new ArrayList<LedgerEntryEntity>();
		
		boolean isFirst = true;
		LedgerEntryEntity primaryLedgerEntry = null;
		LedgerHeaderEntity ledgerHeader = null;
		
		for(LedgerEntryDTO ledgerEntry : dtoList) {
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
		return ledgerEntryResults;
	}
	
	@Override
	public LedgerEntryDTO update(LedgerEntryDTO dto) {
		LedgerEntryEntity ledgerEntryEntity = getMapper().convertToEntity(dto);
		LedgerEntryEntity existingEntity = getJPARepository().findOne(dto.getId());
			if(existingEntity != null)
					
				ledgerEntryEntity	= getJPARepository().save(ledgerEntryEntity);
		
		return dto;
		
	}
}
