package com.example.final_titv.dto;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolRequest {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Pattern(regexp = "^(\\d{10}|\\d{11}|\\d{12})$",
            message = "This phone number must include 10-12 number")
    private String phoneNumber;
    @Min(0)
    @Max(30)
    @NotNull
    private Integer cutoffScore;


//    protected ZonedDateTime createdAt;
//    protected ZonedDateTime updatedAt;
}
