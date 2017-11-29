package com.ccsp.accums.ledger.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.header.controller.LedgerHeaderController;
import com.ccsp.accums.ledger.header.dto.AccumUtilization;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
/**
 * @author nnarayanaperumaln
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LedgerHeaderControllerTest {
	public static int i = 10;

	@InjectMocks
	private LedgerHeaderController accumsController;

	/**
	 * Mock the Service layer
	 */
	@Mock
	private LedgerHeaderService ledgerHeaderService;

	/**
	 * @throws NotFoundException
	 */
	@Test
	public void testGetLedgerHeader() throws NotFoundException {
		List<LedgerHeaderDTO> ledgerHeaderDTOList = new ArrayList<>();
		LedgerHeaderDTO entryDTO = new LedgerHeaderDTO();
		ledgerHeaderDTOList.add(entryDTO);
		when(ledgerHeaderService.readAll()).thenReturn(ledgerHeaderDTOList);
		List<LedgerHeaderDTO> actual = accumsController.getLedgerHeader();
		Assert.assertEquals(actual, ledgerHeaderDTOList);
	}
	
	/**
	 * Test the ledgerHeader creation
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void testSetLedgerHeader() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, Exception {
		Validator validator = mock(Validator.class);
		AccumUtilization claimHeadetDTO = new AccumUtilization();
		LedgerHeaderDTO ledgerHeaderDTO = claimHeadetDTO;	
		this.setValidator(accumsController, validator);
		accumsController.createLedgerHeader(claimHeadetDTO);
		when(ledgerHeaderService.create(ledgerHeaderDTO)).thenReturn(ledgerHeaderDTO);
		LedgerHeaderDTO actual = accumsController.createLedgerHeader(claimHeadetDTO);
		Assert.assertEquals(ledgerHeaderDTO, actual);
	}
	
		
	private void setValidator(LedgerHeaderController controller, Validator validator) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{		
		Field[] fields = controller.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.getName().equals("validator"))
				field.set(controller, validator);
		}
	}
	
	

}
