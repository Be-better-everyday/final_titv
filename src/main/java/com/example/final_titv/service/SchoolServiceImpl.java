package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.mapper.SchoolMapper;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{
    private SchoolRepository schoolRepository;
    private TClassRepository tClassRepository;

    private SchoolMapper schoolMapper;
    // This bean is create using method "getSchoolMapper" in BeanConfig

    public SchoolDto save(SchoolDto schoolDto){
        School school = schoolMapper.toEntity(schoolDto);
        school = schoolRepository.save(school);
//        System.out.println(school.getId());
        return schoolMapper.toDto(school);
    }
    public SchoolDto getSchoolById(Integer id){
        School school = schoolRepository.findById(id)
                .orElseThrow(()-> new ApiException("Not Found!"));
        return schoolMapper.toDto(school);
    }

    public Page<SchoolDto> getPageStudentByCondition(
            Pageable pageable, String name, Double cutoffScore){
        Page<School> schoolPage = schoolRepository.findPageSchoolBySchool(pageable, name, cutoffScore);
        schoolPage.forEach(System.out::println);
        System.out.println("___***___");
        return schoolPage.map(schoolMapper::toDto);
    }

    public SchoolDto updateSchoolById(Integer id, SchoolDto schoolDto) {
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");

        schoolMapper.updateSchool(schoolDto, school);
        schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    public SchoolDto deleteById(Integer id){
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null) throw new RuntimeException("School is not found!");

        List<TClass> tClassList = tClassRepository.findBySchool(school);
        tClassList.forEach(c -> c.setSchool(null));

        schoolRepository.delete(school);
        return schoolMapper.toDto(school);
    }
}
