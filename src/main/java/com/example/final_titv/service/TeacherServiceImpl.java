package com.example.final_titv.service;

import com.example.final_titv.entity.Teacher;
import com.example.final_titv.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
