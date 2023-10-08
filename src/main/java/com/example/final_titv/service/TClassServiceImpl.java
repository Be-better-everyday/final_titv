package com.example.final_titv.service;

import com.example.final_titv.dto.TClassDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.mapper.TClassMapper;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TClassServiceImpl implements TClassService{
    private TClassRepository tClassRepository;
    private TClassMapper tClassMapper;
    private SchoolRepository schoolRepository;
    @Override
    /*  This method may throw "PSQLException: ERROR: duplicate key value violates unique constraint" */
    public TClassDto saveTClass(TClassDto tClassDto) {
        TClass tClass = tClassMapper.toEntity(tClassDto);
        System.out.println("___***___");
        System.out.println(tClass);
//        School school;
//        if(tClassDto.getSchoolId() != null){
//            school = schoolRepository.findById(tClassDto.getSchoolId())
//                    .orElseThrow(() -> new RuntimeException("School not found!"));
//            tClass.setSchool(school);
//            tClassRepository.saveAndFlush(tClass);
//        }
        TClassDto tClassDto1 = tClassMapper.toDto(tClass);
        System.out.println(tClassDto1);
        return tClassDto1;
    }

    @Override
    public TClassDto getTClassById(Integer id) {
        return tClassMapper.toDto(tClassRepository.findById(id)
                .orElseThrow(()->new ApiException("TClass not found!")));
    }
}
