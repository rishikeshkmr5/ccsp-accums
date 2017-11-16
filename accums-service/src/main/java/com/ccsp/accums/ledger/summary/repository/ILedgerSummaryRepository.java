package com.ccsp.accums.ledger.summary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
	 * To get all accumulation summary based on subscriber id
	 * @param subscriberId
	 * @return
	 */
	List<LedgerSummaryEntity> findBySubscriberId(String subscriberId);
	
	/**
	 * To get all accumulation summary based on subscriber id
	 * @param memberId
	 * @return
	 */
	List<LedgerSummaryEntity> findByMemberId(String memberId);
	
	/**
	 * To get all accumulation summary based on member id and subscriber id
	 * @param memberId
	 * @return
	 */
	List<LedgerSummaryEntity> findByMemberIdAndSubscriberId(String memberId, String subscriberId);
	
	/**
	 * To delte all summary records based on member id, accumType, network code and network tier
	 * @param memberId
	 * @param accumType
	 * @param networkCode
	 * @param networkTier
	 */
	@Transactional
	@Modifying
	@Query("delete from LedgerSummaryEntity c where c.memberId = :memberId and c.accumType = :accumType and c.networkCode = :networkCode and c.networkTier = :networkTier")
	void deleteLedgerSummary(@Param("memberId") String memberId, @Param("accumType") String accumType, @Param("networkCode") String networkCode, @Param("networkTier") String networkTier);

}
