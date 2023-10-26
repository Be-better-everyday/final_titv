package com.example.final_titv.service;

import com.example.final_titv.dto.ChangePasswordRequest;
import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;

public interface UserService {

    UserResponse getUserByUsername(String username);

    UserResponse changePassword(String username, ChangePasswordRequest request);

    UserResponse save(UserRequest userRequest);

    UserResponse deleteUser(Integer id);

    UserResponse getUserById(Integer id);
}
