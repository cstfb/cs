package com.competition.topcoder.srm725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FiveRooksDiv2 {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{

    }

    public int findMax(String[] board){
        int[][] ar = new int[2][8];
        Arrays.fill(ar[0], 0);
        Arrays.fill(ar[1], 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i].charAt(j) == 'R') {
                    ar[0][i] ++;
                    ar[1][j] ++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                max = Math.max(ar[i][j], max);
            }
        }

        return max;
    }
}


