package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.entity.School;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface SchoolMapper {
    School ToEntity(Integer id);


    SchoolDto toDto(School school);

//    @Mapping(source = "schoolId", target = "school")
    School toEntity(SchoolDto schoolDto);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSchool(SchoolDto schoolDto, @MappingTarget School school);
}
