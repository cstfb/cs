package com.cs.cs.utils;

import java.util.Random;

public class SimpleSegmentTree {
    public static void main(String[] args) {
        long[] ar = new long[]{
                1927284205,1106640261,-1936153496,-2123000207,-1957881399,1542953328,-1468104529,-1240008276,2025713567,1511080661
        };
        SimpleSegmentTree sst = new SimpleSegmentTree(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " " ) ;
        }
        System.out.println();
        /**
         *
         */
        for (int i = 0; i < ar.length; i++) {
            System.out.print(sst.getRangeMin(i, i) + " ");
        }
        System.out.println();
//        System.out.debuginfo(sst.getRangeMin(-1  , -1));
        System.out.println(sst.getRangeMin(100  , 100));

        /**
         *
         */
        for (int i = 0; i < ar.length; i++) {
            System.out.print(sst.getRangeMax(i,i) + " ");
        }
        System.out.println();
//        System.out.debuginfo(sst.getRangeMax(-1  , -1));
        System.out.println(sst.getRangeMax(100  , 100));

        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                System.out.print(sst.getRangeMin(i, j) + "(" + i+","+j+")" + " ");
            }
            System.out.println();
        }

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(r.nextInt() + ",");
        }


    }

    private long[] array ;
    private int length ;
    private long[][] max ;
    private long[][] min ;
    private int[] log ;

    private static int MAX_LEN = 1000010;
    private static int MAX_HEI = 20 ;

    public SimpleSegmentTree(long[] ar){
        this(ar , ar.length);
    }

    public SimpleSegmentTree(long[] ar , int lengthToProcess){
        array = ar ;
        length = lengthToProcess > ar.length ? ar.length : lengthToProcess;
        init();
    }

    private void init(){
        max = new long[MAX_HEI][MAX_LEN];
        min = new long[MAX_HEI][MAX_LEN];
        log = new int[MAX_LEN];

        log[0] = log[1] = 0 ;
        for (int i = 2; i <= length; i++) {
            log[i] = log[i/2] + 1;
        }
        for (int i = 0; i < length; i++) {
            max[0][i] = array[i];
            min[0][i] = array[i];
        }
        for (int k = 1; k < MAX_HEI; k++) {
            for (int i = 0; i + (1<<k) <= length; i++) {
                max[k][i] = Math.max(max[k-1][i] , max[k-1][i+(1<<(k-1))]);
                min[k][i] = Math.min(min[k-1][i] , min[k-1][i+(1<<(k-1))]);
            }
        }
    }

    public long getRangeMin(int l , int r){
        r++;
        int k = log[r - l];
        return Math.min(min[k][l] , min[k][r-(1<<k)]);
    }

    public long getRangeMax(int l , int r){
        r++;
        int k = log[r - l];
        return Math.max(max[k][l], max[k][r - (1 << k)]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString();
    }

//    private void printSst(){
//        for (int i = 0; i < log[length]; i++) {
//            for (int j = 0; j + (1 << i) <= length ; j++) {
//                System.out.print(min[i][j]+ "(" + i+","+j+")" + " ");
//            }
//        }
//    }
}
