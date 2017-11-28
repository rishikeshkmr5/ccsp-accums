package com.hcsc.ccsp.accums.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.hcsc.ccsp.accums.common.TableEntries;

@Repository
public class LedgerDAOImpl implements LedgerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsertLH;
	
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsertLE;
	
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List <Object> findAll(String sValue) {
		
		System.out.println("LedgerDAO.findAll("+sValue+")");
			
		return jdbcTemplate.query("SELECT * FROM "+TableEntries.valueOf(sValue).getTableName(), new BeanPropertyRowMapper(TableEntries.valueOf(StringUtils.capitalize(sValue)).getTableClass()));
	}
	
	
	public long insertLedgerHeaderGK( Map<String, Object> parameters ) {
				
		Number number = simpleJdbcInsertLH.executeAndReturnKey(parameters);
		if (number != null) {
			return number.longValue();
		}
		throw new RuntimeException("Cannot retrieve primary key");
	}
	

	public long insertLedgerEntryGK( Map<String, Object> parameters ) {
		
		Number number = simpleJdbcInsertLE.executeAndReturnKey(parameters);
		if (number != null) {
			return number.longValue();
		}
		throw new RuntimeException("Cannot retrieve primary key");
	}

	
	public void insert(String sValue,  Object[] params ) {
		jdbcTemplate.update(sValue, params);
	}

}
