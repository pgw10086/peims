package com.edu.peims.ExceptionHandler;

import com.edu.peims.Exception.TypeException.TypeException;
import com.edu.peims.Exception.UserException.UserException;
import com.edu.peims.Exception.UserException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TypeExceptionHandler {
    @ExceptionHandler(TypeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerStudentNotFound(TypeException ex) {
        return createResponse(ex);
    }



    private Map<String, Object> createResponse(TypeException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("message", ex.getMessage());
        return map;
    }
}
