package com.cs.cs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Samuel on 2015/3/6.
 */
/**
 * 统计的一些公用变量 和方法
 * Created by wcong on 14-5-8.
 */
public class CalculateUtil {
    private static final Logger logger = LoggerFactory
            .getLogger(CalculateUtil.class);

    // 多个字段链接的符号
    public static String keyJoin = "_";

    public static List<String> monthsOfYearList = new LinkedList<>();

    /**
     * remember
     * Calendar  set  HOUR_OF_DAY
     *
     * @param date
     * @return
     */
    public static List<Integer> makeTimeStampByDate(Date date) {
        List<Integer> timeStampList = new LinkedList<>();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(date);
        startDate.set(Calendar.HOUR_OF_DAY, 0);
        startDate.set(Calendar.MINUTE, 0);
        startDate.set(Calendar.SECOND, 0);
        timeStampList.add((int) (startDate.getTimeInMillis() / 1000));
        endDate.setTime(date);
        endDate.set(Calendar.HOUR_OF_DAY, 23);
        endDate.set(Calendar.MINUTE, 59);
        endDate.set(Calendar.SECOND, 59);
        timeStampList.add((int) (endDate.getTimeInMillis() / 1000));
        return timeStampList;
    }

    public static List<Date> makeDateListByDate(Date date) {
        List<Date> dateList = new LinkedList<>();
        Calendar middleDate = Calendar.getInstance();
        middleDate.setTime(date);
        Calendar lastDate = (Calendar) middleDate.clone();
        lastDate.add(Calendar.DATE, -1);
        dateList.add(lastDate.getTime());
        Calendar nextDate = (Calendar) middleDate.clone();
        nextDate.add(Calendar.DATE, +1);
        dateList.add(nextDate.getTime());
        return dateList;
    }

    /**
     * must set  Calendar.MILLISECOND
     * get the dawn date of
     * input date and last day  of it
     *
     * @param date
     * @return
     */
    public static List<Date> makeDawnDateList(Date date) {
        List<Date> dateList = new LinkedList<>();
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        Calendar lastDay = Calendar.getInstance();
        lastDay.setTime(now.getTime());
        lastDay.add(Calendar.DATE, -1);
        dateList.add(lastDay.getTime());
        dateList.add(now.getTime());
        return dateList;
    }

    /**
     * 取得日期黎明的时间
     *
     * @param date
     * @return
     */
    public static Date makeDawnOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 取得最早下单时间到当前时间(不包括当月)之间每个月的时间戳
     * *
     */
    public static HashMap<String, List<Integer>> makeMonthsTimeStampBeforeDate(Integer firstTimeStamp, Date date) {

        HashMap<String, List<Integer>> monthTimeStampMap = new HashMap<>();
        Date firstDate = new Date(Integer.valueOf(firstTimeStamp).longValue() * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date dateIndex = calendar.getTime();
        monthsOfYearList.clear();
        while (dateIndex.getTime() >= firstDate.getTime()) {
            List<Integer> monthTimeStampList = makeXMonthTimeStampByDate(dateIndex);
            calendar.setTime(dateIndex);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            String monthOfYear = "" + year + "-" + month;
            monthsOfYearList.add(monthOfYear);
            monthTimeStampMap.put(monthOfYear, monthTimeStampList);

            calendar.add(Calendar.MONTH, -1);
            dateIndex = calendar.getTime();
        }
        return monthTimeStampMap;

    }

    /**
     * 取得X月一号到最后一天的时间戳
     * *
     */
    public static List<Integer> makeXMonthTimeStampByDate(Date date) {
        List<Integer> timeList = new LinkedList<>();
        timeList.add(makeFirstDayOfMonthTime(date));
        timeList.add(makeLastDayOfMonthTime(date));
        return timeList;
    }

    /**
     * 取得日期 上个月的一号到最后一天的时间戳
     *
     * @param date
     * @return
     */
    public static List<Integer> makeLastMonthTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date lastMonthDate = calendar.getTime();
        List<Integer> timeList = new LinkedList<>();
        timeList.add(makeFirstDayOfMonthTime(lastMonthDate));
        timeList.add(makeLastDayOfMonthTime(lastMonthDate));
        return timeList;
    }

    /**
     * 取得日期 上个月的一号到最后一天的时间戳
     *
     * @param date
     * @return
     */
    public static List<Integer> makeOtherLastMonthTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -2);
        Date lastMonthDate = calendar.getTime();
        List<Integer> timeList = new LinkedList<>();
        timeList.add(makeFirstDayOfMonthTime(lastMonthDate));
        timeList.add(makeLastDayOfMonthTime(lastMonthDate));
        return timeList;
    }

    /**
     * 取得当前日期的 本月1号的零点的日期
     *
     * @param date
     * @return
     */
    public static Integer makeFirstDayOfMonthTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        makeDawnOfCalender(calendar);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    /**
     *
     */
    public static Integer makeLastDayOfMonthTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        makeMidNightOfCalender(calendar);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    /**
     * 取得上周的时间戳
     *
     * @param date
     * @return
     */
    public static List<Integer> makeLastWeekTime(Date date) {
        List<Integer> timeList = new LinkedList<Integer>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date lastWeekDate = calendar.getTime();
        timeList.add(makeFirstDayOfCurrentWeekTime(lastWeekDate));
        timeList.add(makeLastDayOfCurrentWeekTime(lastWeekDate));
        return timeList;
    }

    /**
     * 取得当前日期的本周周一零点的时间
     *
     * @param date 当前日期
     * @return 本周周一零点的时间
     */
    public static Integer makeFirstDayOfCurrentWeekTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        makeDawnOfCalender(calendar);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    /**
     * 取得当前日期的本周周日零点的时间
     *
     * @param date 当前日期
     * @return 本周周日零点的时间
     */
    public static Integer makeLastDayOfCurrentWeekTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        makeMidNightOfCalender(calendar);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    /**
     * 设定 calender 零点时间
     *
     * @param calendar
     */
    public static void makeDawnOfCalender(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static void makeMidNightOfCalender(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    /**
     * 获取当前时间本月第一天起点的时间戳
     */
    public static Calendar getThisMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 获取当前时间前一个月第一天起点的时间戳
     */
    public static Calendar getLastMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 获取当前时间前二个月第一天起点的时间戳
     */
    public static Calendar getLastTwoMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 获取当前时间前一天晚上12点的时间戳
     */
    public static Calendar getYesterdayNight(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }


    /**
     * 获取指定date的时间戳
     */

    public static Integer makeCurrentTimeStamp(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int timeStamp = ((int) (calendar.getTimeInMillis() / 1000));
        return timeStamp;

    }

    public static String makeUpName(String name) {
        if (name.length() < 2) {
            return name;
        } else {
            return name.substring(0, 1) + "***" + name.substring(name.length() - 1, name.length());
        }
    }

    public static int reduceDate(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static int reduceTime(Integer startTime, Integer endTime) {
        return  (endTime - startTime) / ( 60 * 60 * 24);
    }

    public static int getPackageUnit(int conversionValue,String packageFormat){
        try {
            if (packageFormat.contains("/")) {
                String[] packageFormatStr = packageFormat.split("/");
                if (getFirstNumberFromStr(packageFormatStr[0]) != 0) {
                    conversionValue = getFirstNumberFromStr(packageFormatStr[0]);
                }
            }
            if (packageFormat.contains("*")) {
                String[] packageFormatStr = packageFormat.split("\\*");
                if (getFirstNumberFromStr(packageFormatStr[0]) != 0) {
                    conversionValue = getFirstNumberFromStr(packageFormatStr[0]);
                }
            }
        }catch(Exception e){
            logger.error("getPackageUnit error :",e);
        }
        return conversionValue;
    }

    public static Integer getFirstNumberFromStr(String str){
        int start = 0;
        int end = 0;
        boolean hasNumber =false;
        int firstNum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hasNumber){
                if(Character.isDigit(ch)){
                    start = i;
                    hasNumber =true;
                }
            }
            if(hasNumber){
                if(!Character.isDigit(ch)){
                    end = i;
                    break;
                }else{
                    end = i+1;
                }
            }
        }
        String number = str.substring(start,end);
        try {
            firstNum = Integer.parseInt(number);
        }catch (Exception e){
            firstNum = 0;
        }
        return  firstNum;
    }
}