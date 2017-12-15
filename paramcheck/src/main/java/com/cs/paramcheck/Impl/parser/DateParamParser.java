package com.cs.paramcheck.Impl.parser;

import com.cs.paramcheck.Impl.paramdescription.DateParamDescription;
import com.cs.paramcheck.annotations.Date;
import com.cs.paramcheck.annotations.DateValue;
import com.cs.paramcheck.interfaces.ICheckable;
import com.cs.paramcheck.interfaces.IParamAnnotationParser;
import org.springframework.stereotype.Service;

/**
 * Created by fengbo on 17/10/25.
 */
@Service
public class DateParamParser implements IParamAnnotationParser<Date> {

    /**
     * 解析注解配置
     *
     * @param ann 注解对象
     * @return null如果没有任何约束， 否则非空
     */
    @Override
    public ICheckable parse(Date ann) {
        if (ann == null)
            return null;

        DateParamDescription.Builder builder = new DateParamDescription.Builder();

        builder.setFormat(ann.value().getFormat());
        //afterThan
        DateValue afterThanAnn = ann.afterThan();
        java.util.Date afterThanValue = afterThanAnn.format().getDate(afterThanAnn.value());
        if (afterThanValue != null)
            builder.setAfterThan(afterThanValue);
        //beforeThan
        DateValue beforeThanAnn = ann.beforeThan();
        java.util.Date beforeThanValue = beforeThanAnn.format().getDate(beforeThanAnn.value());
        if (beforeThanValue != null)
            builder.setBeforeThan(beforeThanValue);
        //
        builder.setBeforeCurrent(ann.beforeCurrent());
        builder.setAfterCurrent(ann.afterCurrent());

        if (builder.isPropertyChanged()) return builder.build();
        return null;
    }
}
