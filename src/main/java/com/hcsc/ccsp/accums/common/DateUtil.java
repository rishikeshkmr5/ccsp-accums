package com.hcsc.ccsp.accums.common;

public class DateUtil {
	
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;
    }

}
