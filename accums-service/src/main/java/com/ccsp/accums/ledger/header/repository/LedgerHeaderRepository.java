package com.ccsp.accums.ledger.header.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

/**
 * @author Koyel
 *
 */
@Component
public abstract class LedgerHeaderRepository implements ILedgerHeaderRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository#findByAccumType(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<LedgerHeaderEntity> findByAccumType(String accumType){
		Query query = entityManager.createNamedQuery("findMappings",LedgerHeaderEntity.class);
		query.setParameter("accumType", accumType);		
		List<LedgerHeaderEntity> result = query.getResultList();
		return result;
	}	
}
