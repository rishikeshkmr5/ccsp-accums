/**
 * 
 */
package com.ccsp.common.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.ICommonService;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
public abstract class CommonServiceImpl <T extends ICommonDTO, S extends Serializable> implements ICommonService<T> {

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#create(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public T create(T dto) throws Exception {
		S entity = getMapper().convertToEntity(dto);
		if(entity != null){
			entity = getJPARepository().saveAndFlush(entity);
		}
		return getMapper().convertToDTO(entity);
	}
	
	@Override
	public List<T> create(List<T> dtoList) throws Exception {
		List<S> entities = getMapper().convertToEntityList(dtoList);
		if(entities != null){
			entities = getJPARepository().save(entities);
		}
		return getMapper().convertToDTOList(entities);
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#update(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public T update(T dto) {
		//Auto-generated method stub - Do nothing
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#delete(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public void delete(T dto) {
		//Auto-generated method stub - Do nothing
		
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#read(java.math.BigDecimal)
	 */
	@Override
	public T read(BigDecimal id) {
		//Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#readAll()
	 */
	
	@Override
	public List<T> readAll() throws NotFoundException {
		List<S> entities = getJPARepository().findAll();
		
		/**check if there are any entities in backend **/
		if(entities == null || entities.size() == 0) {
			throw new NotFoundException("There are no Ledger Headers");
		}
		return getMapper().convertToDTOList(entities);
	}
	
	/**
	 * provides the JpaRepository to use with service.
	 * @return
	 */
	public abstract JpaRepository<S, Long> getJPARepository();
	
	/**
	 * Provides the mapper factory to use with service.
	 * @return
	 */
	public abstract IBaseMapper<T, S> getMapper();
}
