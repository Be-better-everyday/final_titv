package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDto fromSchool(School school);
    School toSchool(SchoolDto schoolDto);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSchool(SchoolDto schoolDto, @MappingTarget School school);
}
