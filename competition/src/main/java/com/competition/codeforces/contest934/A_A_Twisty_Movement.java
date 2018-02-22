package com.competition.codeforces.contest934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_A_Twisty_Movement {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.valueOf(ar[i]);
        }

        int[][] dp = new int[n+1][4];
        int[][] lastDp = new int[n+1][4];
        lastDp[0][0] = 0;
        lastDp[0][1] = 0;
        lastDp[0][2] = 0;
        lastDp[0][3] = 0;
        for (int i = 0; i < n; i++) {

        }
    }
}
