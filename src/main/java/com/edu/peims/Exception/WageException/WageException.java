package com.edu.peims.Exception.WageException;

public class WageException extends Exception{
    protected int code;
    protected String message;

    public WageException(int code, String message) {
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
