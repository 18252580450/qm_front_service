package com.asiainfo.qm.manage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * create by ld on 2018-08-28 14:38
 */
public class DateUtils {

    private final static String dateFormat = "yyyy-MM-dd";
    public static final String DATE_FORMAT_A_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss"; //默认日期时间模式

    /**
     * 按照指定格式返回格式好的当前日期
     *
     * @param dateFormat 默认yyyy-MM-dd
     * @return
     */
    public static String getCurrentDateString(String dateFormat) {

        return DateUtils.format(new Date(), dateFormat);
    }

    /**
     * 说明 将日期格式化字符串，为null的返回空字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        if (null == date) return "";
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        return sf.format(date);
    }

    /**
     * 说明 将日期格式化字符串，为null的返回空字符串
     *
     * @param date       日期
     * @param dateFormat 格式化字符串，比如：yyyy-MM-dd
     * @return
     */
    public static String format(Date date, String dateFormat) {
        if (null == dateFormat || "".equals(dateFormat)) return DateUtils.format(date);
        if (null == date) return "";
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        return sf.format(date);
    }

    /**
     * @param source 要进行解析的源字符串
     * @return
     * @说明 将指定的字符串格解析成日期类型，格式默认为：yyyy-MM-dd
     */
    public static Date parase(String source) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        try {
            return sf.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return null;
    }

    /**
     * @param source     要进行解析的源字符串
     * @param dateFormat 要解析的日期格式。
     * @return
     * @说明 将指定的字符串格解析成日期类型 例：如果日期source=20131210,则dateFormat应为：yyyyMMdd,两个应对应
     */
    public static Date parase(String source, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        try {
            return sf.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return null;
    }

    /**
     * @param date
     * @param days
     * @说明 对指定的日期增加或减少指定的天数
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }

    /**
     * @param date
     * @param days
     * @说明 对指定的日期增加或减少指定的天数
     */
    public static Calendar addDays(Calendar date, int days) {

        date.add(Calendar.DAY_OF_MONTH, days);

        return date;
    }

    /**
     * @param date
     * @param months
     * @return
     * @说明 对指定的日期增加或减少指定的月数
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.MONTH, months);

        return cal.getTime();
    }

    /**
     * @param date
     * @param months
     * @return
     * @说明 对指定的日期增加或减少指定的月数
     */
    public static Calendar addMonths(Calendar date, int months) {
        date.add(Calendar.MONTH, months);

        return date;
    }

    /**
     * @param date
     * @param hours
     * @return
     * @说明 对指定的日期增加或减少指定的小时数
     */
    public static Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.HOUR_OF_DAY, hours);

        return cal.getTime();
    }

    /**
     * @param date
     * @param hours
     * @return
     * @说明 对指定的日期增加或减少指定的小时数
     */
    public static Calendar addHours(Calendar date, int hours) {
        date.add(Calendar.HOUR_OF_DAY, hours);
        return date;
    }

    /**
     * @return
     * @说明 以字符串形式返回当前时间的毫秒数
     */
    public static String getTimeMillions() {
        Calendar cal = Calendar.getInstance();
        long lt = cal.getTimeInMillis();

        return String.valueOf(lt);
    }

    /**
     * 获取当前月的第一天
     *
     * @return 当前月的第一天
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        return str.toString();

    }

    /**
     * 获取当前月的最后一天
     *
     * @return 当前月的最后一天
     */
    public static String getMonthLastDay() {

        Calendar calendar = Calendar.getInstance();
        // 最后一天
        int maxday = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, maxday);

        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        StringBuffer str = new StringBuffer().append(s);
        return str.toString();

    }

    /**
     * 获取当前月的第一天，精确到时分秒
     *
     * @return 当前月的第一天，精确到时分秒
     */
    public static Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        return date;

    }

    /**
     * 获得往数据库字段类型为Date型时，插入的时间
     *
     * @param date       默认为当前日期，如果为空时 方法会自动new Date()
     * @param dateFormat 默认为yyyy-MM-dd
     * @return
     */
    public static java.sql.Date paraseSqlDate(String date, String dateFormat) {
        try {
            if (date == null || date.length() == 0) {
                return new java.sql.Date(new Date().getTime());
            } else {
                if (dateFormat == null) dateFormat = DateUtils.dateFormat;
                SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
                Date d = sf.parse(date);
                return new java.sql.Date(d.getTime());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    /**
     * 获得往数据库字段类型为Date型时，插入的时间
     *
     * @param date       默认为当前日期，如果为空时 方法会自动new Date()
     * @param dateFormat 默认为yyyy-MM-dd
     * @return
     */
    public static java.sql.Timestamp paraseSqlTimestamp(String date, String dateFormat) {
        try {
            if (date == null || date.length() == 0) {
                return new java.sql.Timestamp(new Date().getTime());
            } else {
                if (dateFormat == null) dateFormat = DateUtils.dateFormat;
                SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
                Date d = sf.parse(date);
                System.out.println(new java.sql.Timestamp(d.getTime()));
                return new java.sql.Timestamp(d.getTime());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    /**
     * 获取当前的年份
     * @return
     */
    public static String getCurrentYear(){
        Calendar now = Calendar.getInstance();
        return String.valueOf(now.get(Calendar.YEAR));
    }

    /**
     * 获取当前的年月
     * @return
     */
    public static String getCurrentYearMonth(){
        return getCurrentYear()+getCurrentMonth();
    }

    /**
     * 获取当前的月份
     * @return
     */
    public static String getCurrentMonth(){
        Calendar now = Calendar.getInstance();
        return String.valueOf(now.get(Calendar.MONTH) + 1);
    }

    public static void main(String[] args) {
        String ss = getCurrentDateString("YYYY-MM-DD");
        System.out.println(ss);
    }
}
