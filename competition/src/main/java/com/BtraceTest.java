package com;


import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.annotations.*;

@BTrace
public class BtraceTest {
    @OnMethod(clazz="com.tqmall.reports.web.controller.web.ReportsDetailInfoController",
            method="getInsuranceMailInfo",
            location = @Location(Kind.RETURN))
     public static void onMethodReturn(String st, String et, String sn, int pageNum, int pageSize) {
        println("getInsuranceMailInfo.return, sn = " + sn);
    }

    @OnMethod(clazz="com.tqmall.reports.web.controller.web.ReportsDetailInfoController",
            method="getInsuranceMailInfo",
            location = @Location(Kind.ENTRY))
    public static void onMethodCall(String st, String et, String sn, int pageNum, int pageSize) {
        println("getInsuranceMailInfo.entry, sn = " + sn);
    }

    @OnMethod(clazz="com.tqmall.reports.web.controller.web.ReportsDetailInfoController",
            method="decodeString",
            location = @Location(Kind.ENTRY))
    public static void onMethodDecodeCall(String kw) {
        println("decodeString.entry, kw = " + kw);
    }

    @OnMethod(clazz="com.tqmall.reports.web.controller.web.ReportsDetailInfoController",
            method="decodeString",
            location = @Location(Kind.RETURN))
    public static void onMethodDecode(String kw, @Return String rt) {
        println("decodeString.return, kw = " + kw + ", return = " + rt);
    }
}
