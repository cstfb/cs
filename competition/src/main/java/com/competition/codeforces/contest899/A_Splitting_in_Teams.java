package com.competition.codeforces.contest899;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Splitting_in_Teams {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");
        int cnt2 = 0, cnt1 = 0;
        for (int i = 0; i < n; i++) {
            int c = Integer.valueOf(ar[i]);
            if (c == 1) cnt1 ++;
            else cnt2 ++;
        }

        int ans = Math.min(cnt1,  cnt2) + (cnt1 - Math.min(cnt1, cnt2)) / 3;
        System.out.println(ans);
    }
}
