package com.cs.paramcheck.Impl.parser;

import com.cs.paramcheck.Impl.paramdescription.StrParamDescription;
import com.cs.paramcheck.annotations.Str;
import com.cs.paramcheck.interfaces.ICheckable;
import com.cs.paramcheck.interfaces.IParamAnnotationParser;
import org.springframework.stereotype.Service;
import com.cs.paramcheck.utils.StringUtils;

/**
 * Created by fengbo on 17/10/25.
 */
@Service
public class StrParamParser implements IParamAnnotationParser<Str> {

    /**
     * 解析注解配置
     *
     * @param str 注解对象
     * @return null如果没有任何约束， 否则非空
     */
    @Override
    public ICheckable parse(Str str) {
        if (str == null)
            return null;

        StrParamDescription.Builder builder = new StrParamDescription.Builder();

        if (StringUtils.isNotEmpty(str.beginWith()))
            builder.setBeginWith(str.beginWith());
        if (StringUtils.isNotEmpty(str.endWith()))
            builder.setEndWith(str.endWith());
        if (StringUtils.isNotEmpty(str.regExpr()))
            builder.setRegExpr(str.regExpr());
        if (str.in() != null && str.in().length > 0)
            builder.setIn(str.in());

        if (builder.isPropertyChanged()) return builder.build();
        return null;
    }
}
