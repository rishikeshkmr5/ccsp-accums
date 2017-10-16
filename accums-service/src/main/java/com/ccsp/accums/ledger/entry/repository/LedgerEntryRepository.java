package com.ccsp.accums.ledger.entry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entry.entity.LedgerEntryEntity;


public interface LedgerEntryRepository extends JpaRepository<LedgerEntryEntity, Long> {
	
}
