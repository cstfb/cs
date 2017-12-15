package com.cs.paramcheck.interfaces;

/**
 * Created by fengbo on 17/10/13.
 */
public interface IParamAnnotationParser<T> {

    /**
     * 解析注解配置
     * @param ann 注解对象
     * @return null如果没有任何约束， 否则非空
     */
    ICheckable parse(T ann);
}
