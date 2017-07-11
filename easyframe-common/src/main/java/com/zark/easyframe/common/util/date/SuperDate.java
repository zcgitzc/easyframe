package com.zark.easyframe.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.zark.easyframe.common.util.date.DateField.FieldNumber;

/**
 * 一个扩展了Date类型的功能强大的日期时间类，提供了大量日常所需的便捷日期计算方法<br>
 * 在任何使用Date的地方都可以使用该类<br>
 * 依赖的三方库为{@link org.apache.commons.lang.time.DateUtils apache DateUtils}
 * 
 * @author nathan.yuhm
 */
public class SuperDate {

    /**
     * 通过Calendar构造当前时间
     * 
     * @return
     */
    public static Date now() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    /**
     * 通过Calendar构造当前日期(时分秒都是0)
     * 
     * @return
     */
    public static Date nowDateOnly() {
        Calendar cal = Calendar.getInstance();
        return trunc(cal.getTime(), FieldNumber.DATE);
    }

    /**
     * 转换成sql Date
     * 
     * @return
     */
    public static java.sql.Date toSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * 转换成sql Timestamp
     * 
     * @return
     */
    public static java.sql.Timestamp toSqlTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    /**
     * 输出格式化的日期字符串，输出格式为：yyyyMMdd
     * 
     * @return 格式后的日期
     */
    public static String formatAsDateString(Date date) {
        return formatDate(date);
    }

    /**
     * 输出格式化的日期时间字符串，输出格式为：yyyyMMddHHmmss
     * 
     * @return 格式后的日期时间
     */
    public static String formatAsDateTimeString(Date date) {
        return formatDateTime(date);
    }

    /**
     * 输出格式化的时间字符串，输出格式为：HHmmss
     * 
     * @return 格式化后的时间
     */
    public static String formatAsTimeString(Date date) {
        return formatTime(date);
    }

    /**
     * 使用自定义的格式输出相应字符串
     * 
     * @param pattern
     * @return
     */
    public static String formatAsString(Date date, DateFormatPatterns pattern) {
        return format(date, pattern);
    }

    /**
     * 天数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addDays(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * 年数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addYears(Date date, int amount) {
        return DateUtils.addYears(date, amount);
    }

    /**
     * 月数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addMonths(Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    public static int monthsBetween(Date d1, Date d2) {
        return (getYear(d1) * 12 + getMonth(d1)) - (getYear(d2) * 12 + getMonth(d2));
    }

    public static int dayOfYear(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        return testDateCal.get(Calendar.DAY_OF_YEAR);
    }

    public static int getYear(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        return testDateCal.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        return testDateCal.get(Calendar.MONTH);
    }

    /**
     * 周数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * 时数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * 分数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addMinutes(Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * 秒数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * 毫秒数加减操作
     * 
     * @param amount
     * @return
     */
    public static Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date, amount);
    }

    /**
     * 两个日期之间的天数，返回参数 endDate - beginDate 之间的天数
     * 
     * @param date
     * @return 参数 endDate - beginDate 之间的天数
     */
    public static int daysBetween(Date beginDate, Date endDate) {
        long beginTime = trunc(beginDate, FieldNumber.DATE).getTime();
        long endTime = trunc(endDate, FieldNumber.DATE).getTime();
        long betweenDays = (endTime - beginTime) / (1000 * 3600 * 24);

        return (int) betweenDays;
    }

    /**
     * 截断
     * 
     * @param field
     * @return
     */
    public static Date trunc(Date date, FieldNumber field) {
        return DateUtils.truncate(date, field.getValue());
    }

    /**
     * 截取日期到天
     * 
     * @param date
     * @return
     */
    public static Date truncToDate(Date date) {
        return trunc(date, FieldNumber.DATE);
    }

    public static Date round(Date date, FieldNumber field) {
        return DateUtils.round(date, field.getValue());
    }

    /**
     * 月第一天
     * 
     * @return
     */
    public static Date firstDayOfMonth(Date date) {
        return trunc(date, FieldNumber.MONTH);
    }

    /**
     * 月最后一天
     * 
     * @return
     */
    public static Date lastDayOfMonth(Date date) {
        return addDays(firstDayOfMonth(addMonths(date, 1)), -1);
    }

    /**
     * 年第一天
     * 
     * @return
     */
    public static Date firstDayOfYear(Date date) {
        return trunc(date, FieldNumber.YEAR);
    }

    /**
     * 年最后一天
     * 
     * @return
     */
    public static Date lastDayOfYear(Date date) {
        return addDays(firstDayOfYear(addYears(date, 1)), -1);
    }

    public static boolean isNextMonthOf(Date beginDate, Date endDate) {
        return addMonths(trunc(beginDate, FieldNumber.MONTH), -1).equals(trunc(endDate, FieldNumber.MONTH));
    }

    public static boolean isLastMonthOf(Date beginDate, Date endDate) {
        return addMonths(trunc(beginDate, FieldNumber.MONTH), 1).equals(trunc(endDate, FieldNumber.MONTH));
    }

    // ///static function methods below

    /**
     * 输出当前时间格式化的字符串，输出格式为：yyyyMMddHHmmss
     * 
     * @return
     */
    public static String nowDateTimeAsString() {
        return formatAsDateTimeString(now());
    }

    /**
     * 输出当前时间（仅日期部分）格式化的字符串，输出格式为：yyyyMMdd
     * 
     * @return
     */
    public static String nowDateAsString() {
        return formatAsDateString(now());
    }

    /**
     * 输出仅日期部分格式化的字符串，输出格式为：yyyyMMdd
     * 
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, DateFormatPatterns.DATE_PATTERN_DEFAULT);
    }

    /**
     * 输出完整的日期的格式化的字符串，输出格式为：yyyyMMddHHmmss
     * 
     * @return
     */
    public static String formatDateTime(Date date) {
        return format(date, DateFormatPatterns.DATETIME_PATTERN_DEFAULT);
    }

    public static String formatTime(Date date) {
        return format(date, DateFormatPatterns.TIME_PATTERN_DEFAULT);
    }

    public static String format(Date date, DateFormatPatterns pattern) {
        if (date == null || pattern == null) return null;
        SimpleDateFormat dateFromat = new SimpleDateFormat(pattern.getPattern());
        return dateFromat.format(date);
    }

    /**
     * 字符串转日期，输入字符串格式必须为：yyyyMMdd
     * 
     * @param dateValue
     * @return
     */
    public static Date parseDate(String dateValue) {
        if (dateValue.length() != DateFormatPatterns.DATE_PATTERN_DEFAULT.getPattern().length()) {
            throw new IllegalArgumentException(String.format("param format is illegal, format must be %s.",
                                                             DateFormatPatterns.DATE_PATTERN_DEFAULT.getPattern()));
        }
        return parse(dateValue, DateFormatPatterns.DATE_PATTERN_DEFAULT);
    }

    /**
     * 字符串转日期，输入字符串格式必须为：yyyyMMddHHmmss
     * 
     * @param dateValue
     * @return
     */
    public static Date parseDateTime(String dateValue) {
        if (dateValue.length() != DateFormatPatterns.DATETIME_PATTERN_DEFAULT.getPattern().length()) {
            throw new IllegalArgumentException(String.format("param format is illegal, format must be %s.",
                                                             DateFormatPatterns.DATETIME_PATTERN_DEFAULT.getPattern()));
        }
        return parse(dateValue, DateFormatPatterns.DATETIME_PATTERN_DEFAULT);
    }

    public static Date parse(String dateValue, DateFormatPatterns pattern) {
        if (dateValue == null || pattern == null) return null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern.getPattern());
            return dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            return null;
        }
    }

    public static long getTime(DateField dateField) {
        Calendar c = Calendar.getInstance();
        c.set(dateField.getYear(), dateField.getMonth().getValue(), dateField.getDay(), dateField.getHour(),
              dateField.getMinute(), dateField.getSecond());
        return c.getTime().getTime();
    }

    /**
     * 是否是月第一天
     * 
     * @param date
     * @return
     */
    public static boolean isFirstDayOfMonth(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        int dayOfMonth = testDateCal.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth == 1;
    }

    /**
     * 是否是月最后一天
     * 
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Date nextDay = addDays(date, 1);
        return isFirstDayOfMonth(nextDay);
    }

    public static int dayOfMonth(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        return testDateCal.get(Calendar.DAY_OF_MONTH);
    }

    public static int dayOfWeek(Date date) {
        Calendar testDateCal = Calendar.getInstance();
        testDateCal.setTime(date);
        return testDateCal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 判断日期是否是工作日
     * 
     * @param date
     * @return
     * @throws Exception
     */
    public static boolean isWorkingDay(Date date) {
        // 先查这天是周几
        int day = dayOfWeek(date);
        if (day >= Calendar.MONDAY && day <= Calendar.FRIDAY) {
            return true;
        }
        return false;
    }
}
