package com.ecommers.backend.advice;

public class UnexpectedTypeException extends RuntimeException {

    UnexpectedTypeException(String message) {
        super(message);
    }
}
