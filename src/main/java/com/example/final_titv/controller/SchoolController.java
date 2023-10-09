package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;

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
    public SchoolResponse saveSchool
            (@Valid @RequestBody SchoolRequest schoolRequest) {
        System.out.println(schoolRequest);
        return schoolServiceImpl.save(schoolRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponse> getStudent(@PathVariable Integer id){
//        return schoolService.getSchoolById(id);
        return ResponseEntity.ok(schoolServiceImpl.getSchoolById(id));
    }

    @GetMapping
    public  Page<SchoolResponse> getPageStudentByCondition(
            Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cutoffScore", required = false) Double cutoffScore
    ){
        return schoolServiceImpl.getPageStudentByCondition(pageable, name, cutoffScore);
    }

    @PutMapping("/{id}")
    public SchoolResponse updateStudentById(@PathVariable Integer id, @RequestBody SchoolRequest schoolRequest){
        return schoolServiceImpl.updateSchoolById(id, schoolRequest);
    }

    @DeleteMapping("/{id}")
    public SchoolResponse deleteSchool(@PathVariable Integer id){
        return schoolServiceImpl.deleteById(id);
    }
}
