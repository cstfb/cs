package com.cs.paramcheck.interfaces;

/**
 * Created by fengbo on 17/10/25.
 */
public interface IBuild<T> {

    /**
     * 创建对象
     * @return 需要创建的对象
     */
    T build();

    /**
     * 只是是否更改过相关属性
     * @return true 更改过， 否则未更改过
     */
    boolean isPropertyChanged();
}
