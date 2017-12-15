package com.cs.paramcheck.Impl.parser;

import com.cs.paramcheck.Impl.paramdescription.IntParamDescription;
import com.cs.paramcheck.annotations.Int;
import com.cs.paramcheck.interfaces.ICheckable;
import com.cs.paramcheck.interfaces.IParamAnnotationParser;
import org.springframework.stereotype.Service;

/**
 * Created by fengbo on 17/10/25.
 */
@Service
public class IntParamParser implements IParamAnnotationParser<Int> {

    /**
     * 解析注解配置
     *
     * @param ann 注解对象
     * @return null如果没有任何约束， 否则非空
     */
    @Override
    public ICheckable parse(Int ann) {
        if (ann == null)
            return null;

        IntParamDescription.Builder builder = new IntParamDescription.Builder();
        if (ann.negative())
            builder.setNegative(true);
        if (ann.positive())
            builder.setPositive(true);
        if (ann.in() != null && ann.in().length > 0)
            builder.setIn(ann.in());
        if (ann.le() != Integer.MAX_VALUE)
            builder.setLe(ann.le());
        if (ann.ge() != Integer.MIN_VALUE)
            builder.setGe(ann.ge());

        // 如果不全是默认约束， 那么返回相应的Description ， 否则返回空值
        if (builder.isPropertyChanged()) return builder.build();
        return null;
    }
}
