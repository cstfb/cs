package com.cs.paramcheck.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengbo on 17/10/12.
 * 用于标示要检查的参数注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckThis {
    //参数名称 或者 备注 等等，自定义， 用于异常信息
    String value() default "";
    //能否为空
    boolean nullable() default true;
    /*对应的日期属性*/
    Date dateDesc() default @Date;
    /*对应的数字属性*/
    Int intDesc() default @Int;
    /*对应的字符串属性*/
    Str strDesc() default @Str;
}
