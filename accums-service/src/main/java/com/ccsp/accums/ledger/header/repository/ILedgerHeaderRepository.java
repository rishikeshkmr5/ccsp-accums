package com.ccsp.accums.ledger.header.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface ILedgerHeaderRepository extends JpaRepository<LedgerHeaderEntity, Long>{
	
	List<LedgerHeaderEntity> findByAccumType(String accumType);

}
