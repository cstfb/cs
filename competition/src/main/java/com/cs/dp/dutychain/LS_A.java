package com.cs.dp.dutychain;

/**
 * Created by fengbo on 16/10/27.
 */
public class LS_A extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return super.A_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls_a(vo.formatData());
    }
}
