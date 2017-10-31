package com.ccsp.accums.ledger.summary.repository;

import java.util.List;

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
	
	/**
	 * @param memberId
	 * @param accumType
	 * @param networkCode
	 * @param networkTier
	 * @return
	 */
	@Query("select c from LedgerSummaryEntity c where c.memberId = :memberId and c.accumType = :accumType and c.networkCode = :networkCode and c.networkTier = :networkTier")
	LedgerSummaryEntity findLedgerSummary(@Param("memberId") String memberId, @Param("accumType") String accumType, @Param("networkCode") String networkCode, @Param("networkTier") String networkTier);
	
	/**
	 * @param subscriberId
	 * @return
	 */
	List<LedgerSummaryEntity> findBySubscriberId(String subscriberId);
}
