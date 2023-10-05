package com.example.final_titv.service;

import com.example.final_titv.entity.School;
import com.example.final_titv.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolService {
    private SchoolRepository schoolRepository;

    public School save(School school){
        return schoolRepository.save(school);
    }
    public void deleteById(Integer id){
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");
        schoolRepository.delete(school);
    }

//    public School update(Integer id, School school){
//
//    }
}
