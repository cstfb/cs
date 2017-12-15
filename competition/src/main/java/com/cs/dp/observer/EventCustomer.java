package com.cs.dp.observer;

import java.util.Vector;

/**
 * Created by fengbo on 16/10/29.
 */
public abstract class EventCustomer {
    private Vector<EventCustomerType> customerTypes = new Vector<EventCustomerType>();


    public EventCustomer(EventCustomerType type) {
        customerTypes.add(type);
    }

    public void addCustomerType(EventCustomerType type) {
        customerTypes.add(type);
    }

    public Vector<EventCustomerType> getCustomerTypes() {
        return customerTypes;
    }

    public abstract void exce(SimpleProductEvent event);
}
