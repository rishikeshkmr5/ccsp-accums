/**
 * 
 */
package com.ccsp.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author nnarayanaperumaln
 * Utility for all Date functionality
 */
public class DateUtils {

	/**
	 * Default DATE format
	 */
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * Converts the String to Date in the declared format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date format(String date) throws ParseException {
		//converts the String to Date and in the FORMAT declared
		return FORMAT.parse(date);
	}
	
	/**
	 * Returns start day of the year.
	 * @return
	 */
	public static Date getYearStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * Returns start day of the year.
	 * @return
	 */
	public static Date getYearEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 31);
		return calendar.getTime();
	}
}
