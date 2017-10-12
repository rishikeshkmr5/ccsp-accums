package com.ccsp.accums.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.mapper.ClaimDetailMapper;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

@Component
public class ClaimDetailServiceImpl extends CommonServiceImpl {

	@Resource
	private AccumulationHeaderRepository ledgerHeaderRepository;
	
	@Override
	public <T extends Serializable> JpaRepository<T, Long> getJPARepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  IBaseMapper<AccumulationHeader, ClaimDetailsForAccumTypeDTO> getMapper() {
		// TODO Auto-generated method stub
		return ClaimDetailMapper.INSTANCE;
	}
	
	public List<ClaimDetailsForAccumTypeDTO> getClaimDetail(String accumType) throws NotFoundException {
		ClaimDetailsForAccumTypeDTO claimDetailForAccumTypeDTO = new ClaimDetailsForAccumTypeDTO();
		List<ClaimDetailsForAccumTypeDTO> claimDetailsForAccumTypeDTO = new ArrayList<ClaimDetailsForAccumTypeDTO>();
		List<AccumulationHeader> accumHeaderList =  ledgerHeaderRepository.findByaccumulatorType(accumType);
		if(accumHeaderList.isEmpty()) {
			throw new NotFoundException(
					"There are no Claims available for accumType : " + accumType);
		}
		for(AccumulationHeader accumulationHeader:accumHeaderList) {
			
			claimDetailForAccumTypeDTO =getMapper().convertToDTO(accumulationHeader); 
			claimDetailForAccumTypeDTO.setRunningBalance(0.0);
			
			claimDetailsForAccumTypeDTO.add(claimDetailForAccumTypeDTO);
		}
		
		
		return  claimDetailsForAccumTypeDTO;
		
	}

}
