package com.ccsp.accums.ledger.entry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
}
