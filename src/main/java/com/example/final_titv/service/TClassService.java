package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;

public interface TClassService {
    TClassResponse saveTClass(TClassRequest tClassRequest);

    TClassResponse getTClassById(Integer id);
}
