package com.cs.cs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by fengbo on 16/7/23.
 */
public class D {
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(reader.readLine());
        String[] ar = new String[70010];
        int[][] tr = new int[10][10];
        Arrays.fill(tr, 0);
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            ar[i] = s;
            for (int j = 0; j < 9 ; j++) {
                int flat = 0;
                for (int k = j; k < 9 ; k++) {
                    tr[flat++][s.charAt(k)-'0'] ++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String s = ar[i];
            for (int j = 8; j >= 0 ; j++) {
                int flat = 0;
                for (int k = j; k < 9; k++) {

                }
            }
        }

    }
}
