package com.cs.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LeastConnection {
    private List<LeastConnectionServer> servers;
    public LeastConnection(String... ips) {
        servers = new ArrayList<>();
        for(String ip : ips) {
            servers.add(new LeastConnectionServer(ip));
        }
    }
    public LeastConnectionServer getServer() {
        LeastConnectionServer best = null;
        for (LeastConnectionServer srv : servers) {
            if(null ==  best || best.connCnt.get() > srv.connCnt.get()) {
                best = srv;
            }
        }
        best.connCnt.incrementAndGet();
        return best;
    }
    public void returnServer(LeastConnectionServer srv) {
        if (null != srv) {
            srv.connCnt.getAndAdd(-1);
        }
    }
    public static void main(String[] args) {
        LeastConnection wrr = new LeastConnection("10.1.1.1", "10.1.1.2", "10.1.1.3");

        int cnt = 50;
        while(cnt > 0) {
            System.out.println(wrr.getServer());
            cnt -= 1;
        }
    }
}

class LeastConnectionServer{
    String ip;
    AtomicInteger connCnt;

    public LeastConnectionServer(String ip) {
        this.ip = ip;
        this.connCnt = new AtomicInteger(0);
    }

    @Override
    public String toString() {
        return "ip:" + ip + ", connection_cnt:" + connCnt.get();
    }
}