package com.ccsp.accums.ledger.entry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;


/**
 * @author nnarayanaperumaln
 *
 */
public interface LedgerEntryRepository extends JpaRepository<LedgerEntryEntity, Long> {
	/**
	 * @param ledgerHeaderID
	 * @return
	 */
	List<LedgerEntryEntity> findByledgerHeaderID(Long ledgerHeaderID);
	
	@Query("select c from LedgerEntryEntity c join c.ledgerHeader h where c.ledgerHeaderID  = h.id and h.memberId = :memberId and c.accumType = :accumType")
	List<LedgerEntryEntity> findLedgerEntryByMemberIdAndAccumType(@Param("memberId") String memberId, @Param("accumType") String accumType);
	
	@Query("select c from LedgerEntryEntity c join c.ledgerHeader h where c.ledgerHeaderID  = h.id and h.memberId = :memberId and c.accumType = :accumType and h.subscriberId = :subscriberId")
	List<LedgerEntryEntity> findLedgerEntryBySubscriberIdAndMemberIdAndAccumType(@Param("memberId") String memberId, @Param("accumType") String accumType, @Param("subscriberId") String subscriberId);
}
