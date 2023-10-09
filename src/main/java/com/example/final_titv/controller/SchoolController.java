package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;

import com.example.final_titv.service.SchoolService;
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
    private SchoolService schoolService;

    @PostMapping
    public SchoolResponse saveSchool
            (@Valid @RequestBody SchoolRequest schoolRequest) {
        System.out.println(schoolRequest);
        return schoolService.save(schoolRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponse> getSchool(@PathVariable Integer id){
//        return schoolService.getSchoolById(id);
        return ResponseEntity.ok(schoolService.getSchoolWithClassById(id));
    }

    @GetMapping("/withClass/{id}")
    public ResponseEntity<SchoolResponse> getSchoolWithClass(@PathVariable Integer id){
        return ResponseEntity.ok(schoolService.getSchoolWithClassById(id));
    }

    @GetMapping
    public  Page<SchoolResponse> getPageStudentByCondition(
            Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cutoffScore", required = false) Double cutoffScore
    ){
        return schoolService.getPageStudentByCondition(pageable, name, cutoffScore);
    }

    @PutMapping("/{id}")
    public SchoolResponse updateStudentById(@PathVariable Integer id, @RequestBody SchoolRequest schoolRequest){
        return schoolService.updateSchoolById(id, schoolRequest);
    }

    @DeleteMapping("/{id}")
    public SchoolResponse deleteSchool(@PathVariable Integer id){
        return schoolService.deleteById(id);
    }
}
