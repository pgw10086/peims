package com.edu.peims.Exception.UserExecption;

public class UserException extends Exception{
    protected int code;
    protected String message;

    public UserException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
