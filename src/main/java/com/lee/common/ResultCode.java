package com.lee.common;


/**
 * Created by lee on 02/09/2017.
 */
public enum ResultCode {
    SUCCESS(0, "请求成功"),
    UN_KNOW(-1, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public int getValue() {
        return this.code;
    }
}