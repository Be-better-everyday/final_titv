package com.example.final_titv.controller;

import com.example.final_titv.dto.ChangePasswordRequest;
import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.entity.MyUserDetails;
import com.example.final_titv.entity.User;
import com.example.final_titv.repository.UserRepository;
import com.example.final_titv.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private BCryptPasswordEncoder encoder;

    @GetMapping("/info")
    public UserResponse getInfo(Principal principal){
        String username = principal.getName();
        return userService.getUserByUsername(username);
    }

    @PostMapping("/changePassword")
    public UserResponse changePassword(
            Principal principal,
            @RequestBody ChangePasswordRequest request
    ){
        String username = principal.getName();
        return userService.changePassword(username, request);
    }

    @PostMapping("/register")
    public UserResponse register(
            @RequestBody UserRequest userRequest
    ){
        return userService.save(userRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse deleteUser(
            @PathVariable Integer id
    ){
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse getUser(
            @PathVariable Integer id
    ){
        return userService.getUserById(id);
    }
}
