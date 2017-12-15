package com.cs.cs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fengbo on 16/7/23.
 */
public class F {
    public static void main(String[] args) {
        Integer i = 300000;
        System.out.println(Integer.highestOneBit(i) << 1);
        System.out.println(1 << 18);
    }

    static void p(int... ints) {
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
