package com.cs.dp.observer;

/**
 * Created by fengbo on 16/10/29.
 */
public enum  EventCustomerType {
    NEW(1),DEL(2),EDIT(3),CLONE(4);

    private int value = 0 ;

    private EventCustomerType(int _value) {
        this.value = _value;
    }

    public int getValue() {
        return this.value;
    }
}
