package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import org.mapstruct.Mapper;

@Mapper
public interface SchoolMapper {
    SchoolDto fromSchool(School school);
    School toSchool(SchoolDto schoolDto);
}
