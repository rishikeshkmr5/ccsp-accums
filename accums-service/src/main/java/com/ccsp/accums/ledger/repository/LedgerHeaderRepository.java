package com.ccsp.accums.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entity.LedgerHeader;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface LedgerHeaderRepository extends JpaRepository<LedgerHeader, Long>{

}
