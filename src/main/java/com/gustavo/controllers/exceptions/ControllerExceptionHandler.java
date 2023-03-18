package com.gustavo.controllers.exceptions;

import com.gustavo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException err, HttpServletRequest request) {
        HttpStatus stts = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(),
                stts.value(),
                "Not found",
                err.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(stts).body(error);
    }
}
