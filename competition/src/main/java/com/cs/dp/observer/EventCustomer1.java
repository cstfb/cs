package com.cs.dp.observer;


/**
 * Created by fengbo on 16/10/29.
 */
public class EventCustomer1 extends EventCustomer {
    public EventCustomer1() {
        super(EventCustomerType.NEW);
    }


    @Override
    public void exce(SimpleProductEvent event) {
        System.out.println("New 111111");
    }
}
