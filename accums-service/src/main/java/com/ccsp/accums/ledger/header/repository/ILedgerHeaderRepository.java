package com.ccsp.accums.ledger.header.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;

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
}
