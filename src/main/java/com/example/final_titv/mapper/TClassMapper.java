package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolDto;
import com.example.final_titv.dto.TClassDto;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TClassMapper {
    TClassMapper INSTANCE = Mappers.getMapper(TClassMapper.class);
    TClassDto fromTClass(TClass tClass);
    TClass toTClass(TClassDto tClassDto);
}
