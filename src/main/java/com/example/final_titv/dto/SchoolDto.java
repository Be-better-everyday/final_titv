package com.example.final_titv.dto;

import com.example.final_titv.entity.School;
import com.example.final_titv.repository.SchoolRepository;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {
    private String name;
    private String address;
    private String phoneNumber;

    public void fromSchool(School school){
        setName(school.getName());
        setAddress(school.getAddress());
        setPhoneNumber(school.getPhoneNumber());
    }
}
