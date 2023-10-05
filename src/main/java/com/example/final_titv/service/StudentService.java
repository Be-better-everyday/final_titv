package com.example.final_titv.service;

import com.example.final_titv.entity.Student;
import com.example.final_titv.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    private Student save(Student student){
        return studentRepository.save(student);
    }


}
