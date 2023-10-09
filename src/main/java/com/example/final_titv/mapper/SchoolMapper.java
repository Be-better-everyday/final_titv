package com.example.final_titv.mapper;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.entity.School;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface SchoolMapper {
    School ToEntity(Integer id);


    SchoolResponse toDto(School school);

//    @Mapping(source = "schoolId", target = "school")
    School toEntity(SchoolRequest schoolRequest);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSchool(SchoolRequest schoolRequest, @MappingTarget School school);
}
