package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.dto.view.Views;
import com.example.final_titv.service.SchoolServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/school")

public class SchoolController {
    private SchoolServiceImpl schoolServiceImpl;

    @PostMapping
    public SchoolDto saveSchool
            (@Valid @RequestBody @JsonView(Views.Request.class) SchoolDto schoolDto) {
        System.out.println(schoolDto);
        return schoolServiceImpl.save(schoolDto);
    }

    @GetMapping("/{id}")
//    @JsonView(Views.Request.class)
    public ResponseEntity<SchoolDto> getStudent(@PathVariable Integer id){
//        return schoolService.getSchoolById(id);
        return ResponseEntity.ok(schoolServiceImpl.getSchoolById(id));
    }

    @GetMapping
    public  Page<SchoolDto> getPageStudentByCondition(
            Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cutoffScore", required = false) Double cutoffScore
    ){
        return schoolServiceImpl.getPageStudentByCondition(pageable, name, cutoffScore);
    }

    @PutMapping("/{id}")
    public SchoolDto updateStudentById(@PathVariable Integer id, @RequestBody SchoolDto schoolDto){
        return schoolServiceImpl.updateSchoolById(id, schoolDto);
    }

    @DeleteMapping("/{id}")
    public SchoolDto deleteSchool(@PathVariable Integer id){
        return schoolServiceImpl.deleteById(id);
    }
}
