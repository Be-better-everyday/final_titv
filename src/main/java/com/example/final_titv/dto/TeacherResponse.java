package com.example.final_titv.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private TClassResponseSchoolId tClassResponseSchoolId;
    @Getter
    private Set<String> classSchools;


    public void settClassResponseSchoolId(TClassResponseSchoolId tClassResponseSchoolId) {
        this.tClassResponseSchoolId = tClassResponseSchoolId;
    }

    public TClassResponseSchoolId gettClassResponseSchoolId() {
        return tClassResponseSchoolId;
    }

    public void setClassSchools(Set<String> classSchools) {
        this.classSchools = classSchools;
    }
}
