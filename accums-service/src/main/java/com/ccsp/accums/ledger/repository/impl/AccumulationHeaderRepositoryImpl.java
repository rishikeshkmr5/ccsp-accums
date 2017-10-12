package com.ccsp.accums.ledger.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;

public abstract class AccumulationHeaderRepositoryImpl implements AccumulationHeaderRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AccumulationHeader> findByaccumulatorType(String accumulatorType){
		Query query = entityManager.createNamedQuery("findMappings",AccumulationHeader.class);
		query.setParameter("accumulatorType", accumulatorType);		
		List<AccumulationHeader> result = query.getResultList();
		return result;
		
		
	}	
	
}
