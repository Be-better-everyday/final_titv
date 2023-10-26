package com.example.final_titv.service;

import com.example.final_titv.dto.ChangePasswordRequest;
import com.example.final_titv.dto.UserRequest;
import com.example.final_titv.dto.UserResponse;
import com.example.final_titv.entity.MyUserDetails;
import com.example.final_titv.entity.Role;
import com.example.final_titv.entity.User;
import com.example.final_titv.exception.CustomErrorException;
import com.example.final_titv.mapper.UserMapper;
import com.example.final_titv.repository.RoleRepository;
import com.example.final_titv.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//@AllArgsConstructor
@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserResponse changePassword(String username, ChangePasswordRequest request) {
        User user = userRepository.getUserByUsername(username);

        if(encoder.matches(request.getOldPassword(), user.getPassword())){
//            user.setPassword(request.getNewPassword());
            user.setPassword(encoder.encode(request.getNewPassword()));
            userRepository.saveAndFlush(user);
        }else {
            throw new CustomErrorException(HttpStatus.BAD_REQUEST
                    , "Your old password is wrong! Please enter the correct one!");
        }
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        User registerUser = userMapper.toEntity(userRequest);

        Role userRole = roleRepository.getRoleByNameIgnoreCase("user");
        if(userRole != null){
            registerUser.addRole(userRole);
        }else {
            throw new CustomErrorException(HttpStatus.NOT_FOUND, "User Role is not found! Please contact helpdesk to solve this problem!");
        }

        try {
            userRepository.save(registerUser);
        } catch (Exception e) {
            throw new CustomErrorException(HttpStatus.BAD_REQUEST, "Username has already exist! Please use another username!");
        }
        return userMapper.toDto(registerUser);
    }

    @Override
    @Transactional
    public UserResponse deleteUser(Integer id) {
        User deletedUser = userRepository.findById(id)
                .orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND, "User not found!"));

        userRepository.delete(deletedUser);
        userRepository.flush();
        return userMapper.toDto(deletedUser);
    }

    @Override
    public UserResponse getUserById(Integer id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND, "User not found!"));

        return userMapper.toDto(foundUser);
    }
}
