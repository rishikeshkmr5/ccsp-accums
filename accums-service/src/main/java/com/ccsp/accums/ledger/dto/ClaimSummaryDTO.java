/**
 * 
 */
package com.ccsp.accums.ledger.dto;

import java.util.List;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author vamehta
 *
 */
public class ClaimSummaryDTO implements ICommonDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<AccumulationSummaryDTO> accumulationSummaryList;

	public List<AccumulationSummaryDTO> getAccumulationSummaryList() {
		return accumulationSummaryList;
	}

	public void setAccumulationSummaryList(List<AccumulationSummaryDTO> accumulationSummaryList) {
		this.accumulationSummaryList = accumulationSummaryList;
	}

	
}
