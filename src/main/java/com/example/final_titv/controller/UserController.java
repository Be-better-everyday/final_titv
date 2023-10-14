package com.example.final_titv.controller;

import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.dto.UserUpdateRequest;
import com.example.final_titv.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public UserResponse registerUser(
            @RequestBody UserRequest userRequest
    ){
        return userService.saveUser(userRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse findUserById(
            @PathVariable Integer id
    ){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse deleteUserById(
            @PathVariable Integer id
    ){
        return userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse changePassword(
            @PathVariable Integer id,
            @RequestBody UserUpdateRequest userRequest
    ){
        return userService.updateUser(id, userRequest);
    }
}
