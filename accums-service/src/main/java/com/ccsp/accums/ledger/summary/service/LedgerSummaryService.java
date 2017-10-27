package com.ccsp.accums.ledger.summary.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.repository.LedgerEntryRepository;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.ILedgerSummaryRepository;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author Vaibhav
 *
 */
@Component
public class LedgerSummaryService extends CommonServiceImpl<LedgerSummaryDTO, LedgerSummaryEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ILedgerSummaryRepository ledgerSummaryRepository;

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;
	
	@Resource
	private LedgerEntryRepository ledgerEntryRepository;
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<LedgerSummaryDTO, LedgerSummaryEntity> getMapper() {
		return LedgerSummaryMapper.INSTANCE;
	}

	/**
	 * Creates the provided Ledger Entry. It expects ledger header id along with
	 * other attributes.
	 * 
	 * @param dto
	 * @return T
	 */
	@Override
	public LedgerSummaryDTO create(LedgerSummaryDTO dto) {

		LedgerSummaryEntity ledgerSummaryEntity = getMapper().convertToEntity(dto);

		LedgerHeaderEntity ledger = ledgerHeaderRepository.findOne(dto.getLedgerHeaderID());
		ledgerSummaryEntity.setLedgerHeader(ledger);

		ledgerSummaryEntity = ledgerSummaryRepository.save(ledgerSummaryEntity);

		return getMapper().convertToDTO(ledgerSummaryEntity);
	}

	/**
	 * @param ledgerHeaderDTO
	 */
	public void create(LedgerHeaderDTO ledgerHeaderDTO) {  
		Map<String, LedgerSummaryEntity> ledgerSummaryMap = new HashMap<String, LedgerSummaryEntity>();
		List<LedgerSummaryEntity> ledgerSummaryEntities = ledgerSummaryRepository.findBySubscriberId(ledgerHeaderDTO.getSubscriberId());
		if(CollectionUtils.isNotEmpty(ledgerSummaryEntities)) {
			for(LedgerSummaryEntity ledgerSummaryEntity : ledgerSummaryEntities) {
				ledgerSummaryMap.put(generateKey(ledgerSummaryEntity), ledgerSummaryEntity);
			}
		}
		for (LedgerEntryDTO ledgerEntryDTO : ledgerHeaderDTO.getServiceLines()) {
			LedgerSummaryMapper mapper = (LedgerSummaryMapper) getMapper();
			LedgerSummaryEntity entity = mapper.convertHeaderDTOtoEntity(ledgerHeaderDTO);
			entity.setAccumType(ledgerEntryDTO.getAccumType());
			LedgerSummaryEntity result = null;
			result = ledgerSummaryMap.get(generateKey(entity));
			if (result != null) {
				result.setAmount(result.getAmount() + ledgerEntryDTO.getAmount());
			} else {
				result = entity;
				result.setAmount(ledgerEntryDTO.getAmount());
			}
			ledgerSummaryEntities.add(result);
		}
		ledgerSummaryRepository.save(ledgerSummaryEntities);
	}

	/**
	 * Persists provided list of data. Populates the required entities like header
	 * entity and primary reportable entity.
	 * 
	 * @param ledgerEntries
	 * @return
	 */
	@Override
	public List<LedgerSummaryDTO> create(List<LedgerSummaryDTO> dtoList) {
		List<LedgerSummaryEntity> summaryEntities = new ArrayList<LedgerSummaryEntity>();

		boolean isFirst = true;
		LedgerHeaderEntity ledgerHeader = null;

		for (LedgerSummaryDTO summaryDTO : dtoList) {
			LedgerSummaryEntity summaryEntity = getMapper().convertToEntity(summaryDTO);
			if (isFirst) {
				ledgerHeader = ledgerHeaderRepository.findOne(summaryDTO.getLedgerHeaderID());
				isFirst = false;
			}
			summaryEntity.setLedgerHeader(ledgerHeader);
			summaryEntities.add(summaryEntity);
		}

		getJPARepository().save(summaryEntities);

		List<LedgerSummaryDTO> summaryDTOResults = new ArrayList<LedgerSummaryDTO>();

		for (LedgerSummaryEntity summaryEntity : summaryEntities) {
			LedgerSummaryDTO dto = getMapper().convertToDTO(summaryEntity);
			if (summaryEntity.getLedgerHeader() != null) {
				dto.setLedgerHeaderID(summaryEntity.getLedgerHeader().getId());
			}
			summaryDTOResults.add(dto);
		}
		return summaryDTOResults;
	}

	@Override
	public JpaRepository<LedgerSummaryEntity, Long> getJPARepository() {
		// TODO Auto-generated method stub
		return ledgerSummaryRepository;
	}

	/**
	 * @param subscriberId
	 */
	public void updateLedgerSummary(String subscriberId) {
		Map<String, LedgerSummaryEntity> ledgerSummaryMap = new HashMap<String, LedgerSummaryEntity>();
		List<LedgerSummaryEntity> ledgerSummaryEntities = ledgerSummaryRepository.findBySubscriberId(subscriberId);
		if(CollectionUtils.isNotEmpty(ledgerSummaryEntities)) {
			for(LedgerSummaryEntity ledgerSummaryEntity : ledgerSummaryEntities) {
				ledgerSummaryEntity.setAmount(0d);
				ledgerSummaryMap.put(generateKey(ledgerSummaryEntity), ledgerSummaryEntity);
			}
		}
		List<LedgerHeaderEntity> ledgerHeaderEntityList = ledgerHeaderRepository.findBySubscriberId(subscriberId);
		for(LedgerHeaderEntity ledgerHeaderEntity : ledgerHeaderEntityList) {
			LedgerHeaderMapper headerMapper = LedgerHeaderMapper.INSTANCE;
			LedgerHeaderDTO ledgerHeaderDTO = headerMapper.convertToDTO(ledgerHeaderEntity);
			List<LedgerEntryEntity> ledgerEntryList = ledgerEntryRepository.findByledgerHeaderID(ledgerHeaderEntity.getId());
			for(LedgerEntryEntity ledgerEntryEntity:ledgerEntryList) {
				LedgerSummaryMapper mapper = (LedgerSummaryMapper) getMapper();
				LedgerSummaryEntity entity = mapper.convertHeaderDTOtoEntity(ledgerHeaderDTO);
				entity.setAccumType(ledgerEntryEntity.getAccumType());
				LedgerSummaryEntity result = null;
				result = ledgerSummaryMap.get(generateKey(entity));
				if (result != null) {
					result.setAmount(result.getAmount() + ledgerEntryEntity.getAmount());
				} else {
					result = entity;
					result.setAmount(ledgerEntryEntity.getAmount());
				}
				ledgerSummaryEntities.add(result);
			}
		}
		ledgerSummaryRepository.save(ledgerSummaryEntities);
	}
	
	/**
	 * @param ledgerSummaryEntity
	 * @return
	 */
	private String generateKey(LedgerSummaryEntity ledgerSummaryEntity) {
		return ledgerSummaryEntity.getMemberId()+"_"+ledgerSummaryEntity.getAccumType()+"_"+ledgerSummaryEntity.getNetworkCode()+"_"+ledgerSummaryEntity.getNetworkTier();
	}
}

