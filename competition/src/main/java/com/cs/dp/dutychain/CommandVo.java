package com.cs.dp.dutychain;

import java.util.List;

/**
 * Created by fengbo on 16/10/27.
 */
public abstract class CommandVo {
    abstract List getParam();
    abstract String formatData();
}
