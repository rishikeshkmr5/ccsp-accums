/**
 * 
 */
package com.ccsp.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nnarayanaperumaln
 *
 */
public class DateUtils {

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	
	public static Date format(String date) throws ParseException {
		return FORMAT.parse(date);
	}
}
