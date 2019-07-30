package com.cs.cs.web.testcode.jvm.helper;

import java.util.ArrayList;
import java.util.List;

public class SimpleClass1 {
    List<String> list = new ArrayList<>();
    SimpleClass2 class2 = new SimpleClass2();

    public SimpleClass1() {
        System.out.println("SimpleClass1.classLoader is:");
        System.out.println(this.getClass().getClassLoader().getClass().getName());

        System.out.println("SimpleClass2.classLoader is:");
        System.out.println(class2.getClass().getClassLoader().getClass().getName());

        System.out.println("list.classLoader is:");
        if (list.getClass().getClassLoader() != null) {
            System.out.println(list.getClass().getClassLoader().getClass().getName());
        } else {
            System.out.println("null");
        }
    }
}
