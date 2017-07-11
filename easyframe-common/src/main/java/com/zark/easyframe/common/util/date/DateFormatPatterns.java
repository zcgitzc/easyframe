package com.zark.easyframe.common.util.date;

public enum DateFormatPatterns {

    /** 日期部分格式（默认）：yyyyMMdd */
    DATE_PATTERN_DEFAULT("yyyyMMdd"),
    /** 日期部分格式：yyyy-MM-dd */
    DATE_PATTERN_YYYYMMDD("yyyy-MM-dd"),
    /** 日期部分格式：yyyy/MM/dd */
    DATE_PATTERN_YYYYMMDD_SPRIT("yyyy/MM/dd"),
    /** 日期部分格式：yyyy年MM月dd日 */
    DATE_PATTERN_YYYYMMDD_CN("yyyy年MM月dd日"),
    /** 日期部分格式：yyMMdd */
    DATE_PATTERN_YYMMDD("yyMMdd"),
    /** 日期格式: yyyyMM */
    DATE_PATTERN_YYYYMM("yyyyMM"),

    /** 日期+时间完整格式（默认）：yyyyMMddHHmmss */
    DATETIME_PATTERN_DEFAULT("yyyyMMddHHmmss"),
    /** 日期+时间完整格式：yyyy-MM-dd HH:mm:ss */
    DATETIME_PATTERN_YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
    /** 日期+时间完整格式：yyyy-MM-ddTHH:mm:ss比如2015-07-10T10:28:28 */
    DATETIME_PATTERN_YYYYMMDDTHHMMSS("yyyy-MM-dd'T'HH:mm:ss"),
    
    /** 日期+时间完整格式：yyyy年MM月dd日 HH时mm分ss秒 */
    DATETIME_PATTERN_YYYYMMDDHHMMSS_CN("yyyy年MM月dd日 HH时mm分ss秒"),
    /** 特殊日期+时间格式1: yyyy-MM-ddHHmmss */
    DATETIME_PATTERN_SPECIAL1("yyyy-MM-ddHHmmss"),
    /** 特殊日期+时间格式1: yyyy-MM-ddHHmmss 2014-03-05-15.09.21.776650 */
    DATETIME_PATTERN_SPECIAL2("yyyy-MM-dd-HH.mm.ss"),

    /** 时间部分格式（默认）：HHmmss */
    TIME_PATTERN_DEFAULT("HHmmss"),
    /** 时间部分格式：HH:mm:ss */
    TIME_PATTERN_HHMMSS("HH:mm:ss"),
    /** 时间部分格式（精确到毫秒）：HHmmssSS */
    TIME_PATTERN_HHMMSSSS("HHmmssSS");

    private String pattern;

    DateFormatPatterns(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}
