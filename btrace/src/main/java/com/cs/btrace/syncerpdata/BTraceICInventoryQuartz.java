package com.cs.btrace.syncerpdata;


import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BTraceICInventoryQuartz {

    /**
     * 监控job开始
     */
    @OnMethod(clazz = "com.tqmall.erp.crontab.IcinventoryJob",
            method = "execute",
            location = @Location(Kind.ENTRY))
    public static void onQuartzBegin(){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + ": IcinventoryJob job begin");
    }

    /**
     * 监控清空bi表开始
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.SyncOldErpDataService",
            method = "truncateIcinventoryBatch",
            location = @Location(Kind.ENTRY))
    public static void onTruncateTable(){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + ": truncateIcinventoryBatch (BI.ICInventory)  begin");
    }


    /**
     * 监控获取数据
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.JustInTimeStockService",
            method = "selectICInventoryAll",
            location = @Location(Kind.ENTRY))
    public static void onSelectData(){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + ": selectICInventoryAll  begin");
    }

    /**
     * 监控插入数据到bi
     */
    @OnMethod(clazz = "+com.tqmall.erp.service.SyncOldErpDataService",
            method = "insertIcinventoryBatch",
            location = @Location(Kind.ENTRY))
    public static void onInsertData(){
        println(timestamp("yyyy-MM-dd HH:mm:ss") + ": insertIcinventoryBatch (BI.ICInventory)  begin");
    }


}
