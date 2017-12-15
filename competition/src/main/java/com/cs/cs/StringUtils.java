package com.cs.cs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 14-8-4.
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if(null == str || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static int getPackageUnit(int conversionValue,String measureUnit,String packageFormat,String goodsSn){
        try {
            if (packageFormat.contains("/")) {
                String[] packageFormatStr = packageFormat.split("/");

                if (measureUnit.equals(packageFormatStr[packageFormatStr.length - 1]))
                {
                    return conversionValue;
                }

                measureUnit = packageFormatStr[packageFormatStr.length - 1];
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
            System.out.println("getPackageUnit: " + conversionValue + " " + measureUnit + " " + packageFormat + " " + goodsSn);
        }
        return conversionValue;
    }

    public static String getPackageMeasureUnit(int conversionValue,int packageUnit,String measureUnit,String packageFormat){
        try {
            if (packageUnit == 1)
            {
                return measureUnit;
            }
            else
            {
                if (packageFormat.contains("/"))
                {
                    String[] packageFormatStr = packageFormat.split("/");
                    measureUnit = packageFormatStr[packageFormatStr.length - 1];
                }
            }
        }catch(Exception e){
            System.out.println("getPackageMeasureUnit: " + conversionValue + " " + measureUnit + " " + packageFormat + " ");
        }
        return measureUnit;
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


    /**
     * 全匹配(前后都模糊匹配)
     * @param regexp
     * @param str
     * @return
     */
    public static boolean patchRegexp(String regexp,String str){
        // 邮箱验证规则
        String regEx = "^.*[" + regexp + "]" + ".*$";
        // 编译正则表达式
//        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        return  rs;
    }


    /**
     * 将第一个字母小写
     * @param str
     * @return
     */
    public static String getStringWithLowFirst(String str){
        char[] chars=new char[1];
        chars[0]=str.charAt(0);
        String first = new String(chars);
        return  str.replaceFirst(first,first.toLowerCase());
    }

    public static void main(String[] args){
        System.out.println(patchRegexp("t","tqtcom@tqmall.com"));
    }
}
