package com.example.final_titv.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Integer homeClassId;
//    private Set<String> className;


}
