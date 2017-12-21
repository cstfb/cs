package com.competition.codeforces.contest902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Coloring_a_Tree {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");
        Node2[] head = new Node2[n+1];
        Node2[] tail = new Node2[n+1];
        for (int i = 0; i < n-1; i++) {
            int v = Integer.valueOf(ar[i]);

            if (head[i+2] == null) {
                head[i+2] = new Node2(v);
                tail[i+2] = head[i+2];
            } else {
                Node2 nt = new Node2(v);
                tail[i+2].next = nt;
                tail[i+2] = nt;
            }

            if (head[v] == null) {
                head[v] = new Node2(i+2);
                tail[v] = head[v];
            } else {
                Node2 nt = new Node2(i+2);
                tail[v].next = nt;
                tail[v] = nt;
            }
        }


        int[] colors = new int[n+1];
        ar = rd.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            colors[i + 1] = Integer.valueOf(ar[i]);
        }

        System.out.println(dfs(-1, -1, 1, head, colors));
    }

    public static int dfs(int father, int fatherColor, int curVertical, Node2[] headAr, int[] colors) {
        int targetColor = colors[curVertical];
        int ans = 0;
        if (targetColor != fatherColor) {
            ans = 1;
        }
        Node2 node = headAr[curVertical];
        while (node != null) {
            if (node.v != father) {
                ans += dfs(curVertical, targetColor, node.v, headAr, colors);
            }

            //
            node = node.next;
        }

//        System.out.println("father:" + father + ", curV:" + curVertical + ", ans:" + ans);

        return ans;
    }
}


class Node2{
    public int v = 0;
    public Node2 next = null;

    public Node2(int _v) {
        this.v = _v;
    }
}