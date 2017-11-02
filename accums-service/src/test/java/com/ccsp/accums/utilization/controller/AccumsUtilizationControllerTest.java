package com.ccsp.accums.utilization.controller;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccsp.accums.utilization.dto.AccumsUtilizationDTO;
import com.ccsp.accums.utilization.service.AccumsUtilizationService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccumsUtilizationControllerTest {

	@InjectMocks
	private AccumsUtilizationController controller;
	
	@Mock
	private AccumsUtilizationService utilizationService;
	
	@Test
	public void testFetchAccumsUtilizationByMemberIdAndSubscriberId() throws ParseException {
		String memberId = "A0001";
		String subscriberId = "S0001";
		List<AccumsUtilizationDTO> utilizationHistory = new ArrayList<>();
		AccumsUtilizationDTO utilizationDTO = new AccumsUtilizationDTO();
		utilizationHistory.add(utilizationDTO);
		when(utilizationService.getAccumsUtilization(memberId, subscriberId)).thenReturn(utilizationHistory);
		//Assert.assertEquals();
	}
}
