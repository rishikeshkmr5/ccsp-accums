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

import com.ccsp.accums.ledger.dto.AccumulationHeaderDTO;
import com.ccsp.accums.ledger.entity.AccumulationHeader;
import com.ccsp.accums.ledger.repository.AccumulationHeaderRepository;
import com.ccsp.accums.mapper.AccumulationHeaderMapper;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationHeaderImplTest {

	@InjectMocks
	private AccumulationHeaderServiceImpl serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private AccumulationHeaderRepository ledgerHeaderRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private AccumulationHeaderMapper ledgerHeaderMapper;
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerHeader() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(AccumulationHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		AccumulationHeader ledgerHeader = new AccumulationHeader();
		AccumulationHeaderDTO AccumulationHeaderDTO = new AccumulationHeaderDTO();
		when(ledgerHeaderMapper.convertToEntity(AccumulationHeaderDTO)).thenReturn(ledgerHeader);
		serviceImpl.create(AccumulationHeaderDTO);
		verify(ledgerHeaderRepository, times(1)).saveAndFlush(ledgerHeader);		
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerHeaders() throws NoSuchFieldException, SecurityException, Exception {
		List<AccumulationHeader> ledgerHeaders = new ArrayList<>();
		ledgerHeaders.add(new AccumulationHeader());
		List<AccumulationHeaderDTO> AccumulationHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderRepository.findAll()).thenReturn(ledgerHeaders);
		when(ledgerHeaderMapper.convertToDTOList(ledgerHeaders)).thenReturn(AccumulationHeaderDTOList);
		setFinalStatic(AccumulationHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		List<AccumulationHeaderDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(AccumulationHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<AccumulationHeader> ledgerHeaders = new ArrayList<>();
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
