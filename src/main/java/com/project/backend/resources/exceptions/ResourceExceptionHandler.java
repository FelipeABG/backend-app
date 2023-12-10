package com.project.backend.resources.exceptions;

import com.project.backend.services.exceptions.DataBaseException;
import com.project.backend.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
        String msg = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), msg, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException (DataBaseException e, HttpServletRequest request){
        String msg = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), msg, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
