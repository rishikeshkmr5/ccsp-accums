package com.ccsp.accums.ledger.benefit.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.benefit.dto.ClaimDetailsForAccumTypeDTO;
import com.ccsp.accums.ledger.benefit.mapper.ClaimDetailMapper;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.common.mapper.IBaseMapper;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

@Component
public class ClaimDetailServiceImpl extends CommonServiceImpl {

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;
	
	@Override
	public <T extends Serializable> JpaRepository<T, Long> getJPARepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  IBaseMapper<LedgerHeaderEntity, ClaimDetailsForAccumTypeDTO> getMapper() {
		// TODO Auto-generated method stub
		return ClaimDetailMapper.INSTANCE;
	}
	
	public List<ClaimDetailsForAccumTypeDTO> getClaimDetail(String accumType) throws NotFoundException {
		ClaimDetailsForAccumTypeDTO claimDetailForAccumTypeDTO = new ClaimDetailsForAccumTypeDTO();
		List<ClaimDetailsForAccumTypeDTO> claimDetailsForAccumTypeDTO = new ArrayList<ClaimDetailsForAccumTypeDTO>();
		List<LedgerHeaderEntity> accumHeaderList =  ledgerHeaderRepository.findByAccumType(accumType);
		if(accumHeaderList.isEmpty()) {
			throw new NotFoundException(
					"There are no Claims available for accumType : " + accumType);
		}
		for(LedgerHeaderEntity ledgerHeaderEntity:accumHeaderList) {
			
			claimDetailForAccumTypeDTO =getMapper().convertToDTO(ledgerHeaderEntity); 
			claimDetailForAccumTypeDTO.setRunningBalance(0.0);
			
			claimDetailsForAccumTypeDTO.add(claimDetailForAccumTypeDTO);
		}
		
		
		return  claimDetailsForAccumTypeDTO;
		
	}

}
