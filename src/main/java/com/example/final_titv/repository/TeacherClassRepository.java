package com.example.final_titv.repository;

import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.Teacher;
import com.example.final_titv.entity.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherClassRepository extends JpaRepository<TeacherClass, Integer> {


}
