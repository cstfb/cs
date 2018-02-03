package com.competition.codeforces.contest912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_New_Years_Eve {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //
        String[] ar = rd.readLine().split(" ");
        long k = Long.valueOf(ar[1]), n = Long.valueOf(ar[0]);

        //
//        long ans = 0;
        long highest = Long.highestOneBit(n);
//        while(k > 0 && highest > 0) {
//            ans += highest;
//            highest /= 2;
//            k --;
//        }
        if (k == 1) System.out.println(n);
        else {
            System.out.println(2 * highest - 1);
        }

//        System.out.println(ans);
    }
}
