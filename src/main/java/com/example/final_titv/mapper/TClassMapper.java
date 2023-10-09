package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;
import com.example.final_titv.entity.TClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
public interface TClassMapper {
    TClassMapper INSTANCE = Mappers.getMapper(TClassMapper.class);

    @Mapping(source = "school", target = "schoolResponse")
    TClassResponse toDto(TClass tClass);

    @Mapping(source = "schoolId", target = "school")
    TClass toEntity(TClassRequest tClassRequest);
}
