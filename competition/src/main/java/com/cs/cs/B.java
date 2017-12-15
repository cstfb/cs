package com.cs.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {

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

        int[] rAcc1 = new int[len]; Arrays.fill(rAcc1, 0);
        int[] lAcc1 = new int[len]; Arrays.fill(lAcc1, 0);
        for (int i = 0; i < len; i++) {     //正向累加
            if (s.charAt(i) == '1') {
                if (i == 0) lAcc1[i] = 1;
                else lAcc1[i] = lAcc1[i-1]+1;
            }
        }
        for (int i = len-1; i >=0 ; i--) {  //反向累加
            if (s.charAt(i) == '1') {
                if (i == len - 1) rAcc1[i] = 1;
                else rAcc1[i] = rAcc1[i + 1] + 1;
            }
        }

        int begin = 0, end=len-1;

        while (s0 != s1){
            if (begin == end){
                System.out.println(0);
                return;
            }
            if (s0 > s1){
                if (s.charAt(begin) == '0'){
                    begin ++ ;
                    s0 --;
                } else if (s.charAt(end) == '0'){
                    end --;
                    s0 --;
                } else {
                    int ri = findRightMostExists(s, rAcc1, '0', begin, end);
                    int li = findLeftMostChar(s, lAcc1, '0', begin, end);
                    if (ri == -1 && li == -1) {
                        System.out.println(0);
                        return;
                    } else if (ri == -1){
                        int v = li - begin;
                        s1 -= v;
                        begin += v;
                    } else if (li == -1){
                        int v = end - ri;
                        s1 -= v;
                        end -= v;
                    } else {
                        if (end - ri > li - begin){
                            int v = li - begin;
                            s1 -= v;
                            begin += v;
                        } else {
                            int v = end - ri;
                            s1 -= v;
                            end -= v;
                        }
                    }
                }
            } else {
                if (s.charAt(begin) == '1'){
                    begin ++ ;
                    s1 --;
                } else if(s.charAt(end) == '1'){
                    end --;
                    s1 --;
                } else {
                    int ri = findRightMostExists(s, rAcc1, '1', begin, end);
                    int li = findLeftMostChar(s, lAcc1, '1', begin, end);
                    if (ri == -1 && li == -1) {
                        System.out.println(0);
                        return;
                    } else if (ri == -1){
                        int v = li - begin;
                        s0 -= v;
                        begin += v;
                    } else if (li == -1){
                        int v = end - ri;
                        s0 -= v;
                        end -= v;
                    } else {
                        if (end - ri > li - begin){
                            int v = li - begin;
                            s0 -= v;
                            begin += v;
                        } else {
                            int v = end - ri;
                            s0 -= v;
                            end -= v;
                        }
                    }
                }
            }
        }
        System.out.println(s0 * 2);
    }

    public static int findRightMostExists(String s ,int[] rAcc1, char ch, int begin, int end){
        while (begin < end){
            if (s.charAt(end) == ch) return end;
            if (s.charAt(begin) ==  ch && end - begin == 1) return begin;
            if (end - begin == 1) break;

            int mid = (begin + end) / 2;
            int midv = 0;
            if (ch == '0'){
                midv = end - mid - (rAcc1[mid] - rAcc1[end]);
            } else {
                midv = rAcc1[mid] - rAcc1[end];
            }

            if (midv > 0){
                begin = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    public static int findLeftMostChar(String s, int[] lAcc1, char ch, int begin, int end){
        while (begin < end){
            if (s.charAt(begin) == ch) return begin;
            if (s.charAt(end) ==  ch && end - begin == 1) return end;
            if (end - begin == 1) break;

            int mid = (begin + end) / 2;
            int midv = 0;
            if (ch == '0'){
                midv = mid - begin - (lAcc1[mid] - lAcc1[begin]);
            } else {
                midv = lAcc1[mid] - lAcc1[begin];
            }

            if (midv > 0){
                end = mid;
            } else {
                begin = mid;
            }
        }
        return -1;
    }
}