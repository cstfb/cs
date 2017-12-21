package com.competition.codeforces.contest902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C_Hashing_Trees {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int h = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");
        int[] ai = new int[h+1];
        for (int i = 0; i < h + 1; i++) {
            ai[i] = Integer.valueOf(ar[i]);
        }

        int sum = 0;
        for (int i = 0; i < h + 1; i++) {
            sum+=ai[i];
        }

        int last = 1; boolean f=true;
        for (int i = 0; i < h + 1; i++) {
            if (last > 1 && ai[i] > 1) {
                out.println("ambiguous");
                f = false;
            }
            last = ai[i];
        }
        if (f) {
            System.out.println("perfect");
            return;
        }

        // generate
        int[] ans1 = new int[sum], ans2 = new int[sum];
        last = 1;
        for (int i = 0; i < h + 1; i++) {

        }
    }
}