package com.ft.backend.work.client.common;

/**
 * Created by huanghongyi on 2016/11/8.
 */
public enum ResultCode {

    SYSTEM_ERROR(-2, "系统内部错误"),
    FAILED(-1, "操作失败，请刷新后重试"),
    SUCCESS(0, "操作成功"),
    ILLEGAL_ARGUMENT(1, "非法的请求参数"),
    NO_PERMISSION(2, "无权操作"),
    No_RECORD_FOUND(3,"无查询记录"),
    REMOTE_INVOKE_ERP_INTERFACE_ERROR(4, "调用ERP接口错误，请稍后重试！"),
    PIN_NOT_EXIST(5,"用户pin不存在！"),

//user
    USER_USERNAME_NULL(100,"用户名为空"),

    USER_PASSWORD_NULL(101,"密码为空"),










    UN_KNOW(999, "未知异常");

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int code;

    public String msg;

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


}
