package com.ccsp.accums.ledger.summary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface ILedgerSummaryRepository extends JpaRepository<LedgerSummaryEntity, Long>{
	
	@Query("select c from LedgerSummaryEntity c where c.memberID = :memberID and c.accumType = :accumType and c.network = :network and c.networkTier = :networkTier")
	LedgerSummaryEntity findLedgerSummary(@Param("memberID") String memberID, @Param("accumType") String accumType, @Param("network") String network, @Param("networkTier") String networkTier);
}
