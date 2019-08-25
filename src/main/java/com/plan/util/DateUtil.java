package com.plan.util;

import com.plan.exception.SystemException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author linzhihua
 * @Description 工具类-日期处理Util
 * @Date create in 2019/8/25 22:19
 * @Param
 **/

public class DateUtil {
    /**
     * 把字串转换为日期
     *
     * @param sdate  字串形式的日期
     * @param format 字串格式
     * @return 转换为日期类型
     */
    public static Date str2Date(String sdate, String format) {
        try {
            if (sdate == null || sdate != null && sdate.trim().length() == 0)
                return null;
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.parse(sdate);
        } catch (ParseException e) {
            throw new SystemException("字符转日期异常", e, "请检测输入的值是否正确");
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurDateTime() {
        return new Date();
    }

    /**
     * 获取当前时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurDateTimeStr() {
        return date2Str(new Date());
    }

    /**
     * 把时间转换为字串 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 待转换的时间
     * @return
     */
    public static String date2Str(Date date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        return date2Str(date, format);
    }

    /**
     * 把时间转换为字串 格式：yyyy-MM-dd
     *
     * @param date 待转换的时间
     * @return
     */
    public static String date2StrNotTime(Date date) {
        String format = "yyyy-MM-dd";
        return date2Str(date, format);
    }

    /**
     * 把时间转换为字串
     *
     * @param date   待转换的时间
     * @param format 转换格式
     * @return
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 获取当前日期：yyyy-MM-dd
     *
     * @return
     */
    public static Date getCurDate() {
        return str2Date(date2Str(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
    }


    /**
     * 获取当前年月 样式为yyyy-MM
     *
     * @return
     */
    public static String getCurYM() {
        return date2Str(new Date(), "yyyy-MM");
    }

    /**
     * 获取当前年度
     *
     * @return
     */
    public static String getCurYear() {
        return date2Str(new Date(), "yyyy");
    }

    /**
     * 获取当前年月日 样式为yyMMdd
     * @return
     */
    public static String getCurYMD(){
        return date2Str(new Date(),"yyMMdd");
    }
    /**
     * 获取当前年月日 样式为yyyyMMdd
     * @return
     */
    public static String getCurYyyyMD(){
        return date2Str(new Date(),"yyyyMMdd");
    }

    /**
     * 根据增加or减少的时间得到新的日期
     *
     * @param curDate   当前日期
     * @param field     需操作的'年'or'月'or'日'
     * @param addNumber 增加or减少的时间
     * @return
     */
    public static Date dateAdd(Date curDate, int field, int addNumber) {
        GregorianCalendar curGc = new GregorianCalendar();
        curGc.setTime(curDate);
        curGc.add(field, addNumber);
        return curGc.getTime();
    }


    /**
     * 根据增加or减少的天数
     *
     * @param curDate   当前日期
     * @param addNumber 增加or减少的天数
     * @return
     */
    public static Date dateAdd(Date curDate, int addNumber) {
        GregorianCalendar curGc = new GregorianCalendar();
        curGc.setTime(curDate);
        curGc.add(GregorianCalendar.DATE, addNumber);
        return curGc.getTime();
    }


    /**
     * @param date
     * @param addNumber
     * @return
     * @throws Exception
     */
    public static Date monthAdd(Date date, int addNumber) {
        return dateAdd(date, Calendar.MONTH, addNumber);
    }

    /**
     * 得到二个日期间隔
     *
     * @param dateBefore 开始日期
     * @param dateAfter  结束日期
     * @param field      间隔类型 (eg. Calendar.Month Calendar.Year)
     * @param amount     间隔数
     * @return 例：
     * getDateInterval(dateBefore,dateAfter,Calendar.Month,1),返回二个日期之间的月份。
     */
    public static int getDateInterval(Date dateBefore, Date dateAfter,
                                      int field, int amount) {
        int interval = 0;
        Calendar cb = new GregorianCalendar();
        Calendar da = new GregorianCalendar();
        cb.setTime(dateBefore);
        da.setTime(dateAfter);
        da.add(field, 1);
        for (Calendar c = cb; c.before(da); c.add(field, amount)) {
            interval++;
        }
        return interval;
    }

    /**
     * 得到两个日期之前的天数
     *
     * @param beginDate String 开始日期 格式:yyyy-MM-dd
     * @param endDate   String 结束日期 格式:yyyy-MM-dd
     * @return int
     */
    public static int getDateInterval(Date beginDate, Date endDate) {
        return getDateInterval(beginDate, endDate, Calendar.DATE, 1);
    }

    /**
     * 两个日期的间隔月份
     *
     * @param dateBefore
     * @param dateAfter
     * @return
     */
    public static int getMonthInterval(Date dateBefore, Date dateAfter) {
        return getDateInterval(dateBefore, dateAfter, Calendar.MONTH, 1);
    }

    /**
     * 时间查询-开始时间转化YY-MM-DD HH-MM-SS date类型
     *
     * @param startTime
     * @return
     */
    public static Date getStartDateTime(Date startTime) {
        SimpleDateFormat formatterStr = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTimeStr = getStartTime(formatterStr.format(startTime));
        try {
            startTime = formatterDate.parse(startTimeStr);
        } catch (ParseException e) {
            throw new SystemException("时间String转成date类型出错", e, "请联系管理员处理");
        }
        return startTime;
    }

    /**
     * 时间查询-结束时间转化YY-MM-DD HH-MM-SS  date类型
     *
     * @param endTime
     * @return
     */
    public static Date getEndDateTime(Date endTime) {
        SimpleDateFormat formatterStr = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTimeStr = getEndTime(formatterStr.format(endTime));
        try {
            endTime = formatterDate.parse(endTimeStr);
        } catch (ParseException e) {
            throw new SystemException("时间String转成date类型出错", e, "请联系管理员处理");
        }
        return endTime;
    }

    /**
     * 时间查询-开始时间转化YY-MM-DD HH-MM-SS
     *
     * @param startTime
     * @return
     */
    public static String getStartTime(String startTime) {
        StringBuilder startStr = new StringBuilder(startTime);
        startStr.append(" 00:00:00");
        startTime = startStr.toString();
        return startTime;
    }

    /**
     * 时间查询-开始时间转化YY-MM-DD HH-MM-SS  输入date型返回date型
     *
     * @param startTime
     * @return
     */
    public static Date getStartTime(Date startTime) {
        String date2Str = DateUtil.date2Str(startTime, "yyyy-MM-dd");
        String time = DateUtil.getStartTime(date2Str);
        startTime = DateUtil.str2Date(time, "yyyy-MM-dd HH:mm:ss");
        return startTime;
    }

    /**
     * 时间查询-结束时间转化YY-MM-DD HH-MM-SS
     *
     * @param endTime
     * @return
     */
    public static String getEndTime(String endTime) {
        StringBuilder endStr = new StringBuilder(endTime);
        endStr.append(" 23:59:59");
        endTime = endStr.toString();
        return endTime;
    }

    /**
     * 时间查询-结束时间转化YY-MM-DD HH-MM-SS 输入date型返回date型
     *
     * @param endTime
     * @return endTime
     */
    public static Date getEndTime(Date endTime) {
        String date2Str = DateUtil.date2Str(endTime, "yyyy-MM-dd");
        String time = DateUtil.getEndTime(date2Str);
        endTime = DateUtil.str2Date(time, "yyyy-MM-dd HH:mm:ss");
        return endTime;
    }

    /**
     * 比较两个string型的时间
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int comparaDate(String startDate, String endDate) {
        int compara = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDateDate = formatter.parse(startDate);
            Date endDateDate = formatter.parse(endDate);
            compara = endDateDate.compareTo(startDateDate);
        } catch (ParseException e) {
            throw new SystemException("时间String转成date类型出错", e, "请联系管理员处理");
        }

        return compara;
    }

    /**
     * 比较两个date类型的时间
     *
     * @param startDate
     * @param endDate
     * @return startDate>endDate返回-1
     * startDate<endDate返回1
     * startDate=endDate返回0
     */
    public static int comparaDate(Date startDate, Date endDate) {
        int compara = 0;
        if (CommonUtil.isNull(startDate) || CommonUtil.isNull(endDate)) {
            throw new SystemException("比较时间出错", "传入的时间不能为空", "请重新传入要比较的时间");
        } else {
            compara = endDate.compareTo(startDate);
            return compara;
        }
    }

    /**
     * 时间转换：yyyy-MM-dd
     * @param date
     * @return
     */
    public static Date date2DateNotTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String s = sdf.format(date);
            date = sdf.parse(s);
        } catch (ParseException e) {
            throw new SystemException("时间String转成date类型出错", e, "请联系管理员处理");
        }
        return date;
    }
}
