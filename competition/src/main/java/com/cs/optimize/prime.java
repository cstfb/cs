package com.cs.optimize;

import java.io.PrintWriter;

public class prime {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        prime();
    }

    public static void prime() {
        for (int i = 2; i < 1001; i ++) {
            boolean f = true;
            for (int j = 2 ; j <= Math.sqrt((double)i); j ++) {
                if (i % j == 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                System.out.println(i);
            }
        }
    }
}
