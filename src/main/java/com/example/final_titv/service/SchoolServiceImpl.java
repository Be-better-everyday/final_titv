package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.mapper.SchoolMapper;
import com.example.final_titv.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{
    private SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;
    // This bean is create using method "getSchoolMapper" in BeanConfig

    public SchoolDto save(SchoolDto schoolDto){
        School school = schoolMapper.toSchool(schoolDto);
        school = schoolRepository.save(school);
        System.out.println(school.getId());
        return schoolMapper.fromSchool(school);
    }
    public SchoolDto getSchoolById(Integer id){
        School school = schoolRepository.findById(id)
                .orElseThrow(()-> new ApiException("Not Found!"));
        return schoolMapper.fromSchool(school);
    }

    public Page<SchoolDto> getPageStudentByCondition(
            Pageable pageable, String name, Double cutoffScore){
        Page<School> schoolPage = schoolRepository.findPageSchoolBySchool(pageable, name, cutoffScore);
        schoolPage.forEach(System.out::println);
        System.out.println("___***___");
        return schoolPage.map(schoolMapper::fromSchool);
    }

    public SchoolDto updateSchoolById(Integer id, SchoolDto schoolDto) {
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");
        schoolMapper.updateSchool(schoolDto, school);
        schoolRepository.save(school);
        return schoolMapper.fromSchool(school);
    }

    public SchoolDto deleteById(Integer id){
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");
        schoolRepository.delete(school);
        return schoolMapper.fromSchool(school);
    }
}
