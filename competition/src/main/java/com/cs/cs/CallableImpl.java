package com.cs.cs;

import java.util.concurrent.Callable;

/**
 * Created by fengbo on 16/8/31.
 */
public class CallableImpl implements Callable<String> {

    private int i ;

    public CallableImpl(int _i) {
        this.i = _i + 1;
    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setPriority( 1 + i % 4);
        Thread.sleep(5);
        return "result is :" + String.valueOf(i) + ", prio :" + (1 + i % 4) + ", current: " + System.currentTimeMillis() ;
    }
}
