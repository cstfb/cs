package com.competition.codeforces.contest899;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class C_Dividing_the_numbers {

    private static boolean DEBUG = false;
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        long n = Integer.valueOf(rd.readLine());


        if (DEBUG) {
            System.out.println("sum = " + (n * (n + 1) / 2));
        }
        //split
        if (n % 2 == 0) {

            if ((n/2) % 2 == 0) out.println(0);
            else out.println(1);

            out.print(n/2);

            long[] ret = get(n);
            for (int i = 0; i < n/2; i++) {
                out.print(" " + ret[i]);
            }
        } else {
            long[] ret = get(n-1);
            long tmpN = n - 1;
            long tmpSum = (n) * (n-1) / 2;
            long sum1 = tmpSum / 2;
            long sum2 = tmpSum - sum1;

            long diff1 = Math.abs((sum1 + n - tmpN/2) - (sum2 + tmpN/2));
            long diff2 = Math.abs((sum1 + (tmpN/2 + 1)) - (sum2 - (tmpN/2 + 1) + n));


            out.println(diff2 > diff1 ? diff1 : diff2);
            out.print(diff2 > diff1 ? tmpN / 2 : tmpN / 2 + 1);
            for (int i = 0; i < tmpN/2; i++) {
                if (diff2 > diff1) {
                    if (ret[i] ==  tmpN / 2) continue;
                    out.print(" " + ret[i]);
                } else {
                    out.print(" " + ret[i]);
                }
            }

            if (diff2 > diff1) {
                out.print(" " + n);
            } else {
                out.print(" " + (tmpN / 2 + 1));
            }

        }
        out.flush();
    }

    static long[] get(long n) {
        long[] ret = new long[(int)n/2];
        int i,j;
        for (i = 1,j = 0; i < n / 2 ; i+= 2, j+=2) {
            ret[j] = i;
            ret[j + 1] = n - i + 1;
        }
        if ((n/2) % 2 != 0) {
            ret[j] = n/2;
        }

        return ret;
    }
}


// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//               |
// 1 15 3 13 5 11 7z
// 2 14 4 12 6 10 9


// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
//                 |
// 1 17 3 15 5 13 7 11 4
// 2 16 14 6 12 8 10 9


// 1 2 3 4 5 6 7
// 1 7 3 4
// 2 6 5

// 1 2 3 4 5 6