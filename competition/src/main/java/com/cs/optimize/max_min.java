package com.cs.optimize;

public class max_min {
    public static void main(String[] args) {
        solve(new long[]{1,2,3,4,5,-1,100});
    }

    public static void solve(long[] arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0 ; i < arr.length; i ++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println("min:" + min);
        System.out.println("max:" + max);
    }
}
