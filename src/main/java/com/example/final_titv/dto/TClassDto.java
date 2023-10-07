package com.example.final_titv.dto;

import com.example.final_titv.dto.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TClassDto {
    private Integer id;
    @JsonView(Views.InputView.class)
    @NotNull
    private Integer schoolId;
    @JsonView(Views.InputView.class)
    @NotBlank
    private String className;
    @JsonView(Views.InputView.class)
    @NotNull
    private Integer grade;
}
