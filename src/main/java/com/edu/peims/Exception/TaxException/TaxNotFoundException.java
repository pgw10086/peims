package com.edu.peims.Exception.TaxException;

public class TaxNotFoundException extends TaxException {
    public TaxNotFoundException() {
        super(601, "Tax rate not found");
    }
}
