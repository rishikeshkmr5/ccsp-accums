package com.ccsp.accums.pcfdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ccsp.accums.utilization.dto.ClaimDetailDTO;

public class ClaimDetailMapper implements RowMapper<ClaimDetailDTO> {

	@Override
	public ClaimDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClaimDetailDTO claimDetailDTO= new ClaimDetailDTO();
		claimDetailDTO.setAmount(rs.getDouble("ALWD_AMT"));
		claimDetailDTO.setClaim(rs.getString("DCN"));
		claimDetailDTO.setClaimLine(rs.getInt("CLM_LN_ID"));
		claimDetailDTO.setMember(rs.getString("MBR_ID"));
		claimDetailDTO.setNetwork(rs.getString("NTWK_CD"));
		claimDetailDTO.setProcessedDt(rs.getDate("PROC_DT"));
		claimDetailDTO.setProvider("Dr. Phill");
		claimDetailDTO.setService(rs.getString("SVC_NM"));
		claimDetailDTO.setServiceDt(rs.getDate("SVC_DT"));
		claimDetailDTO.setSubscriber(rs.getString("SUB_ID"));
		
		return claimDetailDTO;
	}

}
