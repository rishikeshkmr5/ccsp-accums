package com.ccsp.accums.ledger.benefit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface BenefitBalanceRepository extends JpaRepository<LedgerSummaryEntity, Long>{

	/**
	 * To get all accumulation summary based on subscriber id
	 * @param subscriberID
	 * @return
	 */
	List<LedgerSummaryEntity> findBysubscriberID(String subscriberID);
	
	/**
	 * To get all accumulation summary based on member id
	 * @param memberID
	 * @return
	 */
	List<LedgerSummaryEntity> findBymemberID(String memberID);
	
}
