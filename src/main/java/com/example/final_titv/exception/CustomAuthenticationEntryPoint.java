package com.example.final_titv.exception;


import com.example.final_titv.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

@Component("customAuthenticationEntryPoint")
@AllArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private ObjectMapper mapper;
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
//        System.out.println("unauthen");


//        RestError re = new RestError(HttpStatus.UNAUTHORIZED.toString(), "Authentication failed");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json");

        CustomErrorException exception = new CustomErrorException(HttpStatus.UNAUTHORIZED, "!___***___Users not found!");
        ErrorResponse errorResponse = new ErrorResponse(exception.getStatus(),
                exception.getMessage());

        OutputStream responseStream = response.getOutputStream();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(responseStream, "unauthen");

        String string = mapper.writeValueAsString(errorResponse);
        System.out.println(string);
        mapper.writeValue(responseStream, errorResponse);
        responseStream.flush();
    }


}