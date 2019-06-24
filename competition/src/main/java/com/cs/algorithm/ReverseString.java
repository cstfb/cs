package com.cs.algorithm;

public class ReverseString {
    public static void main(String[] args) {
        reverse("hello", 0);
    }

    public static void reverse(String s, int index) {
        int l = s.length();
        if (index != l - 1) {
            reverse(s, index + 1);
        }
        System.out.print(s.charAt(index));
    }
}