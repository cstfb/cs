package com.cs.paramcheck.interfaces;

/**
 * Created by fengbo on 17/10/13.
 * 可检查的参数
 */
public interface ICheckable {
    /**
     * 参数合法性检查函数
     * 各subclass of {@link ICheckable}根据自己的需求实现检查的逻辑 ,
     * {@link ICheckable}应该是和ParamValue分离的(直接传入参数值至 {@link #check})，
     * 这样有利于缓存.
     * 一个{@link ICheckable}对应了某个方法的某个参数的描述
     * (一个{@link ICheckable}对应一个参数描述, for now)
     *
     * todo , 实际中很多参数检查配置的都是一样的条件 例如日期都是yyyy-mm-dd等等， 所以其实{@link ICheckable}是可以复用的
     * todo , 即一个{@link ICheckable}可以描述多个同样描述的参数
     *
     * @param arg 参数值
     * @return true 代表合法， 否则不合法
     */
    boolean check(Object arg);
}
