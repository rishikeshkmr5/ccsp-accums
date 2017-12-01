/**
 * 
 */
package com.ccsp.accums.utilization.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;
import com.ccsp.accums.ledger.entry.mapper.LedgerEntryMapper;
import com.ccsp.accums.ledger.entry.repository.ILedgerEntryRepository;
import com.ccsp.accums.ledger.header.dto.AccumUtilization;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.ledger.summary.repository.ILedgerSummaryRepository;

/**
 * @author rtalapaneni
 *
 */
@Component
public class AccumsUpdateService implements IAccumsUpdateService {
	@Resource
	private ILedgerHeaderRepository headerRepository;
	
	@Resource
	private ILedgerEntryRepository entryRepository;
	
	@Resource
	private ILedgerSummaryRepository summaryRepository;
	
	/**
	 * @param accumUtilization
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateAccums(AccumUtilization accumUtilization) {
		LedgerHeaderEntity headerEntity = LedgerHeaderMapper.INSTANCE.convertToEntity(accumUtilization);
		headerEntity = headerRepository.save(headerEntity);
		
		//Holds the ledger summary entity details with key as combination of unique constraint fields.
		Map<String, LedgerSummaryEntity> ledgerSummaryMap = new HashMap<String, LedgerSummaryEntity>();
		
		//fetch the existing ledgerSummary entries for the given subscriber id
		List<LedgerSummaryEntity> summaryEntities = summaryRepository.findByMemberId(headerEntity.getMemberId());
		
		//iterate the ledgerSummary entries to populate the ledgerSummaryMap with unique constraints as the key and the summary object as the value
		if(CollectionUtils.isNotEmpty(summaryEntities)) {
			for(LedgerSummaryEntity ledgerSummaryEntity : summaryEntities) {
				ledgerSummaryMap.put(generateKey(ledgerSummaryEntity), ledgerSummaryEntity);
			}
		}
		
		List<LedgerEntryEntity> entryEntities = LedgerEntryMapper.INSTANCE.convertToEntityList(accumUtilization.getServiceLines());
		for(LedgerEntryEntity entryEntity : entryEntities) {
			entryEntity.setLedgerHeaderID(headerEntity.getId());
			entryEntity.setLedgerHeader(headerEntity);
			String key = generateKey(headerEntity, entryEntity.getAccumType());
			//Check and get if summary entity is already available with unique constraint key.
			LedgerSummaryEntity summaryEntity = ledgerSummaryMap.get(key);
			if (summaryEntity == null) {
				summaryEntity = LedgerSummaryMapper.INSTANCE.convertHeaderDTOtoEntity(accumUtilization);
				summaryEntity.setAccumType(entryEntity.getAccumType());
				summaryEntity.setAmount(entryEntity.getAmount());
				ledgerSummaryMap.put(key, summaryEntity);
			} else {
				summaryEntity.setAmount(summaryEntity.getAmount() + entryEntity.getAmount());
			}
		}
		entryEntities = entryRepository.save(entryEntities);
		
		summaryEntities = summaryRepository.save(ledgerSummaryMap.values());
		
	}
	
	/**
	 * Generates the key as {member_id}_{accum_type}_{network_code}_{network_tier}
	 * @param ledgerSummaryEntity
	 * @return
	 * Generate the key based on the unique fields in the ledgersummary
	 */
	private String generateKey(LedgerSummaryEntity ledgerSummaryEntity) {
		return ledgerSummaryEntity.getMemberId().trim()+"_"+ledgerSummaryEntity.getAccumType().trim()+"_"+ledgerSummaryEntity.getNetworkCode().trim()+"_"+ledgerSummaryEntity.getNetworkTier().trim();
	}
	
	/**
	 * Generates the key as {member_id}_{accum_type}_{network_code}_{network_tier}
	 * @param headerEntity
	 * @return
	 * Generate the key based on the unique fields in the ledgersummary
	 */
	private String generateKey(LedgerHeaderEntity headerEntity, String accumType) {
		return headerEntity.getMemberId().trim()+"_"+accumType.trim()+"_"+headerEntity.getNetworkCode().trim()+"_"+headerEntity.getNetworkTier().trim();
	}
}
