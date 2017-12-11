package com.ccsp.accums.pcfdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;

public class AccumsConsumptionMapper implements RowMapper<AccumsConsumptionDTO> {

	@Override
	public AccumsConsumptionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccumsConsumptionDTO accumsConsumptionDTO = new AccumsConsumptionDTO();
		accumsConsumptionDTO.setAccumType(rs.getString("ACCUM_TYP_NM"));
		accumsConsumptionDTO.setAllowedAmount(rs.getDouble("ALWD_AMT"));
		accumsConsumptionDTO.setAmount(rs.getDouble("AMT"));
		accumsConsumptionDTO.setDcn(rs.getString("DCN"));
		accumsConsumptionDTO.setMemberId(rs.getString("MBR_ID"));
		accumsConsumptionDTO.setNetworkCode(rs.getString("NTWK_CD"));
		accumsConsumptionDTO.setProcessedDate(rs.getDate("PROC_DT"));
		accumsConsumptionDTO.setServiceDate(rs.getDate("SVC_DT"));
		accumsConsumptionDTO.setSubscriberId(rs.getString("SUB_ID"));
		return accumsConsumptionDTO;
	}

}
