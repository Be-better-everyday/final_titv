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

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Integer id) throws JsonProcessingException {
        School referenceById = schoolRepository.findById(id).orElse(null);
        System.out.println("_______________");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(referenceById);
//        System.out.println(json);
        return ResponseEntity.status(HttpStatus.FOUND).body(referenceById);
    }

    @GetMapping("/notNull/{id}")
    public School getSchoolByIdNotNull(@PathVariable Integer id) {
        School referenceById = schoolRepository.findById(id).orElse(null);
        System.out.println("_______________");
        return referenceById;
    }

    @GetMapping("/eager/{id}")
    public ResponseEntity<School> getSchoolByIdEager(@PathVariable Integer id) throws JsonProcessingException {

        School referenceById = schoolRepository.findByIdJoinFetchTClassSet(id);
        System.out.println("_______________");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(referenceById);
//        System.out.println(json);
        return ResponseEntity.status(HttpStatus.FOUND).body(referenceById);
    }
}
