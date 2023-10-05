package com.example.final_titv.controller;

import com.example.final_titv.entity.School;
import com.example.final_titv.repository.SchoolRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {
    private SchoolRepository schoolRepository;


}
