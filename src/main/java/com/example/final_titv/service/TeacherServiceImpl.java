package com.example.final_titv.service;

import com.example.final_titv.dto.TeacherRequest;
import com.example.final_titv.dto.TeacherResponse;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.Teacher;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.mapper.TeacherMapper;
import com.example.final_titv.repository.TClassRepository;
import com.example.final_titv.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;
    private TClassRepository tClassRepository;

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @Override
    @Transactional
    public TeacherResponse saveTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toEntity(teacherRequest);
        teacherRepository.save(teacher);

        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherResponse getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new ApiException("Teacher not found!"));
        return teacherMapper.toDto(teacher);
    }

    @Override
    public Page<TeacherResponse> getTeacherPageableByCondition(String name, String className, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.getTeacherPageableByCondition(
                name, className, pageable);

        return teacherPage.map(teacherMapper::toDto);
    }

    @Override
    @Transactional
    public TeacherResponse deleteTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher not found!"));

        teacherRepository.delete(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherResponse updateTeacherById(Integer id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new ApiException("Teacher not found!"));

        teacherMapper.updateTeacher(teacherRequest, teacher);

        teacherRepository.saveAndFlush(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    @Transactional
    public TeacherResponse addTClassToTeacher(Integer classId, Integer id) {
        TClass tClass = tClassRepository.findById(classId)
                .orElseThrow(() -> new ApiException("TClass not found!"));

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher not found!"));

        teacher.addTClassToTeacherClass(tClass);
        teacherRepository.saveAndFlush(teacher);
        return teacherMapper.toDto(teacher);
    }
}
