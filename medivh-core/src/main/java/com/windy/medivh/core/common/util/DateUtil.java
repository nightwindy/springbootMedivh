package com.windy.medivh.core.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Slf4j
public class DateUtil {

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";


    /**
     * 取得给定字符串描述的日期对象，描述模式采用pattern指定的格式.
     *
     * @param dateStr 日期描述
     * @param pattern 日期模式
     * @return 给定字符串描述的日期对象。
     */
    public static Date getDateFromString(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        Date resDate = null;
        try {
            resDate = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resDate;
    }


    /**
     * 取得给定字符串描述的日期对象，描述模式采用pattern指定的格式.
     *
     * @param dateStr 日期描述
     * @return 给定字符串描述的日期对象。
     */
    public static Date getDateFromYMD(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE, Locale.getDefault());
        Date resDate = null;
        try {
            resDate = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resDate;
    }

    public static Date getStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getDateFromString(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME, Locale.getDefault());
        Date resDate = null;
        try {
            resDate = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resDate;
    }

    public static String getFormatDate(Date date) {
        return getFormatDate(date, FORMAT_DATETIME);
    }

    public static String getFormatDateYMD(Date date) {
        return getFormatDate(date, FORMAT_DATE);
    }

    public static String getFormatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    /**
     * 获取当前时间
     */
    public static Long getCurrentTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    /**
     * 获取某天开始的时间
     *
     * @param duration 距离今天的天数
     */
    public static Date getDayStart(int duration) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, duration);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天结束的时间
     *
     * @param duration 距离今天的天数
     */
    public static Date getDayEnd(int duration) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, duration);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static String toISODate(Date date) {
        try {
            return DateFormatUtils.ISO_DATETIME_FORMAT.format(date);
        } catch (Exception e) {
            log.error("时间解析失败,失败原因", e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @return 相差天数
     */
    public static int daysBetween(Date startDate, Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startDay = cal.get(Calendar.DAY_OF_YEAR);
        cal.setTime(endDate);
        int endDay = cal.get(Calendar.DAY_OF_YEAR);
        return Math.abs(startDay - endDay) + 1;
    }

    /**
     * 指定天数+天
     */
    public static Date addDays(Date date, int day) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }


    /**
     * 获取该日期的年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取该日期的月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取该日期的日
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据时间获取日期
     */
    public static Date getDate(Long time){
        return time==null?null:new Date(time);
    }

    public static void main(String[] args){
        System.out.println(getFormatDate(getDate(1521302400000L)));
    }

}
