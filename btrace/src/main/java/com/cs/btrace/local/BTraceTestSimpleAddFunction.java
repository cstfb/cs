package com.cs.btrace.local;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BTraceTestSimpleAddFunction {

    @OnMethod(clazz = "com.TestClass1", method = "add", location = @Location(Kind.ENTRY))
    public static void onMethodCall(int a, int b) {
        println("a = " + a + ", b = " + b);
    }
}
