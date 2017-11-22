package com.ccsp.accums.category.type.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.category.type.dto.CategoryTypeDTO;
import com.ccsp.accums.category.type.entity.CategoryTypeEntity;
import com.ccsp.accums.category.type.mapper.CategoryTypeMapper;
import com.ccsp.accums.category.type.repository.BenefitPeriod;
import com.ccsp.accums.category.type.repository.ICategoryTypeRepository;
import com.ccsp.accums.utilization.dto.PlanPeriod;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

/**
 * @author vamehta
 *
 */
@Component
public class CategoryTypeService extends CommonServiceImpl<CategoryTypeDTO, CategoryTypeEntity> {
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private ICategoryTypeRepository categoryTypeRepository;

	/**
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getJPARepository()
	 */
	@Override
	public JpaRepository<CategoryTypeEntity, Long> getJPARepository() {
		return categoryTypeRepository;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#getMapper()
	 */
	@Override
	public IBaseMapper<CategoryTypeDTO, CategoryTypeEntity> getMapper() {
		return CategoryTypeMapper.INSTANCE;
	}
	/**
	 * fetch all the list of values based on category type
	 * @param category
	 */

	public List<CategoryTypeDTO> getListOfValues(String category) {		
		List<CategoryTypeEntity> categoryTypeEntityList = categoryTypeRepository.findBycategory(category);
		List<CategoryTypeDTO> categoryTypeDTOs=  getMapper().convertToDTOList(categoryTypeEntityList);
		return categoryTypeDTOs;
	}
	
	public List<PlanPeriod> getListOfPlanPeriod(String period) {		
		List<PlanPeriod> planPeriodList = new ArrayList<>();
		List<CategoryTypeEntity> categoryTypeEntityIdList = categoryTypeRepository.findByCategory(period);
		List<CategoryTypeDTO> categoryTypeDTOList = getMapper().convertToDTOList(categoryTypeEntityIdList);
		PlanPeriod planPeriod=new PlanPeriod();
		for (CategoryTypeDTO categoryTypeDTO:categoryTypeDTOList) {
			planPeriod.setCode(categoryTypeDTO.getCode());
			planPeriod.setId(categoryTypeDTO.getId());
			if(!planPeriodList.contains(planPeriod))
			planPeriodList.add(planPeriod);
		}
		
		return planPeriodList;
	}
	
	public List<BenefitPeriod> getListOfBenefitPeriod(String period) {		
		List<BenefitPeriod> benefitPeriodList = new ArrayList<>();
		List<CategoryTypeEntity> categoryTypeEntityIdList = categoryTypeRepository.findByCategory(period);
		List<CategoryTypeDTO> categoryTypeDTOList = getMapper().convertToDTOList(categoryTypeEntityIdList);
		BenefitPeriod benefitPeriod=new BenefitPeriod();
		for (CategoryTypeDTO categoryTypeDTO:categoryTypeDTOList) {
			benefitPeriod.setCode(categoryTypeDTO.getCode());
			benefitPeriod.setId(categoryTypeDTO.getId());
			if(!benefitPeriodList.contains(benefitPeriod))
			benefitPeriodList.add(benefitPeriod);
		}
		
		return benefitPeriodList;
	}
	
	public Long getListOfValues(String categoryType, String networkCode) {
	Long categoryTypeEntityIdList = categoryTypeRepository.findBycategoryTypeAndNetworkCode(categoryType,networkCode);
	
	return categoryTypeEntityIdList;
	}
	
	
	

}
