package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    public SchoolDto save(SchoolDto schoolDto);
    public SchoolDto getSchoolById(Integer id);
    public Page<SchoolDto> getPageStudentByCondition(Pageable pageable, String name, Double cutoffScore);
    public SchoolDto updateSchoolById(Integer id, SchoolDto schoolDto);
    public SchoolDto deleteById(Integer id);
}
