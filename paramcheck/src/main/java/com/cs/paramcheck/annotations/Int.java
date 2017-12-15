package com.cs.paramcheck.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengbo on 17/10/13.
 * 用于描述数字参数的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Int {
    /*指定为<0的数, 为true时检查*/
    boolean negative() default false;
    /*指定为>0的数, 为true时检查*/
    boolean positive() default false;
    /*contains in list， 数组不为空时检查*/
    int[] in() default {};
    /*le : less than or equal*/
    int le() default java.lang.Integer.MAX_VALUE;
    /*ge : greater than or equal*/
    int ge() default java.lang.Integer.MIN_VALUE;
}
