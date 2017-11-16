package com.ccsp.accums.ledger.header.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface ILedgerHeaderRepository extends JpaRepository<LedgerHeaderEntity, Long>{
		
	/**
	 * @param subscriberId
	 * @return
	 */
	List<LedgerHeaderEntity> findBySubscriberId(String subscriberId);
	
	/**
	 * @param memberId
	 * @return
	 */
	List<LedgerHeaderEntity> findByMemberId(String memberId);
	
	/**
	 * @param memberId
	 * @param subscriberId
	 * @return
	 */
	List<LedgerHeaderEntity> findByMemberIdAndSubscriberId(String memberId, String subscriberId);

	/**
	 * @param claimId
	 * @return
	 */
	LedgerHeaderEntity findBydcn(String claimID);
	
	/**
	 * returns summary records to be inserted with cumulation of amount field from ledger entry based on member id from ledger header
	 * @param memberId
	 * @return
	 */
	@Query("select new com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity(e.accumType,h.memberId,h.networkCode,h.networkTier,h.planId,h.subscriberId,sum(e.amount) as amount,h.unitOfMeasure) from LedgerEntryEntity e INNER JOIN  e.ledgerHeader h where h.memberId= :memberId group by h.memberId,h.networkCode,h.networkTier, h.subscriberId, h.unitOfMeasure,e.accumType,h.planId")
	List<LedgerSummaryEntity> fetchAccumulation(@Param("memberId")  String memberId);
}
