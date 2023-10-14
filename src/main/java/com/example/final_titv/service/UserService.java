package com.example.final_titv.service;

import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.dto.UserUpdateRequest;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUserById(Integer id);

    UserResponse deleteUserById(Integer id);

    UserResponse updateUser(Integer id, UserUpdateRequest userRequest);
}
