package com.cs.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.base.Preconditions;

public class WeightedRoundRobin {
    private List<Server> servers;
    private int totalWeight;
    // init
    public WeightedRoundRobin() {
        this.servers = new ArrayList();
        this.totalWeight = 0;
    }
    // 添加hosts
    public void addServer(String ip, int weight) {
        this.servers.add(new Server(ip, weight));
        this.totalWeight += weight;
    }
    // get
    public Server getServer() {
        Server best = null;

        for (Server srv : servers) {
            srv.effectiveWeight += srv.weight;

            if (null == best || best.effectiveWeight < srv.effectiveWeight) {
                best = srv;
            }
        }
        if (best != null) {
            best.effectiveWeight -= totalWeight;
        }
        return best;
    }

    public static void main(String[] args) {
        WeightedRoundRobin wrr = new WeightedRoundRobin();
        wrr.addServer("10.1.1.1", 3);
        wrr.addServer("10.1.1.2.", 2);
        wrr.addServer("10.1.1.3", 1);

        int cnt = 50;
        while(cnt > 0) {
            System.out.println(wrr.getServer());
            cnt -= 1;
        }
    }
}

class Server{
    String ip;
    int weight;
    int effectiveWeight;

    public Server(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
        this.effectiveWeight = 0;
    }

    @Override
    public String toString() {
        return "ip:" + ip + ", weight:" + weight;
    }
}