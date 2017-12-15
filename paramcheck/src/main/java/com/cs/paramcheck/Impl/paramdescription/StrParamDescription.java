package com.cs.paramcheck.Impl.paramdescription;

import com.cs.paramcheck.utils.StringUtils;
import com.cs.paramcheck.interfaces.IBuild;
import com.cs.paramcheck.interfaces.ICheckable;

import java.util.regex.Pattern;

/**
 * Created by fengbo on 17/10/13.
 * 字符串类型约束描述
 */
public class StrParamDescription implements ICheckable {

    private StrParamDescription(){}

    /**
     * 参数以beginWith开始
     */
    private String beginWith = "";

    /**
     * 参数以endWith结束
     */
    private String endWith = "";

    /**
     * 参数匹配正则表达式 ， 不为空时检查
     */
    private String regExpr = "";

    /**
     * 参数是数组里面中的一员 ， 不为空时检查
     */
    private String[] in = null;

    /**
     * 检查 arg 是否满足{@link DateParamDescription}对应的约束
     *
     * @param arg 参数值, 需要检查的实际参数值
     * @return true 满足 false 不满足
     */
    @Override
    public boolean check(Object arg) {
        //type check
        if (null == arg || !(arg instanceof String))
            return false;
        String v = (String)arg;
        //检查前缀
        if (StringUtils.isNotEmpty(beginWith) && !v.startsWith(beginWith))
            return false;
        //检查后缀
        if (StringUtils.isNotEmpty(endWith) && !v.endsWith(endWith))
            return false;
        //检查正则表达式匹配
        if (StringUtils.isNotEmpty(regExpr) && !Pattern.matches(regExpr, v))
            return false;
        //检查枚举
        if (in != null && in.length > 0){
            boolean f = true;
            for (String listItem : in) {
                if (listItem.equals(v)) f = false;
            }
            if (f) return false;
        }

        //检查成功
        return true;
    }

    //============================Builder=============================//
    public static class Builder implements IBuild<StrParamDescription> {
        private String beginWith = "", endWith = "", regExpr = "";
        private String[] in = null;

        // 标示是否有属性值更改， 如果都是默认属性 那么有可能意味着约束都是默认的， 无效的
        private boolean flag = false;

        /**
         * 创建对象
         *
         * @return 需要创建的对象
         */
        @Override
        public StrParamDescription build() {
            StrParamDescription ret = new StrParamDescription();
            ret.beginWith = beginWith;
            ret.endWith = endWith;
            ret.regExpr = regExpr;
            ret.in = in;
            return ret;
        }

        /**
         * 只是是否更改过相关属性
         *
         * @return true 更改过， 否则未更改过
         */
        @Override
        public boolean isPropertyChanged() {
            return flag;
        }

        private void changeFlag() {
            flag = true;
        }

        public Builder setBeginWith(String beginWith) {
            if (StringUtils.isNotEmpty(beginWith)) {
                this.beginWith = beginWith;
                changeFlag();
            }
            return this;
        }

        public Builder setEndWith(String endWith) {
            if (StringUtils.isNotEmpty(endWith)) {
                this.endWith = endWith;
                changeFlag();
            }
            return this;
        }

        public Builder setRegExpr(String regExpr) {
            if (StringUtils.isNotEmpty(regExpr)) {
                this.regExpr = regExpr;
                changeFlag();
            }
            return this;
        }

        public Builder setIn(String[] in) {
            if (in != null && in.length > 0) {
                this.in = in;
                changeFlag();
            }
            return this;
        }
    }

}
