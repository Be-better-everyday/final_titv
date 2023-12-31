package com.example.final_titv.service;

import com.example.final_titv.dto.StudentRequest;
import com.example.final_titv.dto.StudentResponse;
import com.example.final_titv.entity.Student;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.exception.CustomErrorException;
import com.example.final_titv.mapper.StudentMapper;
import com.example.final_titv.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        studentRepository.save(student);
        System.out.println(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new CustomErrorException(HttpStatus.NOT_FOUND, "Student not found!"));
        return studentMapper.toDto(student);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new CustomErrorException(HttpStatus.NOT_FOUND, "Student not found!"));
        studentMapper.updateStudent(studentRequest, student);

        studentRepository.saveAndFlush(student);
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public StudentResponse deleteStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new CustomErrorException(HttpStatus.NOT_FOUND, "Student not found!"));
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Page<StudentResponse> getStudentPageableByCondition(String partOfFullName, Pageable pageable) {
        Page<Student> studentPage = studentRepository.getStudentPageableByCondition(partOfFullName, pageable);
        return studentPage.map(studentMapper::toDto);
    }
}
