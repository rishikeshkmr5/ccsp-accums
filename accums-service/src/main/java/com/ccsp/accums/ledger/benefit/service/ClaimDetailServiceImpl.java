package com.ccsp.accums.ledger.benefit.service;

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
public class ClaimDetailServiceImpl extends CommonServiceImpl<ClaimDetailsForAccumTypeDTO, LedgerHeaderEntity> {

	@Resource
	private ILedgerHeaderRepository ledgerHeaderRepository;
	
	@Override
	public JpaRepository<LedgerHeaderEntity, Long> getJPARepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  IBaseMapper<ClaimDetailsForAccumTypeDTO, LedgerHeaderEntity> getMapper() {
		// TODO Auto-generated method stub
		return ClaimDetailMapper.INSTANCE;
	}
	
	public List<ClaimDetailsForAccumTypeDTO> getClaimDetail(String accumType) throws NotFoundException {
		ClaimDetailsForAccumTypeDTO claimDetailForAccumTypeDTO = new ClaimDetailsForAccumTypeDTO();
		List<ClaimDetailsForAccumTypeDTO> claimDetailsForAccumTypeDTO = new ArrayList<ClaimDetailsForAccumTypeDTO>();
		//Retrieve the LedgerHeader details based on the accumType
		//List<LedgerHeaderEntity> accumHeaderList =  ledgerHeaderRepository.findByAccumType(accumType);
		/*if(accumHeaderList.isEmpty()) {
			throw new NotFoundException(
					"There are no Claims available for accumType : " + accumType);
		}
		for(LedgerHeaderEntity ledgerHeaderEntity:accumHeaderList) {
			//Convert the entity to DTO
			claimDetailForAccumTypeDTO =getMapper().convertToDTO(ledgerHeaderEntity); 
			claimDetailForAccumTypeDTO.setRunningBalance(0.0);
			claimDetailsForAccumTypeDTO.add(claimDetailForAccumTypeDTO);
		}*/
		
		
		return  claimDetailsForAccumTypeDTO;
		
	}

}
