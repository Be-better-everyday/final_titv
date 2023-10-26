package com.example.final_titv.repository;

import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.Teacher;
import com.example.final_titv.entity.TeacherClass;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherClassRepository extends JpaRepository<TeacherClass, Integer> {
    public List<TeacherClass> findTeacherClassByTeacher(Teacher teacher);

    @Query(value = "SELECT tc FROM TeacherClass tc WHERE tc.tClass = ?1")
    public List<TeacherClass> findTeacherClassByTClass(TClass tClass);

    @Modifying
//    @Transactional
    @Query(value = "DELETE FROM TeacherClass tc WHERE tc.teacher = ?1")
    public void deleteTeacherClassByTeacher(Teacher teacher);

    @Modifying
//    @Transactional
    @Query(value = "DELETE FROM TeacherClass tc WHERE tc.tClass = ?1")
    public void deleteTeacherClassByTClass(TClass tClass);

}
