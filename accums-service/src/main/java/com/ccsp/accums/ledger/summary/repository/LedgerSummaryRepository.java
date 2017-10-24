package com.ccsp.accums.ledger.summary.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;


@Component
public class LedgerSummaryRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public LedgerSummaryEntity findLedgerSummary(LedgerSummaryEntity ledgerSummary) {
		Query query = entityManager.createNamedQuery("findLedgerSummary",LedgerSummaryEntity.class);
		query.setParameter("memberID", ledgerSummary.getMemberID());		
		query.setParameter("accumType", ledgerSummary.getAccumType());	
		query.setParameter("network", ledgerSummary.getNetwork());	
		query.setParameter("networkTier", ledgerSummary.getNetworkTier());	
		List<LedgerSummaryEntity> resultList = query.getResultList();
		if(resultList.size()>0)
			return resultList.get(0);
		else
			return null;
	}

	@Transactional
	public LedgerSummaryEntity updateLedgerSummary(LedgerSummaryEntity ledgerSummary) {
		return entityManager.merge(ledgerSummary);		
	}
	
	@Transactional
	public void persistLedgerSummary(LedgerSummaryEntity ledgerSummary) {
		entityManager.persist(ledgerSummary);
	}
}
