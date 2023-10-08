package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.dto.TClassDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
public interface TClassMapper {
    TClassMapper INSTANCE = Mappers.getMapper(TClassMapper.class);

    @Mapping(target = "schoolId",
            expression = "java(tClass.getSchool().getId())")
    @Mapping(source = "school", target = "schoolDto")
    TClassDto toDto(TClass tClass);

    @Mapping(source = "schoolId", target = "school")
    TClass toEntity(TClassDto tClassDto);
}
