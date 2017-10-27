package com.ccsp.accums.service.impl;


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

import com.ccsp.accums.ledger.benefit.dto.BenefitBalanceDTO;
import com.ccsp.accums.ledger.benefit.mapper.BenefitBalanceMapper;
import com.ccsp.accums.ledger.benefit.repository.BenefitBalanceRepository;
import com.ccsp.accums.ledger.benefit.service.BenefitBalanceServiceImpl;
import com.ccsp.accums.ledger.summary.entity.LedgerSummaryEntity;

import javassist.NotFoundException;

/**
 * @author Vaibhav
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BenefitBalanceImplTest {

	@InjectMocks
	private BenefitBalanceServiceImpl serviceImpl;
	
	/**
	 * Mock the repository
	 */
	@Mock
	private BenefitBalanceRepository benefitBalanceRepository;
	
	/**
	 * Mock the Mapper
	 */
	@Mock
	private BenefitBalanceMapper benefitBalanceMapper;
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetBenefitBalanceByMemberId() throws NoSuchFieldException, SecurityException, Exception {
		String subscriberID=null;
		String memberID="str";
		List<BenefitBalanceDTO> balanceDTOs= new ArrayList<>();
		List<LedgerSummaryEntity> accumulationSummaryList = new ArrayList<>();
		accumulationSummaryList.add(new LedgerSummaryEntity());
		when(benefitBalanceRepository.findBymemberIdentifier(memberID)).thenReturn(accumulationSummaryList);
		when(benefitBalanceMapper.convertToDTOList(accumulationSummaryList)).thenReturn(balanceDTOs);
		setFinalStatic(BenefitBalanceMapper.class.getField("INSTANCE"), benefitBalanceMapper);
		List<BenefitBalanceDTO> actual = serviceImpl.getBenefitBalance(subscriberID, memberID);
		Assert.assertEquals(balanceDTOs, actual);
	}
	
	/**
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testGetBenefitBalanceBySubscriberId() throws NoSuchFieldException, SecurityException, Exception {
		String subscriberID="str";
		String memberID=null;
		List<BenefitBalanceDTO> balanceDTOs= new ArrayList<>();
		List<LedgerSummaryEntity> accumulationSummaryList = new ArrayList<>();
		accumulationSummaryList.add(new LedgerSummaryEntity());
		when(benefitBalanceRepository.findBysubscriberId(subscriberID)).thenReturn(accumulationSummaryList);
		when(benefitBalanceMapper.convertToDTOList(accumulationSummaryList)).thenReturn(balanceDTOs);
		setFinalStatic(BenefitBalanceMapper.class.getField("INSTANCE"), benefitBalanceMapper);
		List<BenefitBalanceDTO> actual = serviceImpl.getBenefitBalance(subscriberID, memberID);
		Assert.assertEquals(balanceDTOs, actual);
	}
	
	
	/**
	 * @throws NotFoundException
	 */
	@Test(expected = NotFoundException.class)
	public void testGetAllLedgerHeadersThrowsException() throws NotFoundException
	{
		List<LedgerSummaryEntity> accumulationSummary = new ArrayList<>();
		when(benefitBalanceRepository.findAll()).thenReturn(accumulationSummary);
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
