package com.example.final_titv.repository;

import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;

import com.example.final_titv.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TClassRepository extends JpaRepository<TClass, Integer> {

    public List<TClass> findBySchool(School school);

    /*  This query is only used for PostgresSQL */
    @Query(value = "SELECT * FROM classes c WHERE " +
            "(:className IS NULL OR c.class_name ILIKE '%' || :className || '%') AND" +
            "(:schoolId IS NULL OR c.school_id = :schoolId)",
    nativeQuery = true)
    public Page<TClass> getTClassPageableByCondition(String className, Integer schoolId, Pageable pageable);

    @Query(value = "SELECT tc.tClass FROM TeacherClass tc " +
            "WHERE tc.teacher = :teacher" )
    public List<TClass> findTClassByTeacher(Teacher teacher);

    @Query(value = "SELECT c FROM TClass c " +
            "WHERE c.homeroomTeacher = ?1")
    public TClass findTClassByHomeTeacher(Teacher teacher);
//    public TClass findByStudent
}
