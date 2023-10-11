package com.example.final_titv.mapper;

import com.example.final_titv.dto.TeacherRequest;
import com.example.final_titv.dto.TeacherResponse;
import com.example.final_titv.entity.Teacher;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class, TClassMapper.class})
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(source = "homeClassId", target = "homeClass")
    Teacher toEntity(TeacherRequest teacherRequest);

    @Mapping(source = "homeClass", target = "tClassResponseSchoolId")
    @Mapping(source ="teacherClasses" , target = "classSchools")
    TeacherResponse toDto(Teacher teacher);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "homeClassId", target = "homeClass")
    Teacher updateTeacher(TeacherRequest teacherRequest,
                          @MappingTarget Teacher teacher);
}
