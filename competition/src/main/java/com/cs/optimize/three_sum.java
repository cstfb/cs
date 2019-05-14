package com.cs.optimize;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个数组 和 sum，需要找出三个数a,b,c 使得a + b + c= sum
 */
public class three_sum {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int sum = Integer.valueOf(rd.readLine());
        String[] ars = rd.readLine().split(" ");

        int len = ars.length;
        List<Integer> ar = new ArrayList<>(ars.length);
        // construct hashSet
        HashMap<Integer, List<Integer>> numMap = new HashMap<>(1024);
        for (int i = 0; i < len ; i ++) {
            int v = Integer.valueOf(ars[i]);
            ar.add(v);
            if (!numMap.containsKey(v)) {
                numMap.put(v, new ArrayList<>());
            }
            numMap.get(v).add(i);
        }

        //
        for (int i = 0; i < len ; i ++) {
            for (int j = i + 1 ; j < len ; j++) {
                int ret = sum - ar.get(i) - ar.get(j);

                List<Integer> mt = numMap.get(ret);
                if (mt != null) {
                    for (Integer ind : mt) {
                        if (ind > j) {
                            out.println(ret + " " + ar.get(i) + " " + ar.get(j));
                            break;
                        }
                    }
                }
            }
        }

        out.flush();
    }
}
