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
	public static final String LEDGER_HEADER = "/ledger-header";
	public static final String LEDGER_ENTRY = "/ledger-entry";
	public static final String ACCUMS_ENTRY_PERIOD = "/accumsentryperiod";
	public static final String LEDGER_HEADER_CSV = "/ledger-header-csv-file";
	
	/**
	 * Accumulation Summary URI
	 */
	public static final String LEDGER_SUMMARY = "/ledger-summary";
	
	public static final String LEDGER_SUMMARY_UPDATE = "/ledger-summary/{memberId}";
	
	/**
	 * Accums Inquiry API
	 */
	public static final String BENEFIT_BALANCE = "/benefitbalance";
	public static final String CLAIIMS_ASSOCIATED_TO_ACCUMS = "/claimsRelatedToAccums/{accumType}";
	public static final String BENEFIT_SPENDING = "/benefitspending";
	public static final String ACCUMS_UTILIZATION = "/accums-utilization";
}
