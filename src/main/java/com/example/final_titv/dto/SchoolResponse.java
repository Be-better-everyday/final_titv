package com.example.final_titv.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolResponse {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer cutoffScore;

private List<String> classList;

//    protected ZonedDateTime createdAt;
//    protected ZonedDateTime updatedAt;
}

