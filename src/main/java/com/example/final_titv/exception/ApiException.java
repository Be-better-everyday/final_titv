package com.example.final_titv.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
