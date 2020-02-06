package com.wscloudclass.exception;

public class CustomizeException extends RuntimeException {
    private int code;
    private String message;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
