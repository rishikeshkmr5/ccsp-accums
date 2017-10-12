package com.ccsp.accums.ledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entity.AccumulationSummary;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface BenefitSpendingRepository extends JpaRepository<AccumulationSummary, Long>{

	/**
	 * To get benefit spending summary based on member id
	 * @param memberID
	 * @return
	 */
	List<AccumulationSummary> findBymemberID(String memberID);
	
}
