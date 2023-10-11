package com.example.final_titv.service;

import com.example.final_titv.dto.TeacherRequest;
import com.example.final_titv.dto.TeacherResponse;
import com.example.final_titv.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    public Teacher save(Teacher teacher);
    TeacherResponse saveTeacher(TeacherRequest teacherRequest);

    TeacherResponse getTeacherById(Integer id);

    Page<TeacherResponse> getTeacherPageableByCondition(String name, String className, Pageable pageable);

    TeacherResponse updateTeacherById(Integer id, TeacherRequest teacherRequest);

    TeacherResponse deleteTeacherById(Integer id);

    TeacherResponse addTClassToTeacher(Integer classId, Integer id);
}
