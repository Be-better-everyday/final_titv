package com.example.final_titv.exception;

import com.example.final_titv.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(CustomErrorException.class)
    public ResponseEntity<ErrorResponse> catchError(Exception ex) {
        CustomErrorException customErrorException = (CustomErrorException) ex;
        HttpStatus status = customErrorException.getStatus();

        ErrorResponse errorResponse = new ErrorResponse(status,
                customErrorException.getMessage() + "___*___");

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> catchErrorSQL(Exception ex) {
//        DataIntegrityViolationException exception =
//                (DataIntegrityViolationException) ex;

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorResponse errorResponse = new ErrorResponse(status,
                ex.getMessage() + "___*___");

        return new ResponseEntity<>(errorResponse, status);

    }
}