/**
 * 
 */
package com.ccsp.accums.utilization.service;

import org.springframework.stereotype.Component;

import com.ccsp.accums.ledger.header.dto.AccumUtilization;

/**
 * @author rtalapaneni
 *
 */
@Component
public interface IAccumsUpdateService {

	public void updateAccums(AccumUtilization accumUtilization);
}
