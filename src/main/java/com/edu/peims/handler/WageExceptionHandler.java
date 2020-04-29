package com.edu.peims.handler;

import com.edu.peims.exception.wage.WageException;
import com.edu.peims.exception.wage.WageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class WageExceptionHandler {
    @ExceptionHandler(WageNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handlerStudentNotFound(WageNotFoundException ex) {
        return createResponse(ex);
    }

    private Map<String, Object> createResponse(WageException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("message", ex.getMessage());
        return map;
    }
}
