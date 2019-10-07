package com.competition.codeforces.contest1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Choose_Two_Numbers {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(rd.readLine());
        int aMax = 0;
        for (String s : rd.readLine().split(" ")) {
            aMax = Math.max(aMax, Integer.valueOf(s));
        }

        int m = Integer.valueOf(rd.readLine());
        int bMax = 0;
        for (String s : rd.readLine().split(" ")) {
            bMax = Math.max(bMax, Integer.valueOf(s));
        }

        out.println(aMax + " " + bMax);
        out.flush();
    }
}
