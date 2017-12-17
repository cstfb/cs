package com.competition.codeforces.contest898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Proper_Nutrition {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{

        int n = Integer.valueOf(rd.readLine());
        int a = Integer.valueOf(rd.readLine());
        int b = Integer.valueOf(rd.readLine());

        int to = a >= b ? n / a : n /b ;

        for (int i = 0; i <= to; i++) {
            if (a >= b && (n - a * i) % b == 0) {
                System.out.println("YES");
                System.out.println(i + " " + ((n - a * i) / b));
                return;
            } else if (a < b && (n - b * i) % a == 0) {
                System.out.println("YES");
                System.out.println((n - b * i) / a + " " + i);
                return;
            }
        }

        System.out.println("NO");
    }
}
