package com.ccsp.accums.category.type.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.category.type.entity.CategoryTypeEntity;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface ICategoryTypeRepository extends JpaRepository<CategoryTypeEntity, Long>{
	
	/**
	 * To get all list of values based on category
	 * @param category
	 * @return
	 */
	List<CategoryTypeEntity> findBycategory(String category);
}

