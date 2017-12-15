package com.cs.dp.observer;

/**
 * Created by fengbo on 16/10/29.
 */
public class EventCustomer2 extends EventCustomer{
    public EventCustomer2() {
        super(EventCustomerType.DEL);
    }

    @Override
    public void exce(SimpleProductEvent event) {
        System.out.println("DEL  11111");
    }
}
