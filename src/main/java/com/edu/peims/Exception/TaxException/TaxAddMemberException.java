package com.edu.peims.Exception.TaxException;

public class TaxAddMemberException extends TaxException{

    public TaxAddMemberException() {
        super(603, "添加成员不符合条件");
    }

    public TaxAddMemberException(int code, String message) {
        super(code, message);
    }
}
