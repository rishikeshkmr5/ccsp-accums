package com.ccsp.accums.ledger.header.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

public abstract class LedgerHeaderRepository implements ILedgerHeaderRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<LedgerHeaderEntity> findByAccumType(String accumType){
		Query query = entityManager.createNamedQuery("findMappings",LedgerHeaderEntity.class);
		query.setParameter("accumType", accumType);		
		List<LedgerHeaderEntity> result = query.getResultList();
		return result;
		
		
	}	
	
}
