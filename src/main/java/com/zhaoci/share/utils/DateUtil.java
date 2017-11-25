package com.zhaoci.share.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author fanfuchen
 * @date 2016-1-2
 */
public final class DateUtil {
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";
	
    // Suppress default constructor for noninstantiability
    private DateUtil() {
        throw new AssertionError();
    }

	/**
	 * Format the specified date using the specified format String. The format
	 * String follows the rules specified in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param date
	 *            The date
	 * @param format
	 *            The format String
	 * @return A formatted Date String
	 */
	public static String date2str(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}

	/** 
	 * Parse the specified date String using the specified format String. The
	 * format String follows the rules specified in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param date	The date String
	 * @param format	The format String
	 * @return A Date object
	 * @throws ParseException
	 */ 
	public static Date str2date(String date, String format)
			throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.parse(date);
	}
	
	/**
	 * Format the current date using the specified format String. The
	 * format String follows the rules specified in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param format	The format String
	 * @return A formatted Date String
	 */
	public static String getCurrDate(String format)	{
		return date2str(new Date(), format);
	}
	
	/**
     * Format the specified date to a day of week using the specified format String.
     * 
	 * @author fanfuchen
	 * @date 2016-1-2
     * @param 	date	The date
     * @param 	format 	0：number display；1：text display
     * @return	String	A day of week
     */
    public static String getDayOfWeek(Date date, int format) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	int dayOfWeek = (c.get(Calendar.DAY_OF_WEEK) == 1) ? 7 : c.get(Calendar.DAY_OF_WEEK) - 1;
    	String dayOfWeekStr = null;
    	switch (dayOfWeek) {
    		case 1:
    			dayOfWeekStr = (0 == format) ? "1" : "一";
    			break;
    		case 2:
    			dayOfWeekStr = (0 == format) ? "2" : "二";
    			break;
    		case 3:
    			dayOfWeekStr = (0 == format) ? "3" : "三";
    			break;
    		case 4:
    			dayOfWeekStr = (0 == format) ? "4" : "四";
    			break;
    		case 5:
    			dayOfWeekStr = (0 == format) ? "5" : "五";
    			break;
    		case 6:
    			dayOfWeekStr = (0 == format) ? "6" : "六";
    			break;
    		case 7:
    			dayOfWeekStr = (0 == format) ? "7" : "日";
    			break;
		}
    	return dayOfWeekStr;
    }

	/**
	 * 得到给定日期的前或后n月
     * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param dDay
	 *            日期
	 * @param n
	 *            正为后，负为前
	 * @return	A date object
	 */
	public static Date getPreOrNextMonth(Date dDay, int n) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dDay);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}

	/**
	 * 得到给定日期的前或后n天
     * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param dDay
	 *            日期
	 * @param n
	 *            正为后，负为前
	 * @return	A date object
	 */
	public static Date getPreOrNextDate(Date dDay, int n) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dDay);
		calendar.add(Calendar.DATE, n);
		return calendar.getTime();
	}

	/**
	 * 得到给定日期的前或后n小时
     * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param dDay
	 *            日期
	 * @param n
	 *            正为后，负为前
	 * @return	A date object
	 */
	public static Date getPreOrNextHour(Date dDay, int n) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dDay);
		calendar.add(Calendar.HOUR, n);
		return calendar.getTime();
	}
    
    /**
     * 根据指定日期获取指定日期所在周的开始日期和结束日期(星期一、星期天)
	 * @author fanfuchen
	 * @date 2016-1-2
     * @param 	paramDate	指定日期
     * @return	String[]	开始日期和结束日期数组
     */
    public static String[] getWeekStartAndEndDate(Date paramDate) {
    	String[] retAry = new String[2];

    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(paramDate);
    	//以周一为一周的开始
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		retAry[0] = date2str(calendar.getTime(), DATE_FORMAT);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		retAry[1] = date2str(calendar.getTime(), DATE_FORMAT);
		
		return retAry;
    }

	/**
	 * 根据指定日期获取指定日期所在月的第一天和最后一天
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param	paramDate	指定日期
	 * @return	String[]	第一天和最后一天数组
	 */
	public static String[] getMonthStartAndEndDate(Date paramDate)
	{
		String[] retAry = new String[2];
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(paramDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		retAry[0] = date2str(calendar.getTime(), DATE_FORMAT);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		retAry[1] = date2str(calendar.getTime(), DATE_FORMAT);
		
		return retAry;
	}
	
	/**
	 * 取得两个日期的天数之差
	 * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param 	d1		指定日期1
	 * @param 	d2		指定日期2
	 * @return	int 	两个日期的天数之差
	 * @throws ParseException 
	 */
	public static int getDaysInterval(String d1, String d2) throws ParseException {
		Date date1 = str2date(d1, DATE_FORMAT);
		Date date2 = str2date(d2, DATE_FORMAT);
		
		Long diffTimes = date1.getTime() - date2.getTime();
		Long diffDays = diffTimes / (3600 * 1000 * 24);
		
		return Math.abs(diffDays.intValue());
	}

	/**
	 * 取得两个日期的天数之差
	 * 
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param d1
	 * @param d2
	 * @return long 两个日期的天数之差
	 * @throws ParseException 
	 */
	public static int getDaysInterval(Date d1, Date d2) throws ParseException {
		String date1 = date2str(d1, DATE_FORMAT);
		String date2 = date2str(d2, DATE_FORMAT);
		
		return getDaysInterval(date1,date2);
	}
	
	/**
	 * 获取指定日期相差月份数
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param 	paramDate1	指定日期1
	 * @param 	paramDate2	指定日期2
	 * @return 	int			相差月份数
	 * 注：日期所在月都算一月
	 */
	public static int getDiffMonthsOfTwoDate(String paramDate1, String paramDate2)
	{
		//指定日期1的年份、月份
		int tempYear1 = Integer.parseInt(paramDate1.substring(0, 4));
		int tempMonth1 = Integer.parseInt(paramDate1.substring(5, 7));
		
		//指定日期2的年份、月份
		int tempYear2 = Integer.parseInt(paramDate2.substring(0, 4));
		int tempMonth2 = Integer.parseInt(paramDate2.substring(5, 7));
		
		return Math.abs((tempYear1 * 12 + tempMonth1) - (tempYear2 * 12 + tempMonth2)) + 1;
	}
	
	/**
	 * 获取指定日期所在月有多少天
	 * @author fanfuchen
	 * @date 2016-1-2
	 * @param 	paramDate	指定日期(yyyy-MM格式)
	 * @return	int			指定日期所在月有多少天
	 */
	public static int getDaysOfMonths(String paramDate) {
		int days = 0;
		try {
			Date date = str2date(paramDate,"yyyy-MM");	
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		} catch(Exception e) {
			System.out.println("字符串转换到日期出错");
			throw new RuntimeException();
		}
		return days;
	}
}

