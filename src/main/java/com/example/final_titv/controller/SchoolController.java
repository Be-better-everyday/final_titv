package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.dto.view.Views;
import com.example.final_titv.entity.School;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.service.SchoolService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/school")

public class SchoolController {
    private SchoolService schoolService;

    @PostMapping
    public SchoolDto saveSchool
            (@Valid @RequestBody @JsonView(Views.InputView.class) SchoolDto schoolDto) {
        System.out.println(schoolDto);
        return schoolService.save(schoolDto);
    }
}
