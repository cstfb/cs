package com.cs.dp.dutychain;

import java.util.List;

/**
 * Created by fengbo on 16/10/27.
 */
public abstract class Command {
    public abstract String execute(CommandVo vo);

//    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass) {
//
//    }
}
