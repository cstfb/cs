package com.cs.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(reader.readLine());
        String s = reader.readLine();
        int len = s.length();

        int s0=0,s1=0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') s0 ++;
            else s1 ++;
        }

        if (s0 == 0 || s1 == 0){
            System.out.println(0);
            return;
        }

        if (s0 == s1){
            System.out.println(len);
            return;
        }

        int[] reverseCount0 = new int[110000];
        Arrays.fill(reverseCount0, 0);
        int[] reverseCount1 = new int[110000];
        Arrays.fill(reverseCount1, 0);
        for (int i = len - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '0'){
                reverseCount0[i] = reverseCount0[i + 1] + 1;
                reverseCount1[i] = reverseCount1[i + 1];
            } else {
                reverseCount0[i] = reverseCount0[i + 1];
                reverseCount1[i] = reverseCount1[i + 1] + 1;
            }
        }

        int[] dp = new int[220000]; int offset = 100001;
        Arrays.fill(dp, -1);
        dp[offset] = len;
        for (int i = len - 1; i >= 0 ; i--) {
            int diff = reverseCount0[i] - reverseCount1[i] + offset;
            if(dp[diff] == -1) dp[diff] = i;
        }

//        for (int i = 0; i < dp.length; i++) {
//            if (dp[i] != -1){
//                System.out.println(i - offset + ":" + dp[i]);
//            }
//        }

        int diff = s0 - s1;
        int cur0 = 0, cur1 = 0;
        int ans = Math.max(0, dp[diff - (cur0 - cur1) + offset]);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') cur0 ++;
            else cur1 ++;

//            System.out.println("cur0:" + cur0 + ",cur1:" + cur1);
//            System.out.println("diff - (cur0 - cur1) :" + (cur0 - cur1 - diff));


            if (dp[diff - (cur0 - cur1) + offset] != -1){
                ans = Math.max(ans, dp[diff - (cur0 - cur1) + offset] - i - 1);
            }
        }
        System.out.println(ans);
    }
}


/*
   s0 = 字符串中0的总个数
   s1 = 字符串中1的总个数
   假设存在一段长度为l的区间中 0的个数 = 1的个数,  lbegin , lend 为开始和结束下标,

   那么有 s0 - (lbegin前的0的个数 + lend后0的总个数) = s1 - (lbegin前1的总个数 + lend后1的总个数)
   -> s0 - s1 = (lbegin前的0的个数 - lbegin前1的总个数) + (lend后0的总个数 - lend后1的总个数)
   -> s0 - s1 为常数
   -> 那么dp求出(lend后0的总个数 - lend后1的总个数)的值对应的最后端的下标即可 , 然后 那么枚举lbegin即可
 */