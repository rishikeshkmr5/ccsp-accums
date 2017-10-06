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

import com.ccsp.accums.ledger.dto.AccumulationSummaryDTO;
import com.ccsp.accums.ledger.entity.AccumulationSummary;
import com.ccsp.accums.ledger.repository.AccumulationSummaryRepository;
import com.ccsp.accums.mapper.AccumulationSummaryMapper;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccumulationSummaryImplTest {

	@InjectMocks
	private AccumulationSummaryServiceImpl serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private AccumulationSummaryRepository accumulationSummaryRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private AccumulationSummaryMapper accumulationSummaryMapper;
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testSetLedgerHeader() throws NoSuchFieldException, SecurityException, Exception {
		setFinalStatic(AccumulationSummaryMapper.class.getField("INSTANCE"), accumulationSummaryMapper);
		AccumulationSummary accumulationSummary = new AccumulationSummary();
		AccumulationSummaryDTO accumulationSummaryDTO = new AccumulationSummaryDTO();
		when(accumulationSummaryMapper.convertToEntity(accumulationSummaryDTO)).thenReturn(accumulationSummary);
		serviceImpl.create(accumulationSummaryDTO);
		verify(accumulationSummaryRepository, times(1)).saveAndFlush(accumulationSummary);		
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetAllLedgerHeaders() throws NoSuchFieldException, SecurityException, Exception {
		List<AccumulationSummary> accumulationSummaries = new ArrayList<>();
		accumulationSummaries.add(new AccumulationSummary());
		List<AccumulationSummaryDTO> AccumulationHeaderDTOList = new ArrayList<>();
		when(accumulationSummaryRepository.findAll()).thenReturn(accumulationSummaries);
		when(accumulationSummaryMapper.convertToDTOList(accumulationSummaries)).thenReturn(AccumulationHeaderDTOList);
		setFinalStatic(AccumulationSummaryMapper.class.getField("INSTANCE"), accumulationSummaryMapper);
		List<AccumulationSummaryDTO> actual = serviceImpl.readAll();
		Assert.assertEquals(AccumulationHeaderDTOList, actual);
	}
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<AccumulationSummary> accumulationSummaries = new ArrayList<>();
		when(accumulationSummaryRepository.findAll()).thenReturn(accumulationSummaries);
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
