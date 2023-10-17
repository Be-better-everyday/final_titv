package com.example.final_titv.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    // Jackson JSON serializer instance
    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exception
    ) throws IOException, ServletException {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN; // 403

        Map<String, Object> data = new HashMap<>();
        data.put(
                "timestamp**",
                new Date()
        );
        data.put(
                "code",
                httpStatus.value()
        );
        data.put(
                "status",
                httpStatus.name()
        );
        data.put(
                "message",
                exception.getMessage()
        );

        // setting the response HTTP status code
        response.setStatus(httpStatus.value());
        response.setContentType("application/json");

//        response.
        // serializing the response body in JSON
        response
                .getOutputStream()
                .println(
                        objectMapper.writeValueAsString(data)
                );
//        OutputStream responseStream = response.getOutputStream();
//        mapper.writeValue(responseStream, errorResponse);
//        responseStream.flush();
    }
}
