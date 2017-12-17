package com.competition.codeforces.contest898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A_Rounding {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(rd.readLine());
        System.out.println((n%10 >= 5 ? 10*(1 + n/10): (10*(n/10))));
    }
}
