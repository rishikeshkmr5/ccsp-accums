package com.hcsc.ccsp.accums.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcsc.ccsp.accums.common.SqlQueries;
import com.hcsc.ccsp.accums.common.TableEntries;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;
import com.hcsc.ccsp.accums.dto.db.LedgerEntry;
import com.hcsc.ccsp.accums.dto.db.LedgerHeader;
import com.hcsc.ccsp.accums.dto.db.LedgerSummary;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {


	@Autowired
	private LedgerDAOImpl dao;
	
	private static AccumUtilization au;
	private static ServiceLine sl; 	
	
	
	@BeforeClass
    public static void onceExecutedBeforeAll() {
		System.out.println("@BeforeClass: onceExecutedBeforeAll");
	
		getAccumUtilization();
	}

	@Before
	public void executedBeforeEach() {		
		System.out.println("@Before: executedBeforeEach");
	
		dao.delete(TableEntries.LedgerHeader.name(), TableEntries.LedgerHeader.getTableId());
		dao.delete(TableEntries.LedgerEntry.name(), TableEntries.LedgerEntry.getTableId());
		dao.delete(TableEntries.LedgerSummary.name(), TableEntries.LedgerSummary.getTableId());
		
//		dao.resetAG(TableEntries.LedgerHeader.name());
//		dao.resetAG(TableEntries.LedgerEntry.name());
//		dao.resetAG(TableEntries.LedgerSummary.name());
    }
	
	
	@Test
	public void shouldInsertReturnGK() throws Exception {

		BigInteger generatedKey;
		List<Object> list;
		
		// LedgerHeader
//		generatedKey = dao.insertLedgerHeaderGK(new LedgerServiceImpl().ledgerHeaderMapBuilder(au));
		generatedKey = dao.insertLedgerHeaderGK(au);
		
		list = dao.findById(TableEntries.LedgerHeader.name(), TableEntries.LedgerHeader.getTableId(), generatedKey);
		
		Assert.assertEquals(1, list.size());
//		Assert.assertEquals(1, generatedKey);
		Assert.assertEquals(generatedKey, ((LedgerHeader) list.get(0)).getLDGR_ID());
		Assert.assertEquals(au.getDcn(), ((LedgerHeader) list.get(0)).getDCN());
		
		// LedgerEntry	
		//generatedKey = dao.insertLedgerEntryGK(new LedgerServiceImpl().ledgerEntryMapBuilder(au.getServiceLine().get(0)));
		generatedKey = dao.insertLedgerEntryGK(au.getServiceLine().get(0), BigInteger.valueOf(0), BigInteger.valueOf(0));

		
		list = dao.findById(TableEntries.LedgerEntry.name(), TableEntries.LedgerEntry.getTableId(), generatedKey);
		
		Assert.assertEquals(1, list.size());
//		Assert.assertEquals(1, generatedKey);
		Assert.assertEquals(generatedKey, ((LedgerEntry) list.get(0)).getLDGR_ENTRY_ID());
		Assert.assertEquals(au.getServiceLine().get(0).getAccumType(), ((LedgerEntry) list.get(0)).getACCUM_TYP_NM());

		// LedgerSummary
		
	}

//	@Test
	public void shouldInsert() throws Exception {

		List<Object> list;
		
		// LedgerHeader

		// LedgerEntry	
		
		// LedgerSummary
		dao.insert(SqlQueries.insertLedgerSummary.getSql(), getParams());
		
		list = dao.findById(TableEntries.LedgerSummary.name(), TableEntries.LedgerSummary.getTableId(), BigInteger.valueOf(1));
		
		Assert.assertEquals(1, list.size());
//		Assert.assertEquals(1, ((LedgerSummary) list.get(0)).getLDGR_SUM_ID());
		Assert.assertEquals(au.getServiceLine().get(0).getAccumType(), ((LedgerSummary) list.get(0)).getACCUM_TYP_NM());
	}

	

//	@Test
	public void shouldFindAll() throws Exception {
	}

 	
//	@Test
	public void shouldFindById() throws Exception {
	}
	
	
//	@Test
	public void shouldUpdate() throws Exception {
	}
	
//	@Test
	public void shoulddelete() throws Exception {
	}
	
	
	@After
	public void executedAfterEach() {		
		System.out.println("@After: executedAfterEach");
		
//		dao.resetAG(TableEntries.LedgerHeader.name());
//		dao.resetAG(TableEntries.LedgerEntry.name());
//		dao.resetAG(TableEntries.LedgerSummary.name());
	}

	
	@AfterClass
    public static void onceExecutedAfterAll() {
		System.out.println("@AfterClass: onceExecutedAfterAll");
	}

	
	public static void getAccumUtilization() {

		au = new AccumUtilization();
		au.setDcn("CLM0000001");
		au.setCorpEntCd("IL1");
		au.setClaimLineId(1);
		au.setServiceId(10000);
		au.setServiceName("Specialist Office Visit");
		au.setServiceDate(Date.valueOf("2017-05-05"));
//		au.setProcessedDate(Timestamp.valueOf("2017-05-06"));
		au.setNetworkCode("INB");
		au.setNetworkTier("PPO");
		au.setPlanId(1);
		au.setAllowedAmount(50);
		au.setMemberId("2147483647");
		au.setSubscriberId("A1234567");
		au.setUnitOfMeasure("Dollars");
		au.setTransactionCode("XXX"); 

		List<ServiceLine> l = new ArrayList<ServiceLine>();
		sl = new ServiceLine(); 
		sl.setAccumType("SPC COPAY");
		sl.setRole("PINT");
		sl.setCostShareTier("PPO");
		sl.setAmount(50);
		sl.setNetwork("IN");
		sl.setSnapShotSummary(50);
		sl.setUnitOfMeasure("Dollars");
		sl.setServiceDate(Date.valueOf("2017-05-25"));
		l.add(sl);

		l = new ArrayList<ServiceLine>();
		sl = new ServiceLine(); 
		sl.setAccumType("Individual OPX");
		sl.setRole("PINT");
		sl.setCostShareTier("PPO");
		sl.setAmount(50);
		sl.setNetwork("IN");
		sl.setSnapShotSummary(50);
		sl.setUnitOfMeasure("Dollars");
		sl.setServiceDate(Date.valueOf("2017-05-26"));		
		l.add(sl);

		l = new ArrayList<ServiceLine>();
		sl = new ServiceLine(); 
		sl.setAccumType("Individual Ded");
		sl.setRole("PINT");
		sl.setCostShareTier("PPO");
		sl.setAmount(50);
		sl.setNetwork("IN");
		sl.setSnapShotSummary(50);
		sl.setUnitOfMeasure("Dollars");
		sl.setServiceDate(Date.valueOf("2017-05-27"));		
		l.add(sl);

		l = new ArrayList<ServiceLine>();
		sl = new ServiceLine(); 
		sl.setAccumType("Family Ded");
		sl.setRole("PINT");
		sl.setCostShareTier("PPO");
		sl.setAmount(50);
		sl.setNetwork("IN");
		sl.setSnapShotSummary(50);
		sl.setUnitOfMeasure("Dollars");
		sl.setServiceDate(Date.valueOf("2017-05-28"));		
		l.add(sl);

		l = new ArrayList<ServiceLine>();
		sl = new ServiceLine(); 
		sl.setAccumType("Family OPX");
		sl.setRole("PINT");
		sl.setCostShareTier("PPO");
		sl.setAmount(50);
		sl.setNetwork("IN");
		sl.setSnapShotSummary(50);
		sl.setUnitOfMeasure("Dollars");
		sl.setServiceDate(Date.valueOf("2017-05-29"));		
		l.add(sl);

		
		au.setServiceLine(l);
	}
	
	public static Object[] getParams() {

		return new Object[] { au.getServiceLine().get(0).getAccumType(), au.getMemberId(), au.getServiceLine().get(0).getNetwork(),
				au.getServiceLine().get(0).getCostShareTier(), au.getEndDate(), au.getEffectiveDate(), au.getPlanId(), 
				au.getSubscriberId(), au.getAllowedAmount(), au.getMaxAmount(), au.getMaxVisit(), au.getUnitOfMeasure() };
	}
	
	   		
}
