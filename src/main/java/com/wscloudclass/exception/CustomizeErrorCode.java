package com.wscloudclass.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    ERROR_REGISTER(2001,"未知原因,注册出现异常,请稍后重试!"),
    ERROR_CREATE_COURSE(2002,"未知原因，班课创建失败,请稍后重试!"),
    ERROR_JOIN_COURSE(2003,"位置原因，加入班课失败,请稍后重试!");

    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
    CustomizeErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
