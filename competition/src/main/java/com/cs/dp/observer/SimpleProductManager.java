package com.cs.dp.observer;

/**
 * Created by fengbo on 16/10/29.
 */
public class SimpleProductManager {
    private boolean isPermittedCreate = false;

    public SimpleProduct createProduct(String name) {
        this.isPermittedCreate = true;
        SimpleProduct p =  new SimpleProduct(this, name);
        new SimpleProductEvent(p, EventCustomerType.NEW);
        return p;
    }

    public boolean isCreateProduct() {
        return isPermittedCreate;
    }

    public  SimpleProduct clone(SimpleProduct p) {
        return p.clone();
    }


    public void editProduct(SimpleProduct p, String name) {
        p.setName(name);
    }

    public void abundandProduct(SimpleProduct p) {
        //destroy
        new SimpleProductEvent(p, EventCustomerType.DEL);
        p = null ;
    }

    public static void main(String[] args) {
        SimpleEventDispatch dispatch = SimpleEventDispatch.getEventDispatch();
        EventCustomer customer = new EventCustomer1();
        EventCustomer2 customer2 = new EventCustomer2();
        dispatch.registerCustomer(customer);
        dispatch.registerCustomer(customer2);

        SimpleProductManager manager = new SimpleProductManager();
        SimpleProduct p = manager.createProduct("cs");
        manager.abundandProduct(p);
    }
}
