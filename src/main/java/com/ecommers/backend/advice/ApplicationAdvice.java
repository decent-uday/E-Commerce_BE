package com.ecommers.backend.advice;

import com.ecommers.backend.dto.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder error = new StringBuilder();
        GenericResponse genericResponse = new GenericResponse();

        ex.getBindingResult().getFieldErrors().forEach(er -> {
            error.append(er.getDefaultMessage());
        });
        genericResponse.setMessage(error.toString());
        genericResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    static ResponseEntity<GenericResponse> handleUnexpectedTypeException(UnexpectedTypeException ex){
        log.error("ApplicationAdvice :: UnexpectedTypeException ");
        ex.printStackTrace();
        GenericResponse genericResponse = new GenericResponse();
        if (ex.getCause() != null) {
            genericResponse.setMessage(ex.getCause().getMessage());
        } else {
            genericResponse.setMessage(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    }
}
