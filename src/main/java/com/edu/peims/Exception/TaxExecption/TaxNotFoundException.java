package com.edu.peims.Exception.TaxExecption;

public class TaxNotFoundException extends TaxException {
    public TaxNotFoundException() {
        super(404, "TAX RATE NOT FOUND");
    }
}
