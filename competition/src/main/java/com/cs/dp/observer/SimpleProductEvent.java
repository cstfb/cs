package com.cs.dp.observer;

import java.util.Observable;

/**
 * Created by fengbo on 16/10/29.
 */
public class SimpleProductEvent extends Observable{
    private SimpleProduct source;
    private EventCustomerType type;

    public SimpleProductEvent(SimpleProduct product, EventCustomerType type) {
        this.source = product;
        this.type = type;
        notifyEventDispatch();
    }

    public SimpleProduct getSource() {
        return source;
    }

    public EventCustomerType getType() {
        return type;
    }

    private void notifyEventDispatch() {
        super.addObserver(SimpleEventDispatch.getEventDispatch());
        super.setChanged();
        super.notifyObservers();
    }
}
