package com.cs.paramcheck.Impl.paramdescription;


import com.cs.paramcheck.interfaces.IBuild;
import com.cs.paramcheck.interfaces.ICheckable;
import com.cs.paramcheck.utils.DateUtils;
import com.cs.paramcheck.utils.StringUtils;
import com.cs.paramcheck.utils.StringUtils;

import java.util.Date;

/**
 * Created by fengbo on 17/10/13.
 * 日期字符串类型约束描述
 */
public class DateParamDescription implements ICheckable {

    private DateParamDescription(){}

    /**
     * 日期格式
     */
    private String format = "";

    /**
     * 在afterThan日期之后
     */
    private Date afterThan = null;

    /**
     * 在beforeThan日期之前
     */
    private Date beforeThan = null;

    /**
     * 是否在当前时间之前
     */
    private boolean beforeCurrent = false;

    /**
     * 是否在当前时间之后
     */
    private boolean afterCurrent = false;


    /**
     * 检查 arg 是否满足{@link DateParamDescription}对应的约束
     * @param arg 参数值, 需要检查的实际参数值
     * @return true 满足 false 不满足
     */
    @Override
    public boolean check(Object arg) {
        //type check
        if (null == arg || !(arg instanceof String))
            return false;
        String dt = (String)arg;
        Date dtValue = null;
        //format check
        if ((dtValue = DateUtils.convertStringToDateByFormat(dt, format)) == null)
            return false;
        //after than
        if (afterThan != null && !dtValue.after(afterThan))
            return false;
        //before than
        if (beforeThan != null && !dtValue.before(beforeThan))
            return false;
        //beforeCurrent
        if (beforeCurrent && !dtValue.before(new Date()))
            return false;
        //afterCurrent
        if (afterCurrent && !dtValue.after(new Date()))
            return false;

        return true;
    }


    //=============================Builder=================================//
    public static class Builder implements IBuild<DateParamDescription> {

        private String format = "";
        private Date afterThan = null, beforeThan = null;
        private boolean beforeCurrent = false, afterCurrent = false;

        // 标示是否有属性值更改， 如果都是默认属性 那么有可能意味着约束都是默认的， 无效的
        private boolean flag = false;

        /**
         * 创建对象
         *
         * @return 需要创建的对象
         */
        @Override
        public DateParamDescription build() {
            DateParamDescription ret = new DateParamDescription();
            ret.format = format;
            ret.afterThan = afterThan;
            ret.beforeThan = beforeThan;
            ret.afterCurrent = afterCurrent;
            ret.beforeCurrent = beforeCurrent;
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

        private void changeFlag(){
            flag = true;
        }

        public Builder setFormat(String format) {
            if (StringUtils.isNotEmpty(format)) {
                this.format = format;
                changeFlag();
            }
            return this;
        }

        public Builder setAfterThan(Date afterThan) {
            if (afterThan != null) {
                this.afterThan = afterThan;
                changeFlag();
            }
            return this;
        }

        public Builder setBeforeThan(Date beforeThan) {
            if (beforeThan != null) {
                this.beforeThan = beforeThan;
                changeFlag();
            }
            return this;
        }

        public Builder setBeforeCurrent(boolean beforeCurrent) {
            this.beforeCurrent = beforeCurrent;
            changeFlag();
            return this;
        }

        public Builder setAfterCurrent(boolean afterCurrent) {
            this.afterCurrent = afterCurrent;
            changeFlag();
            return this;
        }
    }
}
