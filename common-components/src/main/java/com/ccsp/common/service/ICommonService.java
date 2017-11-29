/**
 * 
 */
package com.ccsp.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.ccsp.common.dto.ICommonDTO;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
public interface ICommonService <T extends ICommonDTO>{

	/**
	 * @param dto
	 * @return
	 */
	T create(T dto) throws Exception;	
	
	/**
	 * @param dtoList
	 * @return
	 */
	List<T> create(List<T> dtoList) throws Exception;	
	
	/**
	 * @param dto
	 * @return
	 */
	T update(T dto);
	
	/**
	 * @param dto
	 */
	void delete(T dto);
	
	/**
	 * @param id
	 * @return
	 */
	T read(BigDecimal id);	
	
	/**
	 * @return
	 * @throws NotFoundException
	 */
	List<T> readAll() throws NotFoundException;
}