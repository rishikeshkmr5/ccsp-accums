package com.ccsp.accums.ledger.summary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface LedgerSummaryRepository extends JpaRepository<LedgerSummaryEntity, Long>{

}
