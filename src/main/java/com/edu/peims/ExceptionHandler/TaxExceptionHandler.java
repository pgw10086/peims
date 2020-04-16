package com.edu.peims.ExceptionHandler;

import com.edu.peims.Exception.TaxExecption.TaxException;
import com.edu.peims.Exception.TaxExecption.TaxNotFoundException;
import com.edu.peims.Exception.UserExecption.UserException;
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

    private Map<String, Object> createResponse(TaxException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("message", ex.getMessage());
        return map;
    }
}