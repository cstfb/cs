package com.cs.paramcheck.Impl.paramdescription;


import com.cs.paramcheck.interfaces.ICheckable;

/**
 * Created by fengbo on 17/10/25.
 */
public class CheckThisDescription {

    //注解描述的 Date, Int, Str 约束
    private ICheckable[] descriptions;
    //参数是否可以为空
    private boolean nullable;

    public CheckThisDescription(ICheckable[] desc, boolean nullable){
        this.descriptions = desc;
        this.nullable = nullable;
    }

    public ICheckable[] getDescriptions() {
        return descriptions;
    }

    public boolean isNullable() {
        return nullable;
    }
}
