package com.example.final_titv.dto;

import com.example.final_titv.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String username;
    private String fullName;
//    private String password;
    private boolean enabled;
    @JsonIgnore
    private Set<Role> roles;

    @JoinColumn(name = "roles")
    public Set<String> getRoles(){
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }
}
