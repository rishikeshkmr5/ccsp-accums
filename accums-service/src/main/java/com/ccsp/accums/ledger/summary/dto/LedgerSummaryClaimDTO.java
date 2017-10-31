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
/**
 * @author nnarayanaperumaln
 *
 */
public class LedgerSummaryClaimDTO implements ICommonDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<LedgerSummaryDTO> accumulationSummaryList;

	/**
	 * @return
	 */
	public List<LedgerSummaryDTO> getAccumulationSummaryList() {
		return accumulationSummaryList;
	}

	/**
	 * @param accumulationSummaryList
	 */
	public void setAccumulationSummaryList(List<LedgerSummaryDTO> accumulationSummaryList) {
		this.accumulationSummaryList = accumulationSummaryList;
	}

	
}
