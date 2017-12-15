package com.cs.cs;

import java.util.*;


public class test {

    public static void main(String[] args) throws Exception {
        try {
            Calculator calculator = new Calculator();
            while (true) {
                Random random = new Random();
                System.out.println(calculator.add(random.nextInt(100), random.nextInt(10000)));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


