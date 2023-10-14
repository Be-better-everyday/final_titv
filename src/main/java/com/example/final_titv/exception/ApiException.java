package com.example.final_titv.exception;

import lombok.Data;

import java.util.List;

@Data
public class ApiException extends RuntimeException{
    private Class tClass;
    private int errorCode;
    private String status;

    public ApiException(String message, Class tClass) {
        super(message);
        this.tClass = tClass;
    }
}
