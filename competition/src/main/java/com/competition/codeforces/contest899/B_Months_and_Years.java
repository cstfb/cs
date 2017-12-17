package com.competition.codeforces.contest899;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Months_and_Years {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{

        String typ1 = "31 28 31 30 31 30 31 31 30 31 30 31";
//        typ1 = typ1 + " " + typ1 + " " + typ1 + " " + typ1 + " " + typ1;

        String typ2 = "31 29 31 30 31 30 31 31 30 31 30 31";
//        typ1 = typ1 + " " + typ1 + " " + typ1 + " " + typ1 + " " + typ1;

        int n = Integer.valueOf(rd.readLine());
        String p = rd.readLine();
        if ((typ1 + " " + typ1 + " " + typ1).contains(p) ||
                (typ1 + " " + typ1 + " " + typ2).contains(p) ||
                (typ1 + " " + typ2 + " " + typ1).contains(p) ||
                (typ2 + " " + typ1 + " " + typ1).contains(p) ||
                (typ2 + " " + typ1 + " " + typ2).contains(p)
                ) System.out.println("YES");
        else System.out.println("NO");
    }
}
