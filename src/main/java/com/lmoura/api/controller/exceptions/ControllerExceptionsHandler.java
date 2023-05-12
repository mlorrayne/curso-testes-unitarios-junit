package com.lmoura.api.controller.exceptions;

import com.lmoura.api.service.exceptions.DataIntegretyViolationException;
import com.lmoura.api.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.ObjectStreamException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(ObjectStreamException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(DataIntegretyViolationException.class)
    public ResponseEntity<StandardError> dataIntegretyViolationException(DataIntegretyViolationException ex, HttpServletRequest request){
        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
