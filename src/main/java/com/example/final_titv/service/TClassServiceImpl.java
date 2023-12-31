package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;
import com.example.final_titv.entity.Student;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.TeacherClass;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.exception.CustomErrorException;
import com.example.final_titv.mapper.TClassMapper;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.StudentRepository;
import com.example.final_titv.repository.TClassRepository;
import com.example.final_titv.repository.TeacherClassRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TClassServiceImpl implements TClassService{
    private TClassRepository tClassRepository;
    private TClassMapper tClassMapper;
//    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    private TeacherClassRepository teacherClassRepository;

    private TClass getTClassEntityById(Integer id) {
        return tClassRepository.findById(id)
                .orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND, "TClass not found!"));
    }
    @Override
    /*  This method may throw "PSQLException: ERROR: duplicate key value violates unique constraint" */
    public TClassResponse saveTClass(TClassRequest tClassRequest) {
        System.out.println(tClassRequest);
        TClass tClass = tClassMapper.toEntity(tClassRequest);
        tClassRepository.saveAndFlush(tClass);

        System.out.println("___***___");
        System.out.println(tClass);
        TClassResponse tClassResponse1 = tClassMapper.toDtoWithSchool(tClass);
        System.out.println(tClassResponse1);
        return tClassResponse1;
    }

    @Override
    public TClassResponse getTClassById(Integer id) {
        return tClassMapper.toDtoWithoutSchool(getTClassEntityById(id));
    }

    @Override
    public Page<TClassResponse> getTClassPageableByCondition(String className, Integer schoolId, Pageable pageable) {
        Page<TClass> tClassePage = tClassRepository
                .getTClassPageableByCondition(className, schoolId, pageable);
        return tClassePage.map(tClassMapper::toResponseSchoolId);
    }


    @Override
    public TClassResponse updateTClass(Integer id, TClassRequest tClassRequest) {
        TClass tClass = getTClassEntityById(id);

        tClass = tClassMapper.updateTClass(tClassRequest, tClass);
        tClassRepository.saveAndFlush(tClass);

        return tClassMapper.toDtoWithSchool(tClass);
    }

    @Override
    @Transactional
    public TClassResponse deleteTClass(Integer id) {
        TClass deletedTClass = getTClassEntityById(id);
        System.out.println(deletedTClass);

        teacherClassRepository.deleteTeacherClassByTClass(deletedTClass);

        List<Student> students = studentRepository.findStudentByTClass(deletedTClass);
        if(students != null){
            students.forEach(s -> s.settClass(null));
        }

        tClassRepository.delete(deletedTClass);
        return tClassMapper.toResponseSchoolId(deletedTClass);
    }
}
