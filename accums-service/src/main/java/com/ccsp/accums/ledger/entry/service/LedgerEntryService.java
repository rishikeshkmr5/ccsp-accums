package com.ccsp.accums.ledger.entry.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.mapper.LedgerEntryMapper;
import com.ccsp.accums.ledger.entry.repository.ILedgerEntryRepository;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

@Component
public class LedgerEntryService extends CommonServiceImpl<LedgerEntryDTO, LedgerEntryEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ILedgerEntryRepository iLedgerEntryRepository;
	
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@Override
	public JpaRepository<LedgerEntryEntity, Long> getJPARepository() {
		return iLedgerEntryRepository;
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
			ledgerEntry.setPrimaryLedgerEntryID(primaryLedgerEntry.getId());
		}

		// persist the ledger entry
		ledgerEntry = getJPARepository().save(ledgerEntry);
		// set the auto generated id to the dto and return it back to the caller
		dto.setId(ledgerEntry.getId());
		return getMapper().convertToDTO(ledgerEntry);
	}

	/**
	 * Maps the data from provided DTO to database entity model.
	 * 
	 * Invokes the repository to persist in database by passing the entity.
	 * 
	 * Persists provided list of data. Populates the required entities like header
	 * entity and primary reportable entity.
	 * 
	 * @param ledgerEntries
	 * @return
	 */
	@Override
	public List<LedgerEntryDTO> create(List<LedgerEntryDTO> dtoList) {
		//Convert DTO's to entities.
		List<LedgerEntryEntity> entities = getMapper().convertToEntityList(dtoList);

		boolean isFirst = true;
		
		//First ledger entry will be used as parent for all the remaining ledger entries.
		LedgerEntryEntity primaryLedgerEntry = null;
		
		//Ledger header will be needed to manage the JPA mappings, will be fetched from database for the first accum entry.
		LedgerHeaderEntity ledgerHeader = null;
		
		// iterate the ledger entries to populate the ledger header and linkToPrimary details.
		for (LedgerEntryEntity ledgerEntry : entities) {
			//Holds the activities that needs to be performed only first time.
			if (isFirst) {
				primaryLedgerEntry = ledgerEntry;
				ledgerHeader = ledgerHeaderRepository.findOne(ledgerEntry.getLedgerHeaderID());
				isFirst = false;
			} else {
				ledgerEntry.setPrimaryLedgerEntryID(primaryLedgerEntry.getId());
			}
			ledgerEntry.setLedgerHeader(ledgerHeader);
		}
		
		// save the update ledger entries
		getJPARepository().save(entities);

		List<LedgerEntryDTO> ledgerEntryResults = new ArrayList<LedgerEntryDTO>();
		
		// iterate the ledger entry entities to update the dtos and return it back to the caller
		for (LedgerEntryEntity entryEntity : entities) {
			LedgerEntryDTO dto = getMapper().convertToDTO(entryEntity);
			if (entryEntity.getPrimaryLedgerEntryID() != null) {
				dto.setLinkToPrimary(entryEntity.getPrimaryLedgerEntryID());
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
	
	/**
	 * @param ledgerID
	 * @return
	 */
	public List<LedgerEntryDTO> findByLedgerId(Long ledgerID){
		List<LedgerEntryEntity> ledgerEntryEntities = iLedgerEntryRepository.findByledgerHeaderID(ledgerID);
		List<LedgerEntryDTO> ledgerEntryDTOs = getMapper().convertToDTOList(ledgerEntryEntities);
		return ledgerEntryDTOs;
	}
	
	/**
	 * Gets the claims which has driven the accums consumption
	 * @param memberId
	 * @param subscriberId
	 * @param accumType
	 * @return
	 */
	public List<AccumsConsumptionDTO> getAccumConsumption(String memberId, String subscriberId, String accumType){
		List<LedgerEntryEntity> ledgerEntryEntities = null;
		List<AccumsConsumptionDTO>  accumsConsumptionList = null;
		//If subscriber id is not null then exclude it from the where clause to get the claim details associated with the member id and the accum type
		if(subscriberId != null)
			ledgerEntryEntities = iLedgerEntryRepository.findLedgerEntryBySubscriberIdAndMemberIdAndAccumType(memberId, accumType, subscriberId);
		else
			ledgerEntryEntities = iLedgerEntryRepository.findLedgerEntryByMemberIdAndAccumType(memberId, accumType);	
		
		//Custom mapper to convert the LedgerEntry entity list into the AccumsConsumption dto
		accumsConsumptionList = ((LedgerEntryMapper)getMapper()).toAccumsConsumptionDTOList(ledgerEntryEntities);		
		return accumsConsumptionList;		
	}
}
