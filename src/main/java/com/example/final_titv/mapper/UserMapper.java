package com.example.final_titv.mapper;

import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserResponse toDto(User user);

    public User toEntity(UserRequest userRequest);
}
