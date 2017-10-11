package com.ccsp.accums.ledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entity.AccumulationSummary;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface BenefitBalanceRepository extends JpaRepository<AccumulationSummary, Long>{

	/**
	 * To get all accumulation summary based on subscriber id
	 * @param subscriberID
	 * @return
	 */
	List<AccumulationSummary> findBysubscriberID(String subscriberID);
	
	/**
	 * To get all accumulation summary based on member id
	 * @param memberID
	 * @return
	 */
	List<AccumulationSummary> findBymemberID(String memberID);
	
}
