package com.ccsp.accums.category.type.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.accums.category.type.entity.CategoryTypeEntity;

/**
 * @author Vaibhav
 * Repository class to connect to the database
 *
 */
public interface ICategoryTypeRepository extends JpaRepository<CategoryTypeEntity, Long>{}
