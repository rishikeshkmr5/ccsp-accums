package com.ccsp.common.utils;

/**
 * @author nnarayanaperumaln
 *
 */
/**
 * @author vamehta
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
	public static final String LEDGER_HEADER = "/accums-utilization";
	public static final String LEDGER_ENTRY = "/ledger-entry";
	public static final String ACCUMS_ENTRY_PERIOD = "/accumsentryperiod";
	public static final String LEDGER_HEADER_CSV = "/accums-utilization-csv";
	
	/**
	 * Accumulation Summary URI
	 */
	public static final String LEDGER_SUMMARY = "/ledger-summary";
	
	public static final String LEDGER_SUMMARY_UPDATE = "/ledger-summary/{memberId}";
	
	/**
	 * Accums Inquiry API
	 */
	public static final String ACCUMS_INQUIRY = "/inquiry";
	public static final String BENEFIT_BALANCE = "/member-accumtype-summary";
	public static final String CLAIIMS_ASSOCIATED_TO_ACCUMS = "/claimsRelatedToAccums/{accumType}";
	public static final String BENEFIT_SPENDING = "/benefitspending";
	public static final String ACCUMS_UTILIZATION = "/member-spending-summary";
	public static final String ACCUMS_CONSUMPTION = "/member-accumtype-specific-claims";
	public static final String CLAIM_DETAIL = "/member-claim-detail";	
	
	/**
	 * Claim Rules
	 */
	public static final String CLAIM = "/claimRules";
	
	/**
	* Swagger UI constants
	*/
	public static final String API_LEDGER_HEADER_DES="Load Accums";
	public static final String API_LEDGER_HEADER_TAG="Accums Utilization";
	public static final String API_LEDGER_HEADER_CREATE="Load Accums";
	public static final String API_LEDGER_HEADER_CREATE_CSV="Load Accums with CSV";
	
	public static final String API_ACCUMS_UTILIZATION_DES="Inquire Accums";
	public static final String API_ACCUMS_UTILIZATION_TAG="Inquiry Utilization";
	public static final String API_ACCUMS_UTILIZATION_SPENDING_SUM="Inquire services summary specific to member";
	public static final String API_ACCUMS_UTILIZATION_BENEFIT_BAL="Inquire accum-type summary specific to member";
	public static final String API_ACCUMS_UTILIZATION_CONSUMPTION="Inquire claims specific to member and accum-type";
	public static final String API_MEMBER_CLAIMS ="Inquire claims summary specific to member";
	
	/**
	 * Category API constants
	 */
	public static final String API_CATEGORY_TYPE_DES="Load/Inquire Category";
	public static final String API_CATEGORY_TYPE_TAG="Category Type";
	public static final String API_CATEGORY_TYPE_CREATE_CSV="Load Categories with CSV";
	public static final String API_CATEGORY_TYPE_INQUIRE="Inquiry Categories";
	public static final String CATEGORY_TYPE_CSV = "/category-type-csv";
	public static final String CATEGORY = "/category/{category-Type}";
	
	
}
