package com.competition.codeforces.contest1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Make_Product_Equal_One {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String n = rd.readLine();

        long pCnt = 0, nCnt = 0, zCnt = 0, ans = 0;
        for (String s : rd.readLine().split(" ")) {
            long tmp = Integer.valueOf(s);
            if (tmp > 0) {
                pCnt += 1;
                ans += (tmp - 1);
            } else if (tmp < 0) {
                nCnt += 1;
                ans += (-1 - tmp);
            } else {
                zCnt += 1;
                ans += 1;
            }
        }

        if (zCnt > 0) {
            // 随意变号
            out.println(ans);
        } else {
            if (nCnt % 2 == 0) {
                out.println(ans);
            } else {
                out.println(ans + 2);
            }
        }
        out.flush();
    }
}
