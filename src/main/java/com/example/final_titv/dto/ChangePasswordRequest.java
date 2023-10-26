package com.example.final_titv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangePasswordRequest {
    @NotBlank
    @Size(min = 5, max = 45)
    private String oldPassword;
    @NotBlank
    @Size(min = 5, max = 45)
    private String newPassword;

}
