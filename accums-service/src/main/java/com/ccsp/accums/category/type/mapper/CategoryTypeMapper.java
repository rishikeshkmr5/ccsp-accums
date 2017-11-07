package com.ccsp.accums.category.type.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.category.type.dto.CategoryTypeDTO;
import com.ccsp.accums.category.type.entity.CategoryTypeEntity;
import com.ccsp.common.mapper.IBaseMapper;

/**
 * @author vamehta
 *
 */
@Mapper
public abstract class CategoryTypeMapper implements IBaseMapper<CategoryTypeDTO, CategoryTypeEntity>{

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final CategoryTypeMapper INSTANCE = Mappers.getMapper(CategoryTypeMapper.class);
	
}
