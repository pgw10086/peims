package com.edu.peims.exception.wage;

public class WageNotFoundException extends WageException{

    public WageNotFoundException() {
        super(621, "MonthWage not found");
    }
}
