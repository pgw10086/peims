package com.edu.peims.handler;

import com.edu.peims.exception.tax.TaxException;
import com.edu.peims.exception.tax.TaxExistedException;
import com.edu.peims.exception.tax.TaxNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TaxExceptionHandler {

    @ExceptionHandler(TaxNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handlerTaxNotFound(TaxNotFoundException ex) {
        return createResponse(ex);
    }

    @ExceptionHandler(TaxExistedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerTaxExisted(TaxExistedException ex) {
        return createResponse(ex);
    }


    private Map<String, Object> createResponse(TaxException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("message", ex.getMessage());
        return map;
    }
}