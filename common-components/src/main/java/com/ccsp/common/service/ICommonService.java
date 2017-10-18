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
public interface ICommonService {

	/**
	 * @param dto
	 * @return
	 */
	<T extends ICommonDTO> T create(T dto);	
	
	/**
	 * @param dtoList
	 * @return
	 */
	<T extends ICommonDTO> List<T >create(List<T> dtoList);	
	
	/**
	 * @param dto
	 * @return
	 */
	<T extends ICommonDTO> T update(T dto);
	
	/**
	 * @param dto
	 */
	<T extends ICommonDTO> void delete(T dto);
	
	/**
	 * @param id
	 * @return
	 */
	<T extends ICommonDTO> T read(BigDecimal id);	
	
	/**
	 * @return
	 * @throws NotFoundException
	 */
	<T extends ICommonDTO> List<T> readAll() throws NotFoundException;
}