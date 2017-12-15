package com.competition.codeforces.contest897;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Scarborough_Fair {

    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] ar = rd.readLine().split(" ");
        int n = Integer.valueOf(ar[0]);
        int m = Integer.valueOf(ar[1]);
        char[] chars = rd.readLine().toCharArray();

        for (int i = 0; i < m; i++) {
            ar = rd.readLine().split(" ");
            int l = Integer.valueOf(ar[0]);
            int r = Integer.valueOf(ar[1]);
            char c1 = ar[2].charAt(0);
            char c2 = ar[3].charAt(0);

            for (int j = l - 1; j < r; j++) {
                if (chars[j] == c1)
                    chars[j] = c2;
            }
        }

        System.out.println(String.valueOf(chars));
    }
}
