package com.ccsp.accums.ledger.header.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerHeaderDTO, LedgerHeaderEntity> getMapper() {
		return LedgerHeaderMapper.INSTANCE;
	}	
	
	@Override
	public LedgerHeaderDTO create(LedgerHeaderDTO ledgerHeaderDTO){
		if(ledgerHeaderDTO != null) {
			LedgerHeaderEntity ledgerHeaderEntity = getMapper().convertToEntity(ledgerHeaderDTO);
			getJPARepository().saveAndFlush(ledgerHeaderEntity);
			ledgerHeaderDTO.setId(ledgerHeaderEntity.getId());
			List<LedgerEntryDTO> ledgerEntryDTOs = ledgerHeaderDTO.getServiceLines();
			for(LedgerEntryDTO ledgerEntryDTO : ledgerEntryDTOs) {
				ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
				ledgerEntryService.create(ledgerEntryDTO);
				LedgerSummaryEntity ledgerSummaryEntity = new LedgerSummaryEntity();
				ledgerSummaryEntity.setMemberID(ledgerHeaderDTO.getMemberIdentifier());
				ledgerSummaryEntity.setAccumType(ledgerEntryDTO.getAccumType());
				ledgerSummaryEntity.setNetwork(ledgerEntryDTO.getNetwork());
				ledgerSummaryEntity.setNetworkTier(ledgerHeaderDTO.getNetworkTier());
				ledgerSummaryEntity.setAmount(ledgerHeaderDTO.getAllowedAmount());
				ledgerSummaryEntity.setLedgerHeader(ledgerHeaderEntity);
				ledgerSummaryEntity.setLedgerHeaderID(ledgerHeaderEntity.getId());
				ledgerSummaryEntity.setSubscriberID(ledgerHeaderDTO.getSubscriberId());
				ledgerSummaryEntity.setUnitOfMeasure(ledgerEntryDTO.getUnitOfMeasure());
				ledgerSummaryService.createSummary(ledgerSummaryEntity);
			}
		}	
		return ledgerHeaderDTO;		
	}
	
	@Override
	public LedgerHeaderDTO update(LedgerHeaderDTO dto) {
		LedgerHeaderEntity ledgerHeaderEntity = getMapper().convertToEntity(dto);
		LedgerHeaderEntity existingEntity = getJPARepository().findOne(ledgerHeaderEntity.getId());
		LedgerHeaderDTO existingDTO = getMapper().convertToDTO(existingEntity);
		
				if(existingEntity != null)
				ledgerHeaderEntity.setId(existingEntity.getId());
		ledgerHeaderEntity	= getJPARepository().save(ledgerHeaderEntity);
		List<LedgerEntryDTO> ledgerEntriesDTO=dto.getServiceLines();
		for(LedgerEntryDTO ledgerEntryDTO : ledgerEntriesDTO) {
				ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
					ledgerEntryService.update(ledgerEntryDTO);
		}
		return dto;
		
	}
}
