/**
 * 
 */
package com.ccsp.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author nnarayanaperumaln
 *
 */
public interface ICommonService {

	<T extends ICommonDTO> T create(T dto);
	<T extends ICommonDTO> T update(T dto);
	<T extends ICommonDTO> void delete(T dto);
	<T extends ICommonDTO> T read(BigDecimal id);	
	<T extends ICommonDTO> List<T> readAll();
}