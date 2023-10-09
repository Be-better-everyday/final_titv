package com.example.final_titv.mapper;

import com.example.final_titv.dto.*;
import com.example.final_titv.entity.TClass;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
public interface TClassMapper {
    TClassMapper INSTANCE = Mappers.getMapper(TClassMapper.class);

    @Mapping(source = "school", target = "schoolResponse")
//    @Mapping(source = "school", target = "schoolResponse", qualifiedByName = "toDto")
    TClassResponseWithSchool toDtoWithSchool(TClass tClass);

    TClassResponse toDtoWithoutSchool(TClass tClass);

    @Mapping(source = "schoolId", target = "school")
    TClass toEntity(TClassRequest tClassRequest);

    @Mapping(target = "schoolId", expression =
    "java(tClass.getSchool() != null ? tClass.getSchool().getId() : null)")
    TClassResponseSchoolId toResponseSchoolId(TClass tClass);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "schoolId", target = "school")
    TClass updateTClass(TClassRequest tClassRequest, @MappingTarget TClass tClass);

}
