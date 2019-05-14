package com.cs.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 切钢管
 *
 * 有一个长度为L的钢管，可以切开来卖，切开卖价格不一样，问最多能卖多少钱?
 */
public class tube_cut {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // read length
        int l = Integer.valueOf(rd.readLine());
        // read n-prices
        int n = Integer.valueOf(rd.readLine());

        Segment[] segs = new Segment[n];
        for (int i = 0 ; i < n ; i ++) {
            String[] ar = rd.readLine().split(" ");
            segs[i] = new Segment(Integer.valueOf(ar[0]), Integer.valueOf(ar[1]));
        }
        Arrays.sort(segs, Comparator.comparingInt(o -> o.l));

        // dp[i] : when l = i the max price we can make is dp[i]
        int[] dp = new int[l + 1];
        Arrays.fill(dp, -1);

        // initiate dp
        for (int i = 0 ; i < n ; i ++) {
            dp[segs[i].l] = segs[i].price;
        }
        for (int i = 1 ; i < l + 1; i ++) {
            for (int j = 0; j < n && segs[j].l <= i; j ++) {
                if (dp[i - segs[j].l] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - segs[j].l] + segs[j].price);
                }
            }
        }

        out.print(dp[l]);
        out.flush();
    }
}

class Segment{
    public Segment(int _l, int _price) {
        this.l = _l;
        this.price = _price;
    }
    public int l;
    public int price;
}
