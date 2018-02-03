package com.cs.cs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

public class A {

    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        A a = new A();
        a.getA();
    }

    static <T> void doit(A it, A b){
        A a = (A)it;
        T itt = (T)b;

    }

}

