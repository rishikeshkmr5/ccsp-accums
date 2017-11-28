package com.hcsc.ccsp.accums.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.hcsc.ccsp.accums"})
//@PropertySource(value={"classpath:db.properties"}, ignoreResourceNotFound = false)
@EnableTransactionManagement
public class DBConfig {
    @Value("${db.driver}")
    private String DRIVER;
 
    @Value("${db.password}")
    private String PASSWORD;
 
    @Value("${db.url}")
    private String URL;
 
    @Value("${db.username}")
    private String USERNAME;
 
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        Properties props = new Properties();
        props.setProperty("autocommit", "false");
        dataSource.setConnectionProperties(props);
        return dataSource;
    }
 
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	jdbcTemplate.setResultsMapCaseInsensitive(true);
   
        return jdbcTemplate;
    }
    
 //   @Bean
 //   public SimpleJdbcInsert simpleJdbcInsertLH(DataSource dataSource) {
  //  	SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("LDGR_HDR").usingGeneratedKeyColumns("LDGR_ID");
        	
  //      return simpleJdbcInsert;
  //  } 
    
 //   @Bean
  //  public SimpleJdbcInsert simpleJdbcInsertLE(DataSource dataSource) {
  //	SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("LDGR_ENTRY").usingGeneratedKeyColumns("LDGR_ENTRY_ID");
        	
  //      return simpleJdbcInsert;
  //  } 
}