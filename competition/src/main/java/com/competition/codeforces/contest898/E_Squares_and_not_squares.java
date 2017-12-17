package com.competition.codeforces.contest898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class E_Squares_and_not_squares {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");

        node[] list = new node[n];
        for (int i = 0; i < n; i++) {
            list[i] = new node();
            list[i].v = Integer.valueOf(ar[i]);

            long sqrt = (long)Math.sqrt(list[i].v);
            if (sqrt * sqrt != list[i].v) {
                 list[i].b = Math.min((sqrt+1) * (sqrt + 1) - list[i].v,
                         list[i].v - sqrt * sqrt);
            }

//            System.out.println(list[i].b);
        }

        Arrays.sort(list, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                int f1 =  (int)(o1.b - o2.b);
                if (f1 != 0) return f1;
                else return (int)(o1.v - o2.v);
            }
        });


        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += list[i].b;
//            System.out.println(ans);
        }

        for (int i = n/2; i < n; i++) {
            if (list[i].b == 0) {
                if (list[i].v == 0) ans += 2;
                else ans += 1;
            }
        }

        System.out.println(ans);
    }
}


class node{
    public long v = 0;
    public long b = 0;
}