package com.edu.peims.exception.tax;

public class TaxNotFoundException extends TaxException {
    public TaxNotFoundException() {
        super(601, "Tax rate not found");
    }
}
