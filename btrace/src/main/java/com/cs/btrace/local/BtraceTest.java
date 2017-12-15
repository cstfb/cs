package com.cs.btrace.local;


import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BtraceTest {
    @OnMethod(clazz="com.cs.cs.Calculator", method="add", location = @Location(Kind.RETURN))
    public static void onMethod(@Self Object self, AnyType a, AnyType b, @Return int sum, @Duration long duration) {
        println("btrace(add):" + name(classOf(a.toString())) + ":a=" + a + ",b=" + b + ",sum=" + sum + ",duration=" + duration + "ns");
    }

    @OnMethod(clazz = "com.cs.cs.Calculator", method = "add", location = @Location(Kind.THROW))
    public static void onThrow(Throwable throwable) {
        println("throw a exception : " + name(classOf(throwable)));
    }

    @OnMethod(clazz = "com.cs.cs.Calculator", method = "add", location = @Location(Kind.CATCH))
    public static void onCatch(Throwable throwable) {
        println("catch a exception:" + name(classOf(throwable)));
    }

    @OnMethod(clazz = "com.cs.cs.Calculator", method = "add", location = @Location(Kind.ERROR))
    public static void onError(Throwable throwable, @Duration long duration) {
        println("error a exception:" + name(classOf(throwable)));
    }

    @OnMethod(clazz = "com.cs.cs.Calculator", method = "add", location = @Location(value = Kind.LINE, line = -1))
    public static void onEveryLine(int line) {
        println("executing line:" + line);
    }

    @OnMethod(clazz = "com.cs.cs.Calculator", method = "add", location = @Location(value = Kind.CALL, clazz = "java.io.PrintStream", method = "/.*/"))
    public static void onPring(@TargetInstance Object obj, @TargetMethodOrField String method) {
        println("call method:" + name(classOf(obj)) + "." + method);
    }
}