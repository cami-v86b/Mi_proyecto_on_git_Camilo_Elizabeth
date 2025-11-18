package com.example.Emailback.exception;


import com.example.Emailback.utils.GenericResponse;
import com.example.Emailback.utils.Global;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class GenericExceptionHandler {
    @ExceptionHandler
    public GenericResponse genericExceptionHandler(Exception ex) {
        return new GenericResponse("exception",-1, Global.OPERACION_ERRONEA,ex.getMessage());
}
}
