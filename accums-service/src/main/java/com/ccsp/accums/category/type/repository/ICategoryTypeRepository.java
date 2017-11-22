package com.ccsp.accums.category.type.repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.category.type.entity.CategoryTypeEntity;

import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	@Query("SELECT DISTINCT a.code FROM CategoryTypeEntity a")
	  List<String> findNetworkCode();

	List<CategoryTypeEntity> findByCategory(@Param("period")String period);

	@Query("SELECT  a.id FROM CategoryTypeEntity a where a.category = :categoryType and a.code = :networkCode ")
	Long findBycategoryTypeAndNetworkCode(@Param("categoryType") String categoryType,@Param("networkCode")  String networkCode);
	
}

