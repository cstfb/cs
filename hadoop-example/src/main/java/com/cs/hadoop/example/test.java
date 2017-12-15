package com.cs.hadoop.example;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.net.URL;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * Created by fengbo on 17/6/15.
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int asum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            asum += (a[i] * a[i]);
        }
        int m = sc.nextInt();
        int[] bsum = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            if (i != 0) {
                bsum[i] = bsum[i - 1] + b[i] * b[i];
            } else {
                bsum[i] = b[i] * b[i];
            }
        }
        int ret = 0x7fffffff;
        for (int i = 0; i < m - n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[j] * b[i + j];
            }
            int tmpRet;
            if (i == 0){
                tmpRet = asum + bsum[n-1] - 2 * sum;
            } else {
                tmpRet = asum + bsum[n+i-1] - bsum[i-1] - 2 * sum;
            }
            ret = Math.min(ret, tmpRet);
        }
        System.out.println(ret);
    }
}
