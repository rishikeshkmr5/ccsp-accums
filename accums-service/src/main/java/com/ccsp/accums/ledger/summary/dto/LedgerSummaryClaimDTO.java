/**
 * 
 */
package com.ccsp.accums.ledger.summary.dto;

import java.util.List;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author vamehta
 *
 */
public class LedgerSummaryClaimDTO implements ICommonDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<LedgerSummaryDTO> accumulationSummaryList;

	public List<LedgerSummaryDTO> getAccumulationSummaryList() {
		return accumulationSummaryList;
	}

	public void setAccumulationSummaryList(List<LedgerSummaryDTO> accumulationSummaryList) {
		this.accumulationSummaryList = accumulationSummaryList;
	}

	
}
