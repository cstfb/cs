package com.competition.codeforces.contest897;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class B_Chthollys_request {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] ar = rd.readLine().split(" ");
        int k = Integer.valueOf(ar[0]);
        int p = Integer.valueOf(ar[1]);

        char[] chars = new char[15];

        long ans = 0;

        for (int i = 1; i <= k ; i++) {
            int cnt = 0;
            String s = String.valueOf(i);
            int len = s.length();

            Arrays.fill(chars, '0');
            for (int j = 0; j < len; j++) {
                chars[j] = s.charAt(j);
            }
            for (int j = len - 1; j >= 0 ; j--) {
                chars[len - j - 1 + len] = s.charAt(j);
            }


            long v = (Long.valueOf(String.valueOf(chars)));
            while (v % 10 == 0) v /= 10;
//            System.out.println(v);
            ans += v % p;
            ans = ans % p;
        }

        System.out.println(ans);
    }
}
