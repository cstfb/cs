package com.competition.codeforces.contest912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Tricky_Alchemy {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //
        String[] ar = rd.readLine().split(" ");
        long a = Long.valueOf(ar[0]), b = Long.valueOf(ar[1]);
        ar = rd.readLine().split(" ");
        long x = Long.valueOf(ar[0]), y = Long.valueOf(ar[1]), z = Long.valueOf(ar[2]);

        long ry = 2 * x + y, rb = y + 3 * z;
        long ans = (a >= ry ? 0 : (ry - a)) + (b >= rb ? 0 : (rb - b));

        System.out.println(ans);
    }
}
