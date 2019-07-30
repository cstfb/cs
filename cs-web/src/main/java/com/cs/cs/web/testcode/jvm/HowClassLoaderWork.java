package com.cs.cs.web.testcode.jvm;

import com.cs.cs.web.testcode.jvm.helper.SimpleClass1;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class HowClassLoaderWork {

    public static void main(String[] args) throws Exception {
        SimpleClass1 class1 = new SimpleClass1();
        // 这边parent设置为null
        // 验证loadClass中引用的类也需要这个classLoader来进行加载
        URLClassLoader classLoader = new URLClassLoader(
                new URL[]{ new URL("file:/Users/tianfengbo/IdeaProjects/cs/cs-web/target/cs.jar") },
                null);

        Class clz = classLoader.loadClass("com.cs.cs.web.testcode.jvm.helper.SimpleClass1");
        // ok
        Object object = clz.newInstance();
        System.out.println(object.getClass().getName());
        // error
        SimpleClass1 obj = (com.cs.cs.web.testcode.jvm.helper.SimpleClass1)clz.newInstance();

//        obj = class1;
    }

}