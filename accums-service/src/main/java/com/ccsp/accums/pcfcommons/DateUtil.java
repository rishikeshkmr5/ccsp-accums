package com.ccsp.accums.pcfcommons;

public class DateUtil {
	
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;
    }

}
