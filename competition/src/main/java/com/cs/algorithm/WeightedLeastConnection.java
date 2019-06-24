package com.cs.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WeightedLeastConnection {
    private List<WeightedLeastConnectionServer> servers;
    
    public WeightedLeastConnection() {
        this.servers = new ArrayList<>();
    }
    public void addServer(String ip, int weight) {
        this.servers.add(new WeightedLeastConnectionServer(ip, weight));
    }
    public WeightedLeastConnectionServer getServer() {
        WeightedLeastConnectionServer best = null;
        for (WeightedLeastConnectionServer srv : servers) {
            if(null ==  best || best.connCnt.get() / best.weight > srv.connCnt.get() / srv.weight) {
                best = srv;
            }
        }
        best.connCnt.incrementAndGet();
        return best;
    }
    public void returnServer(WeightedLeastConnectionServer srv) {
        if (null != srv) {
            srv.connCnt.getAndAdd(-1);
        }
    }
    public static void main(String[] args) {
        WeightedLeastConnection wrr = new WeightedLeastConnection();
        wrr.addServer("10.1.1.1", 5);
        wrr.addServer("10.1.1.2", 3);
        wrr.addServer("10.1.1.3", 1);

        int cnt = 50;
        while(cnt > 0) {
            System.out.println(wrr.getServer());
            cnt -= 1;
        }
    }
}

class WeightedLeastConnectionServer{
    String ip;
    int weight;
    AtomicInteger connCnt;

    public WeightedLeastConnectionServer(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
        this.connCnt = new AtomicInteger(0);
    }

    @Override
    public String toString() {
        return "ip:" + ip + ", connection_cnt:" + connCnt.get();
    }
}