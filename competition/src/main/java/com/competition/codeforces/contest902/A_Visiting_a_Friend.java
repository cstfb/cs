package com.competition.codeforces.contest902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Visiting_a_Friend {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] ar = rd.readLine().split(" ");
        int n = Integer.valueOf(ar[0]), m = Integer.valueOf(ar[1]);

        int cur = 0;
        for (int i = 0; i < n; i++) {
            ar = rd.readLine().split(" ");
            int a = Integer.valueOf(ar[0]), b = Integer.valueOf(ar[1]);
            if (cur >= a) {
                cur = Math.max(cur, b);
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (cur >= m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}