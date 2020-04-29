package com.edu.peims.exception.type;

public class TypeException extends Exception{
    protected int code;
    protected String message;

    public TypeException() {
        this.code = 901;
        this.message = "类型不符合要求";
    }

    public TypeException(int code, String message) {
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
