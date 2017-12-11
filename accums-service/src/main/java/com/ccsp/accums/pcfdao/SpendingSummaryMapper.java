package com.ccsp.accums.pcfdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.common.utils.DateUtils;

public class SpendingSummaryMapper implements RowMapper<SpendingSummaryDTO>{

	@Override
	public SpendingSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SpendingSummaryDTO ledgerSummaryDTO= new SpendingSummaryDTO();
		ledgerSummaryDTO.setAllowedAmount(rs.getDouble("ALWD_AMT"));
		ledgerSummaryDTO.setStartDate(DateUtils.getYearStart());
		ledgerSummaryDTO.setEndDate(DateUtils.getYearEnd());
	    ledgerSummaryDTO.setMemberId(rs.getString("MBR_ID"));
		ledgerSummaryDTO.setNetworkCode(rs.getString("NTWK_CD"));
		ledgerSummaryDTO.setServiceName(rs.getString("SVC_NM"));
		ledgerSummaryDTO.setStartDate(DateUtils.getYearStart());
		ledgerSummaryDTO.setSubscriberId(rs.getString("SUB_ID"));
		ledgerSummaryDTO.setLimit(10l);
		ledgerSummaryDTO.setUnit(ledgerSummaryDTO.getAllowedAmount()>0? 1.0 : 0.0);
		
		return ledgerSummaryDTO;
	}

}
