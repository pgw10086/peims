package com.edu.peims.Exception.WageException;

public class WageNotFoundException extends WageException{

    public WageNotFoundException() {
        super(621, "MonthWage not found");
    }
}
