package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.mapper.SchoolMapper;
import com.example.final_titv.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolService {
    private SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;
    // This bean is create using method "getSchoolMapper" in BeanConfig

//    @Autowired
//    public SchoolService(SchoolRepository schoolRepository) {
//        this.schoolRepository = schoolRepository;
//    }

    public SchoolDto save(SchoolDto schoolDto){
        School school = schoolMapper.toSchool(schoolDto);
        school = schoolRepository.save(school);
        System.out.println(school.getId());
        return schoolMapper.fromSchool(school);
    }

    public void deleteById(Integer id){
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");
        schoolRepository.delete(school);
    }


}
