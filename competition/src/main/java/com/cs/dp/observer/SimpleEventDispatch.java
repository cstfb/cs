package com.cs.dp.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by fengbo on 16/10/29.
 */
public class SimpleEventDispatch implements Observer{
    private final static SimpleEventDispatch eventDispatch = new SimpleEventDispatch();

    private SimpleEventDispatch(){}

    public static SimpleEventDispatch getEventDispatch() {
        return eventDispatch;
    }

    private Vector<EventCustomer> customers = new Vector<EventCustomer>();

    public void registerCustomer(EventCustomer _customer) {
        customers.add(_customer);
    }

    @Override
    public void update(Observable o, Object args) {
        SimpleProduct product = (SimpleProduct)args;
        SimpleProductEvent event = (SimpleProductEvent)o;
        for (EventCustomer customer : customers) {
            for (EventCustomerType t : customer.getCustomerTypes()) {
                if (t.getValue() == event.getType().getValue()) {
                    customer.exce(event);
                }
            }
        }
    }
}
