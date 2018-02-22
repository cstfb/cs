package com.competition.codeforces.contest934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class A_A_Compatible_Pair {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //
        String[] ar = rd.readLine().split(" ");
        int n = Integer.valueOf(ar[0]), m = Integer.valueOf(ar[1]);
        ar = rd.readLine().split(" ");
        int[] tom = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            tom[i] = Integer.valueOf(ar[i]);
        }
        ar = rd.readLine().split(" ");
        int[] bban = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            bban[i] = Integer.valueOf(ar[i]);
        }

        Arrays.sort(tom);
        Arrays.sort(bban);

        //
        System.out.println(Math.min(findMax(tom,bban,0), findMax(tom,bban,tom.length -1)));
    }

    static long findMax(int[] tom, int[] bb, int hide) {
        long ans = 0;
        boolean f = true;
        for (int i = 0; i < tom.length; i++) {
            if (i == hide) continue;
            for (int j = 0; j < bb.length; j++) {
                if (f) {
                    ans = (long)tom[i] * (long)bb[j];
                    f = false;
                } else {
                    ans = Math.max(ans, (long)tom[i] * (long)bb[j]);
                }
            }
        }
        return ans;
    }
}
