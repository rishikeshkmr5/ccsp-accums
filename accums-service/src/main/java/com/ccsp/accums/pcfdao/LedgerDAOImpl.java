package com.ccsp.accums.pcfdao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.ccsp.accums.dto.pcfdb.LedgerHeader;
import com.ccsp.accums.ledger.summary.dto.LedgerSummaryDTO;
import com.ccsp.accums.ledger.summary.mapper.LedgerSummaryMapper;
import com.ccsp.accums.pcfcommons.DateUtil;
import com.ccsp.accums.pcfcommons.SqlQueries;
import com.ccsp.accums.pcfcommons.TableEntries;
import com.ccsp.accums.pcfdto.AccumUtilization;
import com.ccsp.accums.pcfdto.ServiceLine;
import com.ccsp.accums.utilization.dto.AccumsConsumptionDTO;
import com.ccsp.accums.utilization.dto.ClaimDetailDTO;
import com.ccsp.accums.utilization.dto.SpendingSummaryDTO;
import com.ccsp.accums.utilization.mapper.ClaimMapper;
import com.ccsp.common.utils.DateUtils;

@Repository
public class LedgerDAOImpl implements LedgerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	private SimpleJdbcInsert simpleJdbcInsertLH;
	
//	@Autowired
//	private SimpleJdbcInsert simpleJdbcInsertLE;
	
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List <Object> findAll(String sValue) {
		
		System.out.println("LedgerDAO.findAll("+sValue+")");
			
		return jdbcTemplate.query("SELECT * FROM "+TableEntries.valueOf(sValue).getTableName(), new BeanPropertyRowMapper(TableEntries.valueOf(StringUtils.capitalize(sValue)).getTableClass()));
	}
	
	
	public void insert(String sValue,  Object[] params ) {
		jdbcTemplate.update(sValue, params);
	}
	

	public List<Map<String, Object>> getById(String sTable, String dbColumnName, String dbColumnValue) {
		String sql = "SELECT * FROM " + TableEntries.valueOf(sTable).getTableName() + " WHERE " + dbColumnName + " = '" + dbColumnValue+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List < Object > findById(String sTable, String sColumn, BigInteger bValue) {

		return jdbcTemplate.query("SELECT * FROM "+TableEntries.valueOf(sTable).getTableName()+" where "+sColumn+" = ?",
				new Object[] { bValue }, 
				new BeanPropertyRowMapper(TableEntries.valueOf(StringUtils.capitalize(sTable)).getTableClass()));
	}
	
	
	public int resetAG(String sTable) {
		
		return jdbcTemplate.update("ALTER TABLE "+TableEntries.valueOf(sTable).getTableName()+" AUTO_INCREMENT = 1");
	}
	
	
	public int delete(String sTable, String sColumn) {
		
		return jdbcTemplate.update("DELETE FROM "+TableEntries.valueOf(sTable).getTableName()+" where "+sColumn+">0");
	}
	

//	public long insertLedgerHeaderGK( Map<String, Object> parameters ) {
		
//		Number number = simpleJdbcInsertLH.executeAndReturnKey(parameters);
//		if (number != null) {
//			return number.longValue();
//		}
//		throw new RuntimeException("Cannot retrieve primary key");
//	}
	

	public BigInteger insertLedgerHeaderGK(AccumUtilization accumUtilization) {
    	
    	final String GENERATED_COLUMNS[] = { TableEntries.LedgerHeader.getTableId() };
    	GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    	jdbcTemplate.update(new PreparedStatementCreator() {
       		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    			PreparedStatement ps = con.prepareStatement(SqlQueries.insertLedgerHeader.getSql(), GENERATED_COLUMNS);
    				ps.setString(1, accumUtilization.getDcn());
    				ps.setString(2, accumUtilization.getCorpEntCd());
    				ps.setInt(3, accumUtilization.getClaimLineId());
    				ps.setInt(4, accumUtilization.getServiceId());
    				ps.setString(5, accumUtilization.getServiceName());
    				ps.setDate(6, accumUtilization.getServiceDate());
    				ps.setTimestamp(7, accumUtilization.getProcessedDate());
    				ps.setString(8, accumUtilization.getNetworkCode());
    				ps.setString(9, accumUtilization.getNetworkTier());
    				ps.setInt(10, accumUtilization.getPlanId());
    				ps.setDouble(11, accumUtilization.getAllowedAmount());
    				ps.setString(12, accumUtilization.getMemberId());
    				ps.setString(13, accumUtilization.getSubscriberId());
    				ps.setString(14, accumUtilization.getUnitOfMeasure());
    				ps.setString(15, accumUtilization.getTransactionCode());
    				return ps;
    		}
    	},keyHolder);
 
    	return BigInteger.valueOf((long) keyHolder.getKey());
    }
	

//	public long insertLedgerEntryGK( Map<String, Object> parameters ) {
		
//		Number number = simpleJdbcInsertLE.executeAndReturnKey(parameters);
//		if (number != null) {
//			return number.longValue();
//		}
//		throw new RuntimeException("Cannot retrieve primary key");
//	}

	
	
	public BigInteger insertLedgerEntryGK( ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey ) {
		
		final String GENERATED_COLUMNS[] = { TableEntries.LedgerEntry.getTableId() };
    	GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    	jdbcTemplate.update(new PreparedStatementCreator() {
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    			PreparedStatement ps = con.prepareStatement(SqlQueries.insertLedgerEntry.getSql(), GENERATED_COLUMNS);
    				ps.setLong(1, entryKey.longValue());
    				ps.setLong(2, headerKey.longValue());
    				ps.setString(3, serviceLine.getAccumType());
    				ps.setString(4, serviceLine.getRole());
    				ps.setString(5, serviceLine.getCostShareTier());
    				ps.setDouble(6, serviceLine.getAmount());
    				ps.setString(7, serviceLine.getNetwork());
    				ps.setDouble(8, serviceLine.getSnapShotSummary());
    				ps.setString(9, serviceLine.getUnitOfMeasure());
    				ps.setDate(10, DateUtil.convertUtilToSql(serviceLine.getServiceDate()));
    				return ps;
    		}
    	},keyHolder);
 
    	return BigInteger.valueOf((long) keyHolder.getKey());
	}
	
	
	
	
	public  List<SpendingSummaryDTO> getSummaryAccum(String memberId) {
		String sql = "SELECT * FROM LDGR_HDR l WHERE l.MBR_ID = ?";
		
		return jdbcTemplate.query(sql, new Object[] {memberId}, new SpendingSummaryMapper());
	}
	
	
	public List<LedgerSummaryDTO> getBenefitBalance(String memberId){
		String sql = "SELECT * FROM LDGR_SUM l WHERE l.MBR_ID = ?";
		return jdbcTemplate.query(sql, new Object[] {memberId}, new BenefitMapper());
	}
	
	public List<AccumsConsumptionDTO> getClaimDetailsByMemberIdAndAccumType(String accumType, String memberID){
		String sql = "select * from LDGR_ENTRY c ,LDGR_HDR h where c.LDGR_ID  = h.LDGR_ID and c.ACCUM_TYP_NM = ? and h.MBR_ID = ?  ";
		return jdbcTemplate.query(sql, new Object[] {accumType,memberID}, new AccumsConsumptionMapper());
	}
	
	public ClaimDetailDTO getClaim(String claimID){
		String sql = "select * from LDGR_HDR l where l.DCN = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {claimID},new ClaimDetailMapper());
	}
	
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public List < Object >   accum( String memberId) {
		
		return jdbcTemplate.query(SqlQueries.selectLedgerHeader.getSql(),
				new Object[] { memberId }, 
				new BeanPropertyRowMapper(LedgerHeader.class));
	}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SpendingSummaryDTO>  summaryAccum( String memberId) {
		
		 List<SpendingSummaryDTO> spendingSummaryList = new ArrayList<>();
		 List<SpendingSummaryDTO> spendingSummaryDTO = jdbcTemplate.query(SqlQueries.selectLedger.getSql(),
		        new PreparedStatementSetter() {
		            public void setValues(PreparedStatement preparedStatement) throws SQLException {
		                preparedStatement.setString(1,memberId);
		            }
		        },
		        new BeanPropertyRowMapper(SpendingSummaryDTO.class));
		 for (SpendingSummaryDTO ledgerSummary:spendingSummaryDTO) {
			 	ledgerSummary.setStartDate(DateUtils.getYearStart());
	  			ledgerSummary.setEndDate(DateUtils.getYearEnd());
	  		    ledgerSummary.setStartDate(DateUtils.getYearStart());
	  			ledgerSummary.setLimit(10l);
	  			ledgerSummary.setUnit(ledgerSummary.getAllowedAmount()>0? 1.0 : 0.0);
	  			spendingSummaryList.add(ledgerSummary);
		 }
	 return spendingSummaryList;
		
}
	
	/*public List<SpendingSummaryDTO>  summaryAccum( String memberId) {
		List<SpendingSummaryDTO> spendingSummaryDTO =  new ArrayList<SpendingSummaryDTO>();
	
		 jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				 return con.prepareStatement(SqlQueries.selectLedgerHeader.getSql());
			}
			
		},new PreparedStatementSetter() {
	  	      public void setValues(PreparedStatement preparedStatement) throws SQLException {
	    	        preparedStatement.setString(1, memberId);
	      }
	 },new ResultSetExtractor<List<SpendingSummaryDTO>>() {

		@Override
		public List<SpendingSummaryDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
				while (rs.next()) {
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
	  			spendingSummaryDTO.add(ledgerSummaryDTO);
				}
	  			return spendingSummaryDTO;
	}
	 
});
	 
		return spendingSummaryDTO;
}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<LedgerSummaryDTO>  benefitBalance( String memberId) {
		
		 return jdbcTemplate.query(SqlQueries.selectSummary.getSql(),
		        new PreparedStatementSetter() {
		            public void setValues(PreparedStatement preparedStatement) throws SQLException {
		                preparedStatement.setString(1,memberId);
		            }
		        },
		        new BeanPropertyRowMapper(LedgerSummaryDTO.class));
	}
	
	
	/*public List<LedgerSummaryDTO>  benefitBalance( String memberId) {
		List<LedgerSummaryDTO> ledgerSummaryDTOList =  new ArrayList<LedgerSummaryDTO>();
	
		 jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				 return con.prepareStatement(SqlQueries.selectLedgerSummary.getSql());
			}
			
		},new PreparedStatementSetter() {
	  	      public void setValues(PreparedStatement preparedStatement) throws SQLException {
	    	        preparedStatement.setString(1, memberId);
	      }
	 },new ResultSetExtractor<List<LedgerSummaryDTO>>() {

		@Override
		public List<LedgerSummaryDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
				while (rs.next()) {

					LedgerSummaryDTO ledgerSummaryDTO= new LedgerSummaryDTO();
					ledgerSummaryDTO.setSubscriberId(rs.getString("SUB_ID"));
					ledgerSummaryDTO.setMemberId(rs.getString("MBR_ID"));
					ledgerSummaryDTO.setAccumType(rs.getString("ACCUM_TYP_NM"));
					ledgerSummaryDTO.setEffectiveDate(rs.getDate("EFF_DT"));
					ledgerSummaryDTO.setEndDate(rs.getDate("END_DT"));
					ledgerSummaryDTO.setNetworkCode(rs.getString("NTWK_CD"));
					ledgerSummaryDTO.setAmount(rs.getDouble("AMT"));
					ledgerSummaryDTO.setMaxAmount(rs.getDouble("MAX_AMT")); 
					ledgerSummaryDTOList.add(ledgerSummaryDTO);
					return ledgerSummaryDTOList;
					
				}
	  			return ledgerSummaryDTOList;
	}
	 
});
	 
		return ledgerSummaryDTOList;
}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AccumsConsumptionDTO>  claimDetailsByMemberIdAndAccumType(String accumType, String memberID) {
		
		
		 return jdbcTemplate.query(SqlQueries.selectHeaderAndEntry.getSql(),
			        new PreparedStatementSetter() {
			            public void setValues(PreparedStatement preparedStatement) throws SQLException {
			            	 preparedStatement.setString(1, accumType);
				    	        preparedStatement.setString(2, memberID);
			            }
			        },
			        new BeanPropertyRowMapper(AccumsConsumptionDTO.class));
		
		
	}

	/*public List<AccumsConsumptionDTO>  claimDetailsByMemberIdAndAccumType(String accumType, String memberID) {
		List<AccumsConsumptionDTO> accumsConsumptionDTOList =  new ArrayList<AccumsConsumptionDTO>();
	
		 jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				 return con.prepareStatement(SqlQueries.selectLedgerHeaderAndEntry.getSql());
			}
			
		},new PreparedStatementSetter() {
	  	      public void setValues(PreparedStatement preparedStatement) throws SQLException {
	    	        preparedStatement.setString(2, accumType);
	    	        preparedStatement.setString(1, memberID);
	      }
	 },new ResultSetExtractor<List<AccumsConsumptionDTO>>() {

		@Override
		public List<AccumsConsumptionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			while(rs.next()) {
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
			accumsConsumptionDTOList.add(accumsConsumptionDTO);
			}
			return accumsConsumptionDTOList;
		}
	 
});
	 
		return accumsConsumptionDTOList;
}*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ClaimDetailDTO>  claimDetail( String dcn) {
		List<ClaimDetailDTO> claimDetailDTOList = new ArrayList<>();
		List<ClaimDetailDTO> claimDetailDTO =  jdbcTemplate.query(SqlQueries.selectClaim.getSql(),
			        new PreparedStatementSetter() {
			            public void setValues(PreparedStatement preparedStatement) throws SQLException {
			            	 preparedStatement.setString(1, dcn);
			            }
			        },
			        new BeanPropertyRowMapper(ClaimDetailDTO.class));
		
		for(ClaimDetailDTO claimDetail :claimDetailDTO) { 
		    claimDetail.setProvider("Dr. Phill");
		
		    claimDetailDTOList.add(claimDetail);
		}
	
	return claimDetailDTOList;
	
	
	}

	/*public List<ClaimDetailDTO>  claimDetail( String dcn) {
		List<ClaimDetailDTO> claimDetailDTOList =  new ArrayList<ClaimDetailDTO>();
	
		 jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				 return con.prepareStatement(SqlQueries.selectClaimFromLedgerHeader.getSql());
			}
			
		},new PreparedStatementSetter() {
	  	      public void setValues(PreparedStatement preparedStatement) throws SQLException {
	    	        preparedStatement.setString(1, dcn);
	      }
	 },new ResultSetExtractor<List<ClaimDetailDTO>>() {

		@Override
		public List<ClaimDetailDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			while (rs.next()) {
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
			claimDetailDTOList.add(claimDetailDTO);
			}
		return claimDetailDTOList;
		}
	 
});
	 
		return claimDetailDTOList;
}*/
	
	

	
	
}