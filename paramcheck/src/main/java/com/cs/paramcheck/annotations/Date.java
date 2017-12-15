package com.cs.paramcheck.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengbo on 17/10/13.
 * 用于描述日期参数的注释
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Date {
    /*日期格式*/
    DateValue.Kind value() default DateValue.Kind.YMD;

    /*在某日期之后, DateValue不为空时检查*/
    DateValue afterThan() default @DateValue;

    /*在某日期之前, DateValue不为空时检查*/
    DateValue beforeThan() default @DateValue;

    /*在当前日期之前, 为true时检查*/
    boolean beforeCurrent() default false;

    /*在当前日期之后，为true时检查*/
    boolean afterCurrent() default false;

    //todo , 添加dateoffset属性， 用来表示时间区间
    //todo , 例如在前三个月之后
    //todo , 例如在今年
}
