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
public abstract class CommonServiceImpl implements ICommonService {

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#create(com.ccsp.common.dto.ICommonDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		Serializable entity = getMapper().convertToEntity(dto);
		if(entity != null){
			entity = getJPARepository().saveAndFlush(entity);
		}
		ICommonDTO resultDTO =  getMapper().convertToDTO(entity);
		return (T) resultDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> create(List<T> dtoList) {
		List<Serializable> entities = getMapper().convertToEntityList((List<ICommonDTO>) dtoList);
		if(entities != null){
			entities = getJPARepository().save(entities);
		}
		List<T> resultDTOList =  (List<T>) getMapper().convertToDTOList(entities);
		return resultDTOList;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#update(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public <T extends ICommonDTO> T update(T dto) {
		//Auto-generated method stub - Do nothing
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#delete(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public <T extends ICommonDTO> void delete(T dto) {
		//Auto-generated method stub - Do nothing
		
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#read(java.math.BigDecimal)
	 */
	@Override
	public <T extends ICommonDTO> T read(BigDecimal id) {
		//Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#readAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<Serializable> entities = getJPARepository().findAll();
		
		/**check if there are any entities in backend **/
		if(entities == null || entities.size() == 0) {
			throw new NotFoundException("There are no Ledger Headers");
		}
		return (List<T>) getMapper().convertToDTOList(entities);
	}
	
	/**
	 * provides the JpaRepository to use with service.
	 * @return
	 */
	public abstract <T extends Serializable> JpaRepository<T, Long> getJPARepository();
	
	/**
	 * Provides the mapper factory to use with service.
	 * @return
	 */
	public abstract <Entity extends Serializable, DTO extends ICommonDTO> IBaseMapper<Entity, DTO> getMapper();
}
