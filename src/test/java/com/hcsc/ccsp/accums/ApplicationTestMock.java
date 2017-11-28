package com.hcsc.ccsp.accums;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcsc.ccsp.accums.dao.LedgerDAO;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.service.AccumService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTestMock {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccumService service;


	@MockBean
	private LedgerDAO dao;

	private AccumUtilization au;
	

    @Before
    public void before() {
        auBuilder();
    }

	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Accum API")));
	}
	 

	
	
	
//	@Test
//	public void greetingShouldReturnMessageFromService() throws Exception {
//		when(service.greet()).thenReturn("Hello Mocxk");
//		this.mockMvc.perform(get("/greetings")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("Hello Mock")))
//		;
//	}
	
	@Test
	public void findAllShouldReturnMessageFromService() throws Exception {
	
		//		when(dao.findAll("LedgerHead")).thenReturn(buldList());
		mockMvc.perform(get("/api/{table}/list","LedgerHead")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(contains(new ArrayList<Object>())))
		;
	}
/*
	@Test
	public void shouldReturn200() throws Exception {

		this.mvc.perform(get("/api/LedgerHeader/list")
				.accept(MediaType.APPLICATION_JSON_UTF8))
        		.andExpect(status().isOk());
 	}	

	@Test
	public void shouldReturn200ValidJson() throws Exception {

		this.mvc.perform(get("/api/LedgerHeader/list")
				.accept(MediaType.APPLICATION_JSON_UTF8))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$", hasSize(2)))
        		
  */      		
 //  checking for object       		.andExpect(content().json("{'message':'ok'}"));
//        		.andExpect(content().json("{'data':[{'useRegEx':'false','hosts':'v2v2v2'}]}"))
        		;
  //	}	

//	@Test
//	public void shouldReturn200WithBadTableName() throws Exception {

//		this.mvc.perform(get("/api/LedgerHea/list")
//				.accept(MediaType.APPLICATION_JSON_UTF8))
 //       		.andExpect(status().isOk())
  //      		.andExpect(content().equals(null));
 //	;
//	}	

	
//	@Test
//	public void shouldReturn404() throws Exception {

//		this.mvc.perform(get("/bad/url")
//				.accept(MediaType.APPLICATION_JSON_UTF8))
 //       		.andExpect(status().isNotFound());
 //	/}
        		
        		public List<Object> buldList(){
					
        			
        			
        			
        			return new ArrayList<Object>();
        			
        			
        		}
     
    public void auBuilder() {
        	    	
    	au = new AccumUtilization();
        	  
    	au.setDcn("dcn");
    	au.setCorpEntCd("IL1");
    	au.setClaimLineId(1);
    	au.setServiceId(2);
    	au.setServiceName("");
    	au.setServiceDate(new Date(2017-01-01));
    	au.setProcessedDate(new Timestamp(2017-01-01));
    	au.setNetworkCode("");
    	au.setNetworkTier("");
    	au.setPlanId(3);
    	au.setAllowedAmount(4);
    	au.setMemberId("13");
    	au.setSubscriberId("14");
    	au.setUnitOfMeasure("15");
    	au.setTransactionCode("17");    
    }
 
}
