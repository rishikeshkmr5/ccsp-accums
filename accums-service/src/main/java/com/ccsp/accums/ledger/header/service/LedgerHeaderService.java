package com.ccsp.accums.ledger.header.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.repository.ILedgerSummaryRepository;
import com.ccsp.accums.ledger.summary.service.LedgerSummaryService;
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

	@Override
	public LedgerHeaderDTO create(LedgerHeaderDTO ledgerHeaderDTO) {
		if (ledgerHeaderDTO != null) {
			//Convert DTO to entity for persistence
			LedgerHeaderEntity ledgerHeaderEntity = getMapper().convertToEntity(ledgerHeaderDTO);
			getJPARepository().saveAndFlush(ledgerHeaderEntity);
			//Set the header id which gets auto generated to the DTO
			ledgerHeaderDTO.setId(ledgerHeaderEntity.getId());
			
			//Check if the serviceLines are not empty, if so provide the generated header id to each serviceLine
			if (CollectionUtils.isNotEmpty(ledgerHeaderDTO.getServiceLines())) {
				for (LedgerEntryDTO ledgerEntryDTO : ledgerHeaderDTO.getServiceLines()) {
					ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
				}
				//pass the serviceLines to the existing service for persistence
				ledgerHeaderDTO.setServiceLines(ledgerEntryService.create(ledgerHeaderDTO.getServiceLines()));
				//Generate summary from the header and serviceLines
				ledgerSummaryService.create(ledgerHeaderDTO);
			}
		}
		return ledgerHeaderDTO;
	}

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
}
