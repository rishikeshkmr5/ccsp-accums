package com.ccsp.accums.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;

/**
 * @author vaibhav
 *
 */
@Mapper
public abstract class LedgerHeaderMapper {

	/**
	 * Instance of LedgerHeaderMapper
	 * 
	 */
	public static final LedgerHeaderMapper INSTANCE = Mappers.getMapper(LedgerHeaderMapper.class);
	
	/**
	 * @param ledgerHeaderDTO
	 * Converts LedgerHeaderDTO and @return LedgerHeader 
	 * Method converts LedgerHeaderDTO to LedgerHeader entity
	 * 
	 */
	public abstract LedgerHeader toLedgerHeaderEntity(LedgerHeaderDTO ledgerHeaderDTO);
	
	/**
	 * @param ledgerHeader
	 * @return LedgerHeaderDTO
	 * Method converts the LedgerHeader entity to LedgerHeaderDTO
	 * 
	 */
	@Named(value = "toDto")
	public abstract LedgerHeaderDTO toLedgerHeaderDTO(LedgerHeader ledgerHeader);
	
	
	/**
	 * @param ledgerHeader
	 * @return List of all LedgerHeaderDTO
	 * Method converts List of LedgerHeader Entity to List of LedgerHeader Entity
	 * 
	 */
	@IterableMapping(qualifiedByName = "toDto")
	public abstract List<LedgerHeaderDTO> toLedgerHeaderList(List<LedgerHeader> ledgerHeader);
}
