package com.competition.topcoder.srm725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OvercookedDiv2 {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int[] start = new int[]{1,10,100,1000,10000,100000};
        int[] time = new int[]{50,50,50,50,50,50};
        System.out.println(minStale(start, time));
        System.out.println(16625 * 3);
    }

    public static int minStale(int[] start, int[] time){
        if (start.length == 0) return 0;
        int len = start.length; int ans = 0x7fffffff;
        for (int j = 0; j <= 1000000; j++) {
            int cur = j, tmp_ans = j;
            for (int i = 0; i < len; i++) {
                if (start[i] >= cur){
                    tmp_ans = Math.max(tmp_ans, start[i] - cur);
                    cur = start[i] + time[i];
                } else {
                    cur += time[i];
                }
            }

            ans = Math.min(tmp_ans, ans);
        }

        return ans;
    }
}
