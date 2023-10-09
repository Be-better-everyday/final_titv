package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;

import com.example.final_titv.service.TClassService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class TClassController {
    private TClassService tClassService;

    @PostMapping
    public TClassResponse saveTClass( @RequestBody TClassRequest tClassRequest){
        return tClassService.saveTClass(tClassRequest);
    }

    @GetMapping("/{id}")
    public TClassResponse getTClassById(@PathVariable Integer id){
        return tClassService.getTClassById(id);
    }
}
