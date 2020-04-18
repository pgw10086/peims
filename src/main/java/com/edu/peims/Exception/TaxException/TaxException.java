package com.edu.peims.Exception.TaxException;

public class TaxException extends Exception{
    protected int code;
    protected String message;

    public TaxException(int code, String message) {
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
