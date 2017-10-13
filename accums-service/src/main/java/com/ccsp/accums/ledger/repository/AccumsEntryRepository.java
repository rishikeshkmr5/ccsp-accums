package com.ccsp.accums.ledger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.ledger.entity.AccumsEntry;


public interface AccumsEntryRepository extends JpaRepository<AccumsEntry, Long> {
	
}
