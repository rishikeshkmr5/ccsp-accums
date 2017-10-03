/**
 * 
 */
package com.ccsp.common.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.service.ICommonService;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
public class CommonServiceImpl implements ICommonService{

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.ICommonService#create(com.ccsp.common.dto.ICommonDTO)
	 */
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		//Auto-generated method stub - Do nothing
		return null;
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
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		//Auto-generated method stub - Do nothing
		return null;
	}

}
