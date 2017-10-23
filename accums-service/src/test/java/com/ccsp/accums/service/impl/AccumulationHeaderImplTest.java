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

import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.entity.LedgerHeaderEntity;
import com.ccsp.accums.ledger.header.mapper.LedgerHeaderMapper;
import com.ccsp.accums.ledger.header.repository.ILedgerHeaderRepository;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationHeaderImplTest {

	@InjectMocks
	private LedgerHeaderService serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private ILedgerHeaderRepository ledgerHeaderRepository;
	
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
	/*@Test
	public void testSetLedgerHeader() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(LedgerHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		LedgerHeaderEntity ledgerHeader = new LedgerHeaderEntity();
		LedgerHeaderDTO AccumulationHeaderDTO = new LedgerHeaderDTO();
		when(ledgerHeaderMapper.convertToEntity(AccumulationHeaderDTO)).thenReturn(ledgerHeader);
		serviceImpl.create(AccumulationHeaderDTO);
		verify(ledgerHeaderRepository, times(1)).saveAndFlush(ledgerHeader);		
	}*/
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerHeaders() throws NoSuchFieldException, SecurityException, Exception {
		List<LedgerHeaderEntity> ledgerHeaders = new ArrayList<>();
		ledgerHeaders.add(new LedgerHeaderEntity());
		List<LedgerHeaderDTO> AccumulationHeaderDTOList = new ArrayList<>();
		when(ledgerHeaderRepository.findAll()).thenReturn(ledgerHeaders);
		when(ledgerHeaderMapper.convertToDTOList(ledgerHeaders)).thenReturn(AccumulationHeaderDTOList);
		setFinalStatic(LedgerHeaderMapper.class.getField("INSTANCE"), ledgerHeaderMapper);
		List<LedgerHeaderDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(AccumulationHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<LedgerHeaderEntity> ledgerHeaders = new ArrayList<>();
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
