package com.example.final_titv.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    @Length(min = 5, max = 45)
    private String password;
    @NotBlank
    @Length(min = 5, max = 45)
    private String fullName;
}
