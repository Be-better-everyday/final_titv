package com.example.final_titv.mapper;

import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.dto.UserUpdateRequest;
import com.example.final_titv.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserRequest userRequest);

    UserResponse toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserUpdateRequest userUpdateRequest,@MappingTarget User user);
}
