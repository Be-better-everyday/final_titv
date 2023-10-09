package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.mapper.TClassMapper;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TClassServiceImpl implements TClassService{
    private TClassRepository tClassRepository;
    private TClassMapper tClassMapper;
    private SchoolRepository schoolRepository;
    @Override
    /*  This method may throw "PSQLException: ERROR: duplicate key value violates unique constraint" */
    public TClassResponse saveTClass(TClassRequest tClassRequest) {
        System.out.println(tClassRequest);
        TClass tClass = tClassMapper.toEntity(tClassRequest);
        tClassRepository.saveAndFlush(tClass);

        System.out.println("___***___");
        System.out.println(tClass);
        TClassResponse tClassResponse1 = tClassMapper.toDto(tClass);
        System.out.println(tClassResponse1);
        return tClassResponse1;
    }

    @Override
    public TClassResponse getTClassById(Integer id) {
        return tClassMapper.toDto(tClassRepository.findById(id)
                .orElseThrow(()->new ApiException("TClass not found!")));
    }
}
