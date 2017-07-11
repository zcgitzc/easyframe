package com.zark.easyframe.common.util.date;
import java.util.Calendar;

/**
 */
public class DateField {

    private DateField(Builder builder){
        this.year = builder.year;
        this.month = builder.month;
        this.day = builder.day;
        this.hour = builder.hour;
        this.minute = builder.minute;
        this.second = builder.second;
    }

    private final int   year;
    private final Month month;
    private final int   day;
    private final int   hour;
    private final int   minute;
    private final int   second;

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public static class Builder {

        public Builder(int year, Month month, int day){
            super();
            this.year = year;
            this.month = month;
            this.day = day;
        }

        private final int   year;
        private final Month month;
        private final int   day;

        private int         hour   = 0;
        private int         minute = 0;
        private int         second = 0;

        public int getHour() {
            return hour;
        }

        public Builder setHour(int hour) {
            this.hour = hour;
            return this;
        }

        public Builder setMinute(int minute) {
            this.minute = minute;
            return this;
        }

        public Builder setSecond(int second) {
            this.second = second;
            return this;
        }

        public DateField build() {
            return new DateField(this);
        }

    }

    public static enum FieldNumber {
        ERA(Calendar.ERA), YEAR(Calendar.YEAR), MONTH(Calendar.MONTH), WEEK_OF_YEAR(Calendar.WEEK_OF_YEAR),
        WEEK_OF_MONTH(Calendar.WEEK_OF_MONTH), DATE(Calendar.DATE), DAY_OF_MONTH(Calendar.DAY_OF_MONTH),
        DAY_OF_YEAR(Calendar.DAY_OF_YEAR), DAY_OF_WEEK(Calendar.DAY_OF_WEEK),
        DAY_OF_WEEK_IN_MONTH(Calendar.DAY_OF_WEEK_IN_MONTH), AM_PM(Calendar.AM_PM), HOUR(Calendar.HOUR),
        HOUR_OF_DAY(Calendar.HOUR_OF_DAY), MINUTE(Calendar.MINUTE), SECOND(Calendar.SECOND),
        MILLISECOND(Calendar.MILLISECOND), ZONE_OFFSET(Calendar.ZONE_OFFSET), DST_OFFSET(Calendar.DST_OFFSET),
        FIELD_COUNT(17);

        public int getValue() {
            return value;
        }

        private FieldNumber(int value){
            this.value = value;
        }

        private int value;
    }

    public static enum DayOfWeek {
        SUNDAY(Calendar.SUNDAY), MONDAY(Calendar.MONDAY), TUESDAY(Calendar.TUESDAY), WEDNESDAY(Calendar.WEDNESDAY),
        THURSDAY(Calendar.THURSDAY), FRIDAY(Calendar.FRIDAY), SATURDAY(Calendar.SATURDAY);

        public int getValue() {
            return value;
        }

        private DayOfWeek(int value){
            this.value = value;
        }

        private int value;
    }

    public static enum Month {
        JANUARY(Calendar.JANUARY), FEBRUARY(Calendar.FEBRUARY), MARCH(Calendar.MARCH), APRIL(Calendar.APRIL),
        MAY(Calendar.MAY), JUNE(Calendar.JUNE), JULY(Calendar.JULY), AUGUST(Calendar.AUGUST),
        SEPTEMBER(Calendar.SEPTEMBER), OCTOBER(Calendar.OCTOBER), NOVEMBER(Calendar.NOVEMBER),
        DECEMBER(Calendar.DECEMBER);

        public int getValue() {
            return value;
        }

        private Month(int value){
            this.value = value;
        }

        private int value;
    }
}
