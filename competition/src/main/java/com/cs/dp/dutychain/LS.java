package com.cs.dp.dutychain;

/**
 * Created by fengbo on 16/10/27.
 */
public class LS extends AbstractLS {

    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVo vo) {
        return FileManager.ls(vo.formatData());
    }
}
