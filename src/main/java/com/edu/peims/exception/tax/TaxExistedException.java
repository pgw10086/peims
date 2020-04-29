package com.edu.peims.exception.tax;

public class TaxExistedException extends TaxException{
    public TaxExistedException() {
        super(641, "Tax rate range already exists");
    }
}
