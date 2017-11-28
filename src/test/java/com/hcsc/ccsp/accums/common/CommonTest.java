package com.hcsc.ccsp.accums.common;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcsc.ccsp.accums.common.TableEntries;
import com.hcsc.ccsp.accums.dto.db.LedgerEntry;
import com.hcsc.ccsp.accums.dto.db.LedgerHeader;
import com.hcsc.ccsp.accums.dto.db.LedgerSummary;


@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTest {

	@Test
	public final void whenTableNameIsUsedThenReturnTableName() {

		assertEquals("LDGR_HDR", TableEntries.LedgerHeader.getTableName());
		assertEquals("LDGR_ENTRY", TableEntries.LedgerEntry.getTableName());
		assertEquals("LDGR_SUM", TableEntries.LedgerSummary.getTableName());
	}
	
	@Test
	public final void whenTableIdUsedThenReturnTableId() {

		assertEquals("LDGR_ID", TableEntries.LedgerHeader.getTableId());
		assertEquals("LDGR_ENTRY_ID", TableEntries.LedgerEntry.getTableId());
		assertEquals("LDGR_SUM_ID", TableEntries.LedgerSummary.getTableId());
	}
	
	@Test
	public final void whenTableNameIsUsedThenReturnObjectClass() {

		assertEquals(LedgerHeader.class, TableEntries.LedgerHeader.getTableClass());
		assertEquals(LedgerEntry.class, TableEntries.LedgerEntry.getTableClass());
		assertEquals(LedgerSummary.class, TableEntries.LedgerSummary.getTableClass());
	}


	@Test
	public final void whenInvalidTableNameIsUsedThenReturnError() {

		try {
			TableEntries.valueOf(StringUtils.capitalize("ledgeHeader"));
		}
		catch(Exception e)
		{
			assertThat(e.toString(), containsString("No enum constant"));	
		}
	}
}