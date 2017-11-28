package com.hcsc.ccsp.accums.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.hcsc.ccsp.accums.common.DateUtil;
import com.hcsc.ccsp.accums.common.SqlQueries;
import com.hcsc.ccsp.accums.common.TableEntries;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

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


	
}

