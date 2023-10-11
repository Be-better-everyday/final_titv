package com.example.final_titv.mapper;

import com.example.final_titv.dto.StudentRequest;
import com.example.final_titv.dto.StudentResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.entity.Student;
import com.example.final_titv.entity.TClass;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class,SchoolMapper.class, TClassMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "tClassId", target = "tClass")
    Student toEntity(StudentRequest studentRequest);

    @Mapping(source = "tClass", target = "tClassResponseSchoolId")
    StudentResponse toDto(Student student);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "tClassId", target = "tClass")
    Student updateStudent(StudentRequest studentRequest, @MappingTarget Student student);
}
