package com.competition.codeforces.contest892.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Wrath {
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");

        NodeB[] nodes = new NodeB[n];

        for (int i = 1; i < n; i++) {
            int l = Integer.valueOf(ar[i]);
            if (l == 0) continue;
            int left = i - l >= 0 ? i-l : 0;
            int right = i - 1;
            if (nodes[left] == null)
                nodes[left] = new NodeB();
            if (nodes[right] == null)
                nodes[right] = new NodeB();

            nodes[left].left ++;
            nodes[right].right ++;
        }

        int totalLeft = 0, totalRight = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null){
                if(totalLeft == totalRight)
                    ans ++;
            }

            else {
                totalLeft += nodes[i].left;
                totalRight += nodes[i].right;
            }
        }

        System.out.println(ans);
    }
}


class NodeB{
    public int left = 0;
    public int right = 0;
}