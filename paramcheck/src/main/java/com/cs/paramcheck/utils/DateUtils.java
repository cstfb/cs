package com.cs.paramcheck.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author yu.xiang
 *
 * 2014年11月19日
 */
public class DateUtils {

    static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date stringToDate(String dateStr){
        Date date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=formatter.parse(dateStr);
        } catch (ParseException e) {
            logger.error("parse error," + (null==dateStr?"null":dateStr),e);
        }
        return date;
    }

    public static Date long2Date(long millis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millis);
        return c.getTime();
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMDHMS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "hh"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToHH(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("HH");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMDHM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return f.format(date);
    }

    public static String convertDateByFormat(Date date, String format) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat f = new SimpleDateFormat(format);
            return f.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date convertStringToDateByFormat(String str, String format) {
        try {
            SimpleDateFormat f = new SimpleDateFormat(format);
            return f.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToSimpleYMDHMS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyyMMdd"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToSimpleYMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        return f.format(date);
    }


    /**
     * 把时间类型转化为规定格式的字符串
     * "MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToMM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("MM");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "MM-dd hh:MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("MM-dd");
        return f.format(date);
    }

    public static String convertDateToTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        return f.format(date);
    }

    public static Date convertStringToDate(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败",e);
        }
        return null;
    }

    public static Date convertDateToDateYMD(Date date) {
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fi = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fo.parse(fi.format(date));
        } catch (ParseException e) {
            logger.error("转化为时间失败",e);
        }
        return null;
    }

    public static Date convertStringToDateYMD(String dateStr) {
        if(StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败",e);
        }
        return null;
    }

    public static Date convertStringToDateMDY(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败",e);
        }
        return null;
    }

    public static Date convertStringToTime(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败",e);
        }
        return null;
    }

    /**
     * 获取Calendar的日期
     * "yyyy-MM-dd"
     *
     * @param cal 时间
     * @return 格式化以后的时间字符串
     */
    public static String getDate(Calendar cal) {
        String v_strDate = "";
        int v_intYear = cal.get(Calendar.YEAR);
        int v_intMonth = cal.get(Calendar.MONTH) + 1;
        int v_intDAY = cal.get(Calendar.DAY_OF_MONTH);

        v_strDate = v_strDate + v_intYear + "-";

        if (v_intMonth < 10) {
            v_strDate = v_strDate + "0" + v_intMonth + "-";
        }else {
            v_strDate = v_strDate + v_intMonth + "-";
        }
        if (v_intDAY < 10) {
            v_strDate = v_strDate + "0" + v_intDAY + "";
        }else {
            v_strDate = v_strDate + v_intDAY + "";
        }

        return v_strDate;
    }

    /**
     * 转换时间戳返回Date型
     */
    public static Date timeStamp2Date(Long timestamp){
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        Date date = convertStringToDate(dateStr);
        return date;
    }


    public static String addDate(Date date,int days){
        SimpleDateFormat sf  =new SimpleDateFormat("yyyyMMdd");
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DAY_OF_YEAR,days);
        return sf.format(gc.getTime());
    }

    public static String addDate(Date date,int days,String format){
        SimpleDateFormat sf  =new SimpleDateFormat(format);
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DAY_OF_YEAR,days);
        return sf.format(gc.getTime());
    }

    public static Date getSomeDayDate(Date date,int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(GregorianCalendar.DAY_OF_YEAR,days);
        return cal.getTime();
    }

    public static Date addMonth(Date date,int month){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        //        rightNow.add(Calendar.YEAR,-1);//日期减1年
        rightNow.add(Calendar.MONTH,month);//日期加3个月
        //        rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
        Date dt1=rightNow.getTime();
        return  dt1;
    }

    public static Date addDay(Date date, int day) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR , day);
        return rightNow.getTime();
    }

    /**获取两个时间间隔*/
    public static String getDiffDays(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            java.util.Date date = myFormatter.parse(sj1);
            java.util.Date mydate = myFormatter.parse(sj2);

            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            return "";
        }

        return day+"";
    }

    /**获取两个时间间隔*/
    public static String getDiffDays(Date beginDate, Date endDate) {
        long day = 0;
        try {
            day = (beginDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }

        return day+"";
    }

    /**
     * 获取两个时间间隔的小时数
     * @param after
     * @param before
     * @return
     */
    public static Integer getDiffHours(Date after, Date before) {
        long hours = (after.getTime() - before.getTime()) / (60 * 60 * 1000);
        return (int)hours;
    }

    /**
     * 获取两个时间间隔的秒数
     */
    public static Integer getDiffSecs(Date after, Date before) {
        long secs = (after.getTime() - before.getTime()) / (1000);
        return (int)secs;
    }

    /**
     * 检查日期字符串是否合法
     * @param str 任意字符串， 当符合格式为yyyy-mm-dd时为合法字符串
     * @return false 不合法， 表示字符串不是yyyy-mm-dd的有效格式
     *          true 合法
     */
    public static boolean checkDateYMDIllegal(String str){
        return !(StringUtils.isEmpty(str) || null == convertStringToDateYMD(str));
    }

    public static void main(String[] args){
        //        System.out.println(addDate(new Date(), -2, "yyyy-MM-dd"));

//    List<String> needUpdatedTableName = new ArrayList<>();
//    List<String> needUpdatedMonth = new ArrayList<>();
//    for(int i=2;i>=0;i--) {
//      needUpdatedTableName.add("trd_trade_log_" + DateUtils
//        .convertDateToYM(DateUtils.addMonth(new Date(), -i)).replace("-","_"));
//      needUpdatedMonth.add(DateUtils.convertDateToYM(DateUtils.addMonth(new Date(), -i)));
//    }
//
//    for(int i=0;i<needUpdatedTableName.size();i++){
//      System.out.println(needUpdatedTableName.get(i));
//    }
//    for(int i=0;i<needUpdatedMonth.size();i++){
//      System.out.println(needUpdatedMonth.get(i));
//    }
//      String[] dateArr = {"2018-03-03","2013-05-03","2016-01-01","2017-05-13","2017-05-23","2017-05-07","2017-05-02"};
//      String maxDate = "1970-01-01";
//      String minDate = "2030-01-01";
//     for(String date:dateArr){
//      if(Integer.valueOf(getDiffDays(date,maxDate)) > 0){
//        maxDate = date;
//      }
//       if(Integer.valueOf(getDiffDays(minDate,date)) > 0){
//         minDate = date;
//       }
//    }
//      System.out.println(maxDate + "--" + minDate);
//    System.out.println(stringToDate(maxDate)+ "--" + stringToDate(minDate));
//        System.out.println(getSomeDayDate(stringToDate(maxDate),1) + "--" + getSomeDayDate(stringToDate(minDate),1))
        System.out.println(convertDateToMM(new Date()));
    }
}