package com.taotao.pojo;

/**
 * Created by Administrator on 2017/8/17.
 */
public class Message {
    private int result;//1 成功 0 失败
    private String errMsg;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
