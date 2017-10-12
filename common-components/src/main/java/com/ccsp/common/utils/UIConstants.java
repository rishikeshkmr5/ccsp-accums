package com.ccsp.common.utils;

/**
 * @author nnarayanaperumaln
 *
 */
public class UIConstants {


	/**
	 * Private constructor to prevent object creation
	 */
	private UIConstants()
	{
		//Do nothing
	}
	/**
	 * LEDGER HEADER URI
	 */
	public static final String LEDGER_HEADER = "/ledgerheader";
	public static final String ACCUMS_ENTRY = "/accumsentry";
	public static final String ACCUMS_ENTRY_PERIOD = "/accumsentryperiod";
	
	/**
	 * Accumulation Summary URI
	 */
	public static final String ACCUMULATION_SUMMARY = "/accumulationsummary";
	
	/**
	 * Accums Inquiry API
	 */
	public static final String BENEFIT_BALANCE = "/benefitbalance";
	public static final String CLAIIMS_ASSOCIATED_TO_ACCUMS = "/claimsRelatedToAccums/{accumType}";
		
}
