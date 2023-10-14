package com.example.final_titv.service;

import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.dto.UserUpdateRequest;
import com.example.final_titv.entity.Role;
import com.example.final_titv.entity.User;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.exception.NotFoundException;
import com.example.final_titv.mapper.UserMapper;
import com.example.final_titv.repository.RoleRepository;
import com.example.final_titv.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private RoleRepository roleRepository;
    @Override
    @Transactional
    public UserResponse saveUser(UserRequest userRequest) {
        User findingUser = userRepository.getUserByUsername(userRequest.getUsername());
        if(findingUser != null){
            throw new ApiException("Username is existed !", User.class);
        }
        User user = userMapper.toEntity(userRequest);
        Role userRole = roleRepository.getByNameIgnoreCase("user");
        user.addRole(userRole);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponse getUserById(Integer id) {
        User user = getUserByIdOrThrow(id);
        return userMapper.toDto(user);
    }

    private User getUserByIdOrThrow(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!", User.class));
    }

    @Override
    public UserResponse deleteUserById(Integer id) {
        User user = getUserByIdOrThrow(id);

        userRepository.delete(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponse updateUser(Integer id, UserUpdateRequest userRequest) {
        User user = getUserByIdOrThrow(id);

        userMapper.updateUser(userRequest, user);
        return null;
    }
}
