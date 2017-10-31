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
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

@Component
public class LedgerEntryService extends CommonServiceImpl<LedgerEntryDTO, LedgerEntryEntity> {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerEntryDTO, LedgerEntryEntity> getMapper() {
		return LedgerEntryMapper.INSTANCE;
	}

	/**
	 * Creates the provided Ledger Entry. It expects ledger header id and primary
	 * ledger entry id along with other attributes.
	 * 
	 * @param dto
	 * @return T
	 */
	@Override
	public LedgerEntryDTO create(LedgerEntryDTO dto) {
		// convert the dto to entity
		LedgerEntryEntity ledgerEntry = getMapper().convertToEntity(dto);

		// find the header entity and set it to the ledger entry object
		LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(dto.getLedgerHeaderID());
		ledgerEntry.setLedgerHeader(ledger);

		// set linkToPrimary in the ledger entry
		if (dto.getLinkToPrimary() != null) {
			LedgerEntryEntity primaryLedgerEntry = getJPARepository().findOne(dto.getLinkToPrimary());
			ledgerEntry.setPrimaryLedgerEntry(primaryLedgerEntry);
		}

		// persist the ledger entry
		ledgerEntry = getJPARepository().saveAndFlush(ledgerEntry);
		// set the auto generated id to the dto and return it back to the caller
		dto.setId(ledgerEntry.getId());
		return getMapper().convertToDTO(ledgerEntry);
	}

	/**
	 * Persists provided list of data. Populates the required entities like header
	 * entity and primary reportable entity.
	 * 
	 * @param ledgerEntries
	 * @return
	 */
	@Override
	public List<LedgerEntryDTO> create(List<LedgerEntryDTO> dtoList) {
		List<LedgerEntryEntity> entities = new ArrayList<LedgerEntryEntity>();

		boolean isFirst = true;
		LedgerEntryEntity primaryLedgerEntry = null;
		LedgerHeaderEntity ledgerHeader = null;
		// iterate the ledger entries to populate the ledger header and linkToPrimary
		// details
		for (LedgerEntryDTO ledgerEntry : dtoList) {
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
		// save the update ledger entries
		getJPARepository().save(entities);

		List<LedgerEntryDTO> ledgerEntryResults = new ArrayList<LedgerEntryDTO>();
		// iterate the ledger entry entities to update the dtos and return it back to
		// the caller
		for (LedgerEntryEntity entryEntity : entities) {
			LedgerEntryDTO dto = getMapper().convertToDTO(entryEntity);
			if (entryEntity.getPrimaryLedgerEntry() != null) {
				dto.setLinkToPrimary(entryEntity.getPrimaryLedgerEntry().getId());
			}
			if (entryEntity.getLedgerHeader() != null) {
				dto.setLedgerHeaderID(entryEntity.getLedgerHeader().getId());
			}
			ledgerEntryResults.add(dto);
		}
		return ledgerEntryResults;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ccsp.common.service.impl.CommonServiceImpl#update(com.ccsp.common.dto.
	 * ICommonDTO)
	 */
	@Override
	public LedgerEntryDTO update(LedgerEntryDTO dto) {
		LedgerEntryEntity ledgerEntryEntity = getMapper().convertToEntity(dto);
		//find the ledger entry and update it
		LedgerEntryEntity existingEntity = getJPARepository().findOne(dto.getId());
		if (existingEntity != null)
			ledgerEntryEntity = getJPARepository().save(ledgerEntryEntity);
		return dto;

	}
}
