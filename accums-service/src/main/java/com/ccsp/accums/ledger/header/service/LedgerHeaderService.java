package com.ccsp.accums.ledger.header.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerHeaderService extends CommonServiceImpl<LedgerHeaderDTO, LedgerHeaderEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	@Autowired
	private LedgerEntryService ledgerEntryService;

	@Autowired
	private LedgerSummaryService ledgerSummaryService;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@Override
	public JpaRepository<LedgerHeaderEntity, Long> getJPARepository() {
		return ledgerHeaderRepository;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerHeaderDTO, LedgerHeaderEntity> getMapper() {
		return LedgerHeaderMapper.INSTANCE;
	}

	/**
	 * Maps the data from provided DTO to database entity model.
	 * 
	 * Invokes the repository to persist in database by passing the entity.
	 * 
	 * Checks for the availability of service lines and invokes Ledger 
	 * entry service by passing them.
	 * 
	 * @param ledgerHeaderDTO
	 * @return {@link LedgerHeaderDTO}
	 */
	@Override
	public LedgerHeaderDTO create(LedgerHeaderDTO ledgerHeaderDTO) {
		if (ledgerHeaderDTO != null) {
			//Convert DTO to entity.
			LedgerHeaderEntity ledgerHeaderEntity = getMapper().convertToEntity(ledgerHeaderDTO);
			
			//Persist records in database.
			getJPARepository().saveAndFlush(ledgerHeaderEntity);
			
			//Set the header id which was auto generated during persistence.
			ledgerHeaderDTO.setId(ledgerHeaderEntity.getId());
			
			//Check if the serviceLines are not empty, if so provide the generated header id to each serviceLine.
			if (CollectionUtils.isNotEmpty(ledgerHeaderDTO.getServiceLines())) {
				for (LedgerEntryDTO ledgerEntryDTO : ledgerHeaderDTO.getServiceLines()) {
					//ledger header id will be used in service to map the parent-child relationship.
					ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
				}
				
				//pass the serviceLines to the existing service for persistence
				ledgerHeaderDTO.setServiceLines(ledgerEntryService.create(ledgerHeaderDTO.getServiceLines()));
				
				//Calculates and persists the accums summary based on header and service lines.
				ledgerSummaryService.create(ledgerHeaderDTO);
			}
		}
		return ledgerHeaderDTO;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#update(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public LedgerHeaderDTO update(LedgerHeaderDTO dto) {
		//convert DTO to entity for persistence
		LedgerHeaderEntity ledgerHeaderEntity = getMapper().convertToEntity(dto);
		//Find existing LedgerHeaderEntity as it is an update operation
		LedgerHeaderEntity existingEntity = getJPARepository().findOne(ledgerHeaderEntity.getId());
		if (existingEntity != null)
			ledgerHeaderEntity.setId(existingEntity.getId());
		ledgerHeaderEntity = getJPARepository().save(ledgerHeaderEntity);
		List<LedgerEntryDTO> ledgerEntriesDTO = dto.getServiceLines();
		//Update serviceLines associated with the Ledger header
		for (LedgerEntryDTO ledgerEntryDTO : ledgerEntriesDTO) {
			ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
			ledgerEntryService.update(ledgerEntryDTO);
		}
		return dto;

	}
	
	/**
	 * Fetches the spending summary for the member id and subscriber id
	 * @param memberId
	 * @param subscriberId
	 * @return
	 */
	public List<SpendingSummaryDTO> getSpendingSummary(String memberId, String subscriberId){
		List<SpendingSummaryDTO> spendingSummaryDTOList = new ArrayList<>();
		LedgerHeaderMapper mapper = (LedgerHeaderMapper) getMapper();
		List<LedgerHeaderEntity> ledgerHeaderEntityList = new ArrayList<>();		
		if(StringUtils.isNotEmpty(memberId) && StringUtils.isNotEmpty(subscriberId)) {
			//retrieve the summary based on memberId and subscriberId
			ledgerHeaderEntityList = ledgerHeaderRepository.findByMemberIdAndSubscriberId(memberId, subscriberId);
		}else if(StringUtils.isNotEmpty(memberId)) {
			//retrieve the summary based on the memberId
			ledgerHeaderEntityList = ledgerHeaderRepository.findByMemberId(memberId);
		}else if(StringUtils.isNotEmpty(subscriberId)) {
			//retrieve the summary based on the summaryId
			ledgerHeaderEntityList = ledgerHeaderRepository.findBySubscriberId(subscriberId);
		}
		//if the ledgerHeader entity list is not empty convert them to DTOs
		if(CollectionUtils.isNotEmpty(ledgerHeaderEntityList)) {
			spendingSummaryDTOList = mapper.convertEntitiesToSpendingSummaryDTOs(ledgerHeaderEntityList);
		}
		return spendingSummaryDTOList;
	}
}
