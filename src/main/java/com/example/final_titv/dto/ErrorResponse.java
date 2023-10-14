package com.example.final_titv.dto;

import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse {
    private String message;
    private int errorCode;
    private String status;
    private Long timestamp;

    public ErrorResponse(String message, int errorCode, String status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }
}
