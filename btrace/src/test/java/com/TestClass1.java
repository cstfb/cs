package com;

import java.util.Random;

public class TestClass1 {
    public static void main(String[] args) throws Exception{
        Random random = new Random();
        while (true) {
            Thread.sleep(1000);
            System.out.println(add(random.nextInt(), random.nextInt()));
        }
    }

    static int add(int a, int b) {
        return a + b;
    }
}
