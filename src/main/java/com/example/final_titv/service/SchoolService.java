package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    public SchoolResponse save(SchoolRequest schoolRequest);
    public SchoolResponse getSchoolById(Integer id);
    public Page<SchoolResponse> getPageStudentByCondition(Pageable pageable, String name, Double cutoffScore);
    public SchoolResponse updateSchoolById(Integer id, SchoolRequest schoolRequest);
    public SchoolResponse deleteById(Integer id);
}
