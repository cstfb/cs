package com.cs.paramcheck.Impl.paramdescription;


import com.cs.paramcheck.interfaces.IBuild;
import com.cs.paramcheck.interfaces.ICheckable;

/**
 * Created by fengbo on 17/10/13.
 * 整型参数约束描述
 */
public class IntParamDescription implements ICheckable {

    private IntParamDescription(){}

    /**
     * 指定为<0的数, 为true时检查
     */
    private boolean negative = false;

    /**
     * 指定为>0的数, 为true时检查
     */
    private boolean positive = false;

    /**
     * contains in list， 数组不为空时检查
     */
    private int[] in = null;

    /**
     * le : less than or equal, 要求值 <= le
     */
    private int le = Integer.MAX_VALUE;

    /**
     * ge : greater than or equal, 要求值 >= ge
     */
    private int ge = Integer.MIN_VALUE;

    /**
     * 检查 arg 是否满足{@link DateParamDescription}对应的约束
     * @param arg 参数值, 需要检查的实际参数值
     * @return true 满足 false 不满足
     */
    @Override
    public boolean check(Object arg) {
        // type check
        if (arg == null || !(arg instanceof Integer)){
            return false;
        }
        int v = (Integer)arg;
        // negative or positive
        if (negative && v >= 0 || positive && v <= 0) return false;
        // v in [item1, item2, item3...]
        if (in != null && in.length > 0) {
            boolean f = true;
            for (int listItem : in) {
                if (listItem == v) f = false;
            }
            if (f) return false;
        }
        // [ge, le]
        if (v > le || v < ge) return false;
        return true;
    }

    //===========================Builder===============================//
    public static class Builder implements IBuild<IntParamDescription> {

        private boolean _negative = false,  _positive = false;
        private int[] _in = null;
        private int _le = Integer.MAX_VALUE, _ge = Integer.MIN_VALUE;

        // 标示是否有属性值更改， 如果都是默认属性 那么有可能意味着约束都是默认的， 无效的
        private boolean flag = false;

        /**
         * 创建对象
         *
         * @return 需要创建的对象
         */
        @Override
        public IntParamDescription build() {
            IntParamDescription obj = new IntParamDescription();
            obj.negative = _negative;
            obj.positive = _positive;
            obj.in = _in;
            obj.le = _le;
            obj.ge = _ge;
            return obj;
        }

        public Builder setNegative(boolean v){
            _negative = v;
            changeFlag();
            return this;
        }

        public Builder setPositive(boolean v){
            _positive = v;
            changeFlag();
            return this;
        }

        public Builder setIn(int[] v){
            if (v != null && v.length > 0) {
                _in = v;
                changeFlag();
            }
            return this;
        }

        public Builder setLe(int v){
            _le = v;
            changeFlag();
            return this;
        }

        public Builder setGe(int v) {
            _ge = v;
            changeFlag();
            return this;
        }

        private void changeFlag(){
            flag = true;
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
    }
}
