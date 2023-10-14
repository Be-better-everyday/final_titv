package com.example.final_titv.exception;

import lombok.Data;

import java.util.List;

public class NotFoundException extends ApiException{
    public NotFoundException(String message, Class tClass) {
        super(message, tClass);
        setStatus(tClass.getSimpleName() + " is not found!");
        setErrorCode(404);
    }
}
