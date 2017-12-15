package com.competition.codeforces.contest892.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C_Pride {
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(rd.readLine());
        String[] ar = rd.readLine().split(" ");
        int[] v= new int[n];

        int gcd = 0;
        for (int i = 0; i < n; i++) {
            v[i] = Integer.valueOf(ar[i]);
            gcd = gcd(gcd, v[i]);
        }
        if (gcd != 1){
            System.out.println(-1);
            return;
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (v[i] == 1){
                for (int j = 0; j < n; j++) {
                    if (v[j] > 1) ans ++;
                }
                System.out.println(ans);
                return;
            }
        }

        ans = 100000000;
        for (int i = 0; i < n; i++) {
            gcd = 0;
            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, v[j]);
                if (gcd  == 1){
                    ans = Math.min(ans, n - 1 + j - i);
                }
            }
        }
        System.out.println(ans);
    }

    static int gcd(int a, int b){
        if (a == 0 || b == 0) return a + b;
        if (a < b) return gcd(b, a);
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
