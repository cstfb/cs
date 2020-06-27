package com.competition.codeforces.contest1365;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.naming.spi.DirObjectFactory;

public class A_matrix_game {

    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Integer n = Integer.valueOf(rd.readLine());
        for (int i = 0; i < n; i++) {
            String[] xy = rd.readLine().split(" ");
            Integer x = Integer.valueOf(xy[0]);
            Integer y = Integer.valueOf(xy[1]);

            int rank = Math.min(x, y);
            boolean[] xFlag = new boolean[y];
            boolean[] yFlag = new boolean[x];

            for (int j = 0; j < x; j++) {
                String[] values = rd.readLine().split(" ");
                for (int k = 0; k < values.length; k++) {
                    String value = values[k];
                    if ("1".equalsIgnoreCase(value)) {
                        xFlag[k] = true;
                        yFlag[j] = true;
                    }
                }
            }

            // 数秩
            int leftRank = 0;
            if (x >= y) {
                for (int j = 0; j < xFlag.length; j++) {
                    if (xFlag[j]) {
                        continue;
                    }
                    for (int k = 0; k < yFlag.length; k++) {
                        if (!yFlag[k]) {
                            leftRank++;
                            yFlag[k] = true;
                            break;
                        }
                    }
                }
            } else {
                for (int k = 0; k < yFlag.length; k++) {
                    if (yFlag[k]) {
                        continue;
                    }
                    for (int j = 0; j < xFlag.length; j++) {
                        if (!xFlag[j]) {
                            leftRank ++;
                            xFlag[j] = true;
                            break;
                        }
                    }
                }
            }

            out.println(leftRank == 0 ? "Vivek" : (leftRank % 2 == 0 ? "Vivek" : "Ashish"));
        }
        out.flush();
    }
}
