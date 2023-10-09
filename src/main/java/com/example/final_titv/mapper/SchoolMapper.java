package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.SchoolResponseWithClassList;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class, TClassMapper.class})
public interface SchoolMapper {
    School ToEntity(Integer id);

    @Mapping(target = "classNameList",
//    expression = "java(school.getTClassSet().stream().map(TClass::getId).collect(Collectors.toSet()))")
    expression = "java(ReferenceMapper.listingId(school.getTClassSet()))")
    SchoolResponseWithClassList toDtoWithClassList(School school);

//    @Mapping(target = "classNameList")
//    SchoolResponseWithClassList toDtoWithClassList2(School school);

    @Named("toDto")
    SchoolResponse toDto(School school);

//    @Mapping(source = "schoolId", target = "school")
    School toEntity(SchoolRequest schoolRequest);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSchool(SchoolRequest schoolRequest, @MappingTarget School school);
}
