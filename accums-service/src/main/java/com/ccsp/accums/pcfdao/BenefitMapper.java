package com.ccsp.accums.pcfdao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
public class BenefitMapper implements RowMapper<LedgerSummaryDTO> {

	@Override
	public LedgerSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		LedgerSummaryDTO ledgerSummaryDTO= new LedgerSummaryDTO();
		ledgerSummaryDTO.setSubscriberId(rs.getString("SUB_ID"));
		ledgerSummaryDTO.setMemberId(rs.getString("MBR_ID"));
		ledgerSummaryDTO.setAccumType(rs.getString("ACCUM_TYP_NM"));
		ledgerSummaryDTO.setEffectiveDate(rs.getDate("EFF_DT"));
		ledgerSummaryDTO.setEndDate(rs.getDate("END_DT"));
		ledgerSummaryDTO.setNetworkCode(rs.getString("NTWK_CD"));
		ledgerSummaryDTO.setAmount(rs.getDouble("AMT"));
		ledgerSummaryDTO.setMaxAmount(rs.getDouble("MAX_AMT")); 
		return ledgerSummaryDTO;
		
	}

}
