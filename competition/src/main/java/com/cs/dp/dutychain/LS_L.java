package com.cs.dp.dutychain;

import java.io.File;

/**
 * Created by fengbo on 16/10/27.
 */
public class LS_L extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return super.L_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls_l(vo.formatData());
    }
}
