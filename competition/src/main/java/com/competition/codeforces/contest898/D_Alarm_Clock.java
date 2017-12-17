package com.competition.codeforces.contest898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class D_Alarm_Clock {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int max = 1100010, maxI = 0;
        String[] ar = rd.readLine().split(" ");
        int n = Integer.valueOf(ar[0]), m = Integer.valueOf(ar[1]), k = Integer.valueOf(ar[2]);
        ar = rd.readLine().split(" ");

        int[] alars = new int[n];
        for (int i = 0; i < n; i++) {
            alars[i] = Integer.valueOf(ar[i]);
        }
        Arrays.sort(alars);

        LinkedList<Integer> q = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.getFirst() <= alars[i] - m) {
                q.removeFirst();
            }

            if (q.size() >= k - 1) {ans ++;
//                System.out.println("remove: " + alars[i]);
            }
            else q.add(alars[i]);
        }

        System.out.println(ans);
    }
}

// 12 8 18 25 1
// 1 8 12 18 25
