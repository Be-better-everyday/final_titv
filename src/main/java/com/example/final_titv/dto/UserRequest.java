package com.example.final_titv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
    @NotBlank
    @Size(min = 5, max = 45)
    private String username;
    @NotBlank
    @Size(min = 5, max = 45)
    private String password;
    private String fullName;
    @JsonIgnore
    private boolean enabled = true;
    @Email
    private String email;

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
