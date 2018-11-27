package com.ifchange.nlplabel.constant;

/**
 * @ClassName: ResponseCode
 * @Description: 请求状态
 * @author: Dieson Zuo
 * @date: Created in 16:12 2018/11/14
 */
public enum ResponseCode {
    SUCCESS(1000, "请求成功"),
    PARAM_CORRECT(1001, "参数正确"),
    ERROR(2001, "请求失败"),
    PARAM_INCORRECT(2002, "参数错误"),
    LOGIN_FAIL(4003, "Not logged in.");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
