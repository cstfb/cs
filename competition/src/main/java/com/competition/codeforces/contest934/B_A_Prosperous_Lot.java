package com.competition.codeforces.contest934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_A_Prosperous_Lot {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int k = Integer.valueOf(rd.readLine());
        if (k > 36) System.out.println(-1);
        else {
            for (int i = 1; i * 2 <= k; i++) {
                System.out.print('8');
            }
            if (k % 2 == 1) {
                System.out.print('4');
            }
        }
    }
}
