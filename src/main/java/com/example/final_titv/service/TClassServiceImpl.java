package com.example.final_titv.service;

import com.example.final_titv.dto.TClassDto;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.mapper.TClassMapper;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TClassServiceImpl implements TClassService{
    private TClassRepository tClassRepository;
    private TClassMapper tClassMapper;
    @Override
    public TClassDto saveTClass(TClassDto tClassDto) {
        TClass tClass = tClassMapper.toTClass(tClassDto);
        tClassRepository.save(tClass);
        return tClassMapper.fromTClass(tClass);
    }
}
