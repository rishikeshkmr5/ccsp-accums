package com.ccsp.accums.ledger.benefit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface BenefitSpendingRepository extends JpaRepository<LedgerSummaryEntity, Long>{

	/**
	 * To get benefit spending summary based on member id
	 * @param memberID
	 * @return
	 */
	List<LedgerSummaryEntity> findBymemberId(String memberId);
	
}
