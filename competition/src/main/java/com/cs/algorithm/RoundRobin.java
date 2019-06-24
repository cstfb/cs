package com.cs.algorithm;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.base.Preconditions;

public class RoundRobin {
    private Object[] hosts; // hosts列表
    private int len; // hosts数量
    private AtomicInteger increr = new AtomicInteger(0); // 自增器
    // constructor
    public RoundRobin(Object... hosts) {
        Preconditions.checkNotNull(hosts);
        this.hosts = hosts;
        len = hosts.length;
    }
    // get next hosts
    public Object get() {
        int cur = increr.incrementAndGet();
        if (cur > 0x70000000) {
            increr.set(0);
        }
        return hosts[cur % len];
    }
    // get request cnt
    public int getCnt() {
        return increr.get();
    }

    public static void main(String[] args) throws Exception {
        int i = 0;
        RoundRobin rr = new RoundRobin("10.1.1.1", "10.1.1.2", "10.1.1.3");
        AtomicLong totalTime = new AtomicLong(0L);

        // 模拟多线程环境测试QPS
        int maxThread = 2;
        // 10线程
        ExecutorService es = Executors.newFixedThreadPool(maxThread);
        while (maxThread > 0) {
            es.execute(() -> {
                long t1 = System.currentTimeMillis();
                try {
                    while (!Thread.interrupted()) {
                        rr.get();
                    }
                    long t2 = System.currentTimeMillis();
                    totalTime.addAndGet(t2 - t1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            });

            maxThread --;
        }

        // 
        Thread.sleep(1000);
        
        es.shutdownNow();
        es.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("total cpu time:" + totalTime.get());
        System.out.println("total request count:" + rr.getCnt());
    }
}