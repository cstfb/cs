package com.cs.dp.dutychain;

/**
 * Created by fengbo on 16/10/27.
 */
public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVo vo) {
        //
        String result = "";
//
        if (vo.getParam().size() == 0 || vo.getParam().contains(this.getOperateParam())) {
            result = this.echo(vo);
        } else {
            if (this.nextOperator != null) {
                result = this.nextOperator.handleMessage(vo);
            } else {
                result = "";
            }
        }

        return result;
    }

    //
    public void setNext(CommandName _operator) {
        this.nextOperator = _operator;
    }

    //
    protected abstract String getOperateParam(); //

    protected abstract String echo(CommandVo vo);

}
