package com.ccsp.accums.ledger.entry.controller;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.validation.ValidationException;
import com.ccsp.accums.ledger.entry.controller.LedgerEntryController;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryClaimDTO;
import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.entry.service.LedgerEntryService;
import com.ccsp.common.dto.ICommonDTO;
import com.ccsp.common.validator.Validator;

import javassist.NotFoundException;

import org.junit.Assert;

/**
 * @author nnarayanaperumaln
 *
 */
/**
 * @author nnarayanaperumaln
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LedgerEntryControllerTest {

	@InjectMocks
	private LedgerEntryController ledgerEntryController;
	
	@Mock
	private LedgerEntryService ledgerEntryService;
	
	@Test
	public void testCreateLedgerEntry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Validator validator = mock(Validator.class);
		LedgerEntryClaimDTO claimEntry = new LedgerEntryClaimDTO();
		List<LedgerEntryDTO> ledgerEntryDTOList = new ArrayList<>();
		LedgerEntryDTO ledgerEntryDTO = new LedgerEntryDTO();
		ledgerEntryDTOList.add(ledgerEntryDTO);
		claimEntry.setAccumEntryList(ledgerEntryDTOList);
		this.setValidator(ledgerEntryController, validator);
		when(ledgerEntryService.create(ledgerEntryDTOList)).thenReturn(ledgerEntryDTOList);
		List<LedgerEntryDTO> actual = ledgerEntryController.createLedgerEntry(claimEntry);
		Assert.assertEquals(ledgerEntryDTOList, actual);
	}
	
	@Test(expected = ValidationException.class)
	public void testCreateLedgerEntryException() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Validator validator = mock(Validator.class);
		LedgerEntryClaimDTO claimEntry = new LedgerEntryClaimDTO();
		List<LedgerEntryDTO> ledgerEntryDTOList = new ArrayList<>();
		LedgerEntryDTO ledgerEntryDTO = new LedgerEntryDTO();
		ledgerEntryDTOList.add(ledgerEntryDTO);
		claimEntry.setAccumEntryList(ledgerEntryDTOList);
		doThrow(new ValidationException()).when(validator).validate(ledgerEntryDTOList);
		this.setValidator(ledgerEntryController, validator);
		when(ledgerEntryService.create(ledgerEntryDTOList)).thenReturn(ledgerEntryDTOList);
		List<LedgerEntryDTO> actual = ledgerEntryController.createLedgerEntry(claimEntry);
	}

	@Test
	public void getLedgerEntryTest() throws NotFoundException {
		List<LedgerEntryDTO> entryDTOList = new ArrayList<>();
		List<? extends ICommonDTO> dtoList = entryDTOList;
		LedgerEntryDTO entryDTO = new LedgerEntryDTO();
		when(ledgerEntryService.readAll()).thenReturn((List<ICommonDTO>) dtoList);
		List<LedgerEntryDTO> actual = ledgerEntryController.getLedgerEntry();
		Assert.assertEquals(entryDTOList, actual);
 	}
	
	private void setValidator(LedgerEntryController controller, Validator validator) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{		
		Field[] fields = controller.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.getName().equals("validator"))
				field.set(controller, validator);
		}
	}
}
