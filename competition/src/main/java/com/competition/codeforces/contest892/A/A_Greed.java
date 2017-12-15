package com.competition.codeforces.contest892.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class A_Greed {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(rd.readLine());
        Node[] nodes = new Node[n];
        String[] ar = rd.readLine().split(" ");
        long sum = 0;
        for (int i = 0; i < ar.length; i++) {
            nodes[i] = new Node();
            nodes[i].rm = Long.valueOf(ar[i]);
            sum += nodes[i].rm;
        }
        ar = rd.readLine().split(" ");
        for (int i = 0; i < ar.length; i++) {
            nodes[i].cp = Long.valueOf(ar[i]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o2.cp - o1.cp);
            }
        });

        long total = nodes[0].cp + nodes[1].cp - sum;

        if (total >= 0) System.out.println("YES");
        else System.out.println("NO");
    }
}

class Node{
    public long rm=-1;
    public long cp=-1;
}
