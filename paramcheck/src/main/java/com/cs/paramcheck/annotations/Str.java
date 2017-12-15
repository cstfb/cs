package com.cs.paramcheck.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengbo on 17/10/13.
 * 用于描述字符串参数的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Str {
    /*以beginWith开始, 不为空时检查*/
    String beginWith() default "";

    /*以endWith结束, 不为空时检查*/
    String endWith() default "";

    /*匹配正则表达式, 不为空时检查*/
    String regExpr() default "";

    /*包含与inList, 不为空时检查*/
    String[] in() default {};
}
