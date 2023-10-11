package com.example.final_titv.controller;

import com.example.final_titv.dto.StudentRequest;
import com.example.final_titv.dto.StudentResponse;
import com.example.final_titv.repository.StudentRepository;
import com.example.final_titv.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(
            @RequestBody StudentRequest studentRequest
    ) {
        System.out.println("___Request___");
        System.out.println(studentRequest);
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public Page<StudentResponse> getStudentPageableByCondition(
            @RequestParam(name = "name", required = false) String partOfFullName,
            Pageable pageable
    ){
        return studentService.getStudentPageableByCondition(partOfFullName, pageable);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(
            @RequestBody StudentRequest studentRequest,
            @PathVariable Integer id
    ) {
        return studentService.updateStudent(studentRequest, id);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteStudentById(@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }

}
