package com.ccsp.accums.ledger.summary.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryClaimDTO;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.LedgerSummaryRepository;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerSummaryService extends CommonServiceImpl {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerSummaryRepository ledgerSummaryRepository;

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public JpaRepository<LedgerSummaryEntity, Long> getJPARepository() {
		return ledgerSummaryRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IBaseMapper<LedgerSummaryEntity, LedgerSummaryDTO> getMapper() {
		return LedgerSummaryMapper.INSTANCE;
	}

	public LedgerSummaryClaimDTO createClaimSummary(LedgerSummaryClaimDTO claimSummaryDTO) throws NotFoundException {

		LedgerSummaryClaimDTO claimSummaryDTOAfterInseration = new LedgerSummaryClaimDTO();
		List<LedgerSummaryDTO> accumulationSummaryDTOs = claimSummaryDTO.getAccumulationSummaryList();
		List<LedgerSummaryDTO> accumulationSummaryDTOsAfterInseration = new ArrayList<>();
		for (LedgerSummaryDTO accumulationSummaryDTO : accumulationSummaryDTOs) {
			LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(accumulationSummaryDTO.getLedgerHeaderID());
			if(ledger == null)
				throw new NotFoundException("Ledger ID : " + ledger + " not found in Ledger Header");
			LedgerSummaryEntity accumulationSummary = getMapper().convertToEntity(accumulationSummaryDTO);
			accumulationSummary.setLedgerHeader(ledger);

			if (accumulationSummary != null) {
				accumulationSummary = getJPARepository().saveAndFlush(accumulationSummary);
			}
			ICommonDTO resultDTO = getMapper().convertToDTO(accumulationSummary);
			accumulationSummaryDTOsAfterInseration.add((LedgerSummaryDTO) resultDTO);
		}
		claimSummaryDTOAfterInseration.setAccumulationSummaryList(accumulationSummaryDTOsAfterInseration);
		return claimSummaryDTOAfterInseration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#readAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<LedgerSummaryDTO> accumulationSummaryDTOs = new ArrayList<>();
		List<LedgerSummaryEntity> accumulationSummaries = ledgerSummaryRepository.findAll();

		if (accumulationSummaries == null || accumulationSummaries.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}

		for (LedgerSummaryEntity accumulationSummary : accumulationSummaries) {

			LedgerSummaryDTO accumulationSummaryDTO = getMapper().convertToDTO(accumulationSummary);
			accumulationSummaryDTO.setLedgerHeaderID(accumulationSummary.getLedgerHeader().getLedgerID());
			accumulationSummaryDTOs.add(accumulationSummaryDTO);

		}
		return (List<T>) accumulationSummaryDTOs;

	}
}
