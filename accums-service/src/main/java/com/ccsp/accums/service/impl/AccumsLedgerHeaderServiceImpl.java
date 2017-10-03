package com.ccsp.accums.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.accums.ledger.repository.LedgerHeaderRepository;
import com.ccsp.accums.mapper.LedgerHeaderMapper;
import com.ccsp.accums.service.IAccumsLedgerHeaderService;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
@Component
public class AccumsLedgerHeaderServiceImpl extends CommonServiceImpl{

	
	/**
	 * Autowiring repository layer
	 */
	@Resource
	private LedgerHeaderRepository ledgerHeaderRepository;

	

	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#create(com.ccsp.common.dto.ICommonDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> T create(T dto) {
		LedgerHeaderDTO ledgerHeaderDTO = (LedgerHeaderDTO)dto;
		LedgerHeader result = null;
		LedgerHeader ledgerHeader = LedgerHeaderMapper.INSTANCE.toLedgerHeaderEntity(ledgerHeaderDTO);
		if(ledgerHeader != null){
			result = ledgerHeaderRepository.saveAndFlush(ledgerHeader);
		}
		LedgerHeaderDTO resultDTO = LedgerHeaderMapper.INSTANCE.toLedgerHeaderDTO(result);
		return (T) resultDTO;
	}



	/* (non-Javadoc)
	 * @see com.ccsp.common.service.impl.CommonServiceImpl#readAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends ICommonDTO> List<T> readAll() throws NotFoundException {
		List<LedgerHeader> ledgerHeaders=ledgerHeaderRepository.findAll();
		
		/**check if there are any ledgerHeaders in backend **/
		if(ledgerHeaders == null || ledgerHeaders.size() == 0) {
			throw new NotFoundException("Resource Not Found");
		}
		
		return (List<T>) LedgerHeaderMapper.INSTANCE.toLedgerHeaderList(ledgerHeaders);
	}	
	
}
