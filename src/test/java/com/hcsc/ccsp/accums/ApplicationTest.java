package com.hcsc.ccsp.accums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcsc.ccsp.accums.controller.AccumController;
import com.hcsc.ccsp.accums.controller.LedgerController;
import com.hcsc.ccsp.accums.dao.LedgerDAOImpl;

// https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests
// 41.3.7 Auto-configured Spring MVC tests
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {


	@Autowired
    private AccumController accumController;

	@Autowired
    private LedgerController ledgerController;
	
	@Autowired
	private LedgerDAOImpl dao;
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void contextLoads() throws Exception {
	}

	@Test
	public void contextLoadsAccumController() throws Exception {
		
		assertThat(accumController).isNotNull();
	}
	
	@Test
	public void contextLoadsLedgerController() throws Exception {
		
		assertThat(ledgerController).isNotNull();
	}
	
	@Test
	public void accumShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Accum API");
	}

	@Test
	public void accumShouldReturnGreetingsMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greetings",
				String.class)).contains("Hello World");
	}

/*	 
	 @Test
	 public void shouldHaveSuccess() throws Exception {

	        List<Object> lh = dao.findAll("LedgerHeader");
	        assertNotNull(lh);
	        assertTrue(!lh.isEmpty());
	        
	        System.out.println("x");
	 }
	 */
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
 	
}
