package com.example.final_titv.controller;

import com.example.final_titv.dto.ErrorResponse;
import com.example.final_titv.dto.TeacherRequest;
import com.example.final_titv.dto.TeacherResponse;
import com.example.final_titv.exception.NotFoundException;
import com.example.final_titv.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @PostMapping
    public TeacherResponse saveTeacher(
            @RequestBody TeacherRequest teacherRequest
    ) {
//        teacherRequest.setId(null);
        return teacherService.saveTeacher(teacherRequest);
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(
            @PathVariable Integer id
    ){
        return teacherService.getTeacherById(id);
    }

    @GetMapping
    public Page<TeacherResponse> getTeacherPageableByCondition(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "className", required = false) String className,
            Pageable pageable
    ){
        return teacherService.getTeacherPageableByCondition(name, className, pageable);
    }

    @PutMapping("/{id}")
    public TeacherResponse updateTeacherById(
            @PathVariable Integer id,
            @RequestBody TeacherRequest teacherRequest
    ){
        return teacherService.updateTeacherById(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public TeacherResponse deleteTeacherById(
            @PathVariable Integer id
    ){
        return teacherService.deleteTeacherById(id);
    }

    @PutMapping("/addClass/{id}")
    public TeacherResponse addTClassToTeacher(
            @RequestParam Integer classId,
            @PathVariable Integer id
    ){
        return teacherService.addTClassToTeacher(classId, id);
    }



}
