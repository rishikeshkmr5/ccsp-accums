package com.ccsp.accums.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entity.AccumulationSummary;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface AccumulationSummaryRepository extends JpaRepository<AccumulationSummary, Long>{

}
