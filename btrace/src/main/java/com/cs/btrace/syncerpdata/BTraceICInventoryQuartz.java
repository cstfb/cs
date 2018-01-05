package com.cs.btrace.syncerpdata;


import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BTraceICInventoryQuartz {

    /**
     * 监控job开始
     */
    @OnMethod(clazz = "com.tqmall.erp.crontab.IcinventoryJob",
            method = "execute",
            location = @Location(Kind.ENTRY))
    public static void onQuartzBegin(@Self Object self){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + "(" + timeNanos() + "): IcinventoryJob job begin, this=" + hash(self));
    }

    /**
     * 监控清空bi表开始
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.SyncOldErpDataService",
            method = "truncateIcinventoryBatch",
            location = @Location(Kind.ENTRY))
    public static void onTruncateTable(@Self Object self){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + "(" + timeNanos() + "): truncateIcinventoryBatch (BI.ICInventory)  begin, thsi=" + hash(self));
    }


    /**
     * 监控获取数据
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.JustInTimeStockService",
            method = "selectICInventoryAll",
            location = @Location(Kind.ENTRY))
    public static void onSelectData(@Self Object self){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + "(" + timeNanos() + "): selectICInventoryAll  begin, thsi=" + hash(self));
    }

    /**
     * 监控插入数据到bi
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.SyncOldErpDataService",
            method = "insertIcinventoryBatch",
            location = @Location(Kind.ENTRY))
    public static void onInsertData(@Self Object self){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + "(" + timeNanos() + "): insertIcinventoryBatch (BI.ICInventory)  begin, thsi=" + hash(self));
    }


}
