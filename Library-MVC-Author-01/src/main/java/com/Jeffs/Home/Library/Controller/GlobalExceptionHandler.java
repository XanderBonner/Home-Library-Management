package com.Jeffs.Home.Library.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //add exception handling code here

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException exc){
        //create a StudentErrorResponse
        EntityErrorResponse error = new EntityErrorResponse(); //custom error response we created

        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exc){
        //create a StudentErrorResponse
        EntityErrorResponse error = new EntityErrorResponse(); //custom error response we created

        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
