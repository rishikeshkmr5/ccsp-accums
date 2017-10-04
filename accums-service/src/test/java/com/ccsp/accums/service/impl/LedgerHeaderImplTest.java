package com.ccsp.accums.service.impl;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.ledger.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.entity.LedgerHeader;
import com.ccsp.accums.ledger.repository.LedgerHeaderRepository;
import com.ccsp.accums.mapper.LedgerHeaderMapper;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LedgerHeaderImplTest {

	@InjectMocks
	private AccumsLedgerHeaderServiceImpl serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private LedgerHeaderRepository ledgerHeaderRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private LedgerHeaderMapper ledgerHeaderMapper;
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerHeader() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		LedgerHeader ledgerHeader = new LedgerHeader();
		LedgerHeaderDTO ledgerHeaderDTO = new LedgerHeaderDTO();
		when(ledgerHeaderMapper.convertToEntity(ledgerHeaderDTO)).thenReturn(ledgerHeader);
		serviceImpl.create(ledgerHeaderDTO);
		verify(ledgerHeaderRepository, times(1)).saveAndFlush(ledgerHeader);		
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerHeaders() throws NoSuchFieldException, SecurityException, Exception {
		List<LedgerHeader> ledgerHeaders = new ArrayList<>();
		ledgerHeaders.add(new LedgerHeader());
		List<LedgerHeaderDTO> ledgerHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderRepository.findAll()).thenReturn(ledgerHeaders);
		when(ledgerHeaderMapper.convertToDTOList(ledgerHeaders)).thenReturn(ledgerHeaderDTOList);
		setFinalStatic(LedgerHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		List<LedgerHeaderDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(ledgerHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<LedgerHeader> ledgerHeaders = new ArrayList<>();
		when(ledgerHeaderRepository.findAll()).thenReturn(ledgerHeaders);
		serviceImpl.readAll();
	}
	
	/**
	 * @param field
	 * @param newValue
	 * @throws Exception
	 */
	static void setFinalStatic(Field field, Object newValue) throws Exception {
	    field.setAccessible(true);

	    // remove final modifier from field
	    Field modifiersField = Field.class.getDeclaredField("modifiers");
	    modifiersField.setAccessible(true);
	    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

	    field.set(null, newValue);
	}
}
