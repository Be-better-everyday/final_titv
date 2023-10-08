package com.example.final_titv.dto;

import com.example.final_titv.dto.view.Views;
import com.example.final_titv.entity.School;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TClassDto {
    private Integer id;
    @JsonView(Views.Request.class)
    @NotNull
    private Integer schoolId;
    @JsonView(Views.Request.class)
    @NotBlank
    private String className;
    @JsonView(Views.Request.class)
    @NotNull
    private Integer grade;
    private SchoolDto schoolDto;
}
