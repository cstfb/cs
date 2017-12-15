package com.cs.dp.observer;

/**
 * Created by fengbo on 16/10/29.
 */
public class SimpleProduct implements Cloneable{
    String name ;

    public SimpleProduct(SimpleProductManager manager, String name) {
        if (manager.isCreateProduct()) {
            this.name = name;
        }
    }

    @Override
    protected SimpleProduct clone()  {
        SimpleProduct p = null ;
        try {
            p = (SimpleProduct) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void setName(String name) {
        this.name = name;
    }
}
