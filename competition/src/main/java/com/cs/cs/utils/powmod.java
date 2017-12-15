package com.cs.cs.utils;

/**
 * Created by fengbo on 16/7/23.
 */

public class powmod {
    private static long N = 1000000007 ;

    public static void main(String[] args) {

    }

    // a ^ b (mod N) , quick power
    private static long powmod(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;

        long i = powmod(a, b / 2);
        i *= i;
        i %= N;
        if (b % 2 == 0) {
            return i;
        } else {
            return (i * a) % N;
        }
    }
}
