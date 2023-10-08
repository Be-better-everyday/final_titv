package com.example.final_titv.dto;

import com.example.final_titv.dto.view.Views;
import com.example.final_titv.entity.School;
import com.example.final_titv.repository.SchoolRepository;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolDto {
    private Integer id;
    @JsonView(Views.Request.class)
    @NotBlank
    private String name;
    @JsonView(Views.Request.class)
    @NotBlank
    private String address;
    @JsonView(Views.Request.class)
    @Pattern(regexp = "^(\\d{10}|\\d{11}|\\d{12})$",
            message = "This phone number must include 10-12 number")
    private String phoneNumber;
    @Min(0)
    @Max(30)
    @NotNull
    @JsonView(Views.Request.class)
    private Integer cutoffScore;


//    protected ZonedDateTime createdAt;
//    protected ZonedDateTime updatedAt;
}
