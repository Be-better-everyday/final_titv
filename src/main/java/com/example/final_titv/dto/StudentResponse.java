package com.example.final_titv.dto;

import com.example.final_titv.entity.TClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
    private Integer id;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    private LocalDate dob;
    private TClassResponseSchoolId tClassResponseSchoolId;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public TClassResponseSchoolId gettClassResponseSchoolId() {
        return tClassResponseSchoolId;
    }

    public void settClassResponseSchoolId(TClassResponseSchoolId tClassResponseSchoolId) {
        this.tClassResponseSchoolId = tClassResponseSchoolId;
    }
}
