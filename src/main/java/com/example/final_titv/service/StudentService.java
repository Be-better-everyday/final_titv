package com.example.final_titv.service;

import com.example.final_titv.dto.StudentRequest;
import com.example.final_titv.dto.StudentResponse;
import com.example.final_titv.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    public Student save(Student student);
    StudentResponse createStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Integer id);

    StudentResponse updateStudent(StudentRequest studentRequest, Integer id);

    StudentResponse deleteStudentById(Integer id);

    Page<StudentResponse> getStudentPageableByCondition(String partOfFullName, Pageable pageable);
}
