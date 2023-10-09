package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TClassService {
    TClassResponse saveTClass(TClassRequest tClassRequest);

    TClassResponse getTClassById(Integer id);

    Page<TClassResponse> getTClassPageableByCondition(String className, Integer schoolId, Pageable pageable);

    TClassResponse updateTClass(Integer id, TClassRequest tClassRequest);

    TClassResponse deleteTClass(Integer id);
}
