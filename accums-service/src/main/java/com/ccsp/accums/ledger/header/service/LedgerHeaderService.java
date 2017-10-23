package com.ccsp.accums.ledger.header.service;

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
			List<LedgerEntryDTO> ledgerEntryDTOs = ledgerHeaderDTO.getServiceLines();
			for(LedgerEntryDTO ledgerEntryDTO : ledgerEntryDTOs) {
				ledgerEntryDTO.setLedgerHeaderID(ledgerHeaderEntity.getId());
				ledgerEntryService.create(ledgerEntryDTO);
			}
		}		
		return ledgerHeaderDTO;		
	}
}
