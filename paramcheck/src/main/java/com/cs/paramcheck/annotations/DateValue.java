package com.cs.paramcheck.annotations;

import com.cs.paramcheck.utils.DateUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengbo on 17/10/13.
 * 用于描述日期值的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface DateValue {

    /*日期格式*/
    Kind format() default Kind.YMD;
    /*日期的值*/
    String value() default "";

    enum Kind {
        YM("yyyy-MM"),
        YMD("yyyy-MM-dd"),
        SIMPLE_YMD("yyyyMMdd"),
        YMDHM("yyyy-MM-dd HH:mm"),
        YMDHMS("yyyy-MM-dd HH:mm:ss"),
        SIMPLE_YMDHMS("yyyyMMddHHmmss");

        private String _format;
        private Kind(String format){
            this._format = format;
        }

        public String getFormat(){
            return this._format;
        }

        public java.util.Date getDate(String value){
            return DateUtils.convertStringToDateByFormat(value, this.getFormat());
        }
    }
}
