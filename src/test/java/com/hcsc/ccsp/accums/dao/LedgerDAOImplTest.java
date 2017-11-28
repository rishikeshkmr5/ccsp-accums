package com.hcsc.ccsp.accums.dao;

import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hcsc.ccsp.accums.config.DBConfig;
import org.springframework.test.context.ContextConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfig.class})
public class LedgerDAOImplTest {
	
	/*private static LedgerDAOImpl ledgerDAOImpl;
	private static JdbcTemplate jdbcTemplate;*/
	
	@Autowired
    @Qualifier("ledgerDAOImpl")
	LedgerDAOImpl ledgerDAOImpl;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
