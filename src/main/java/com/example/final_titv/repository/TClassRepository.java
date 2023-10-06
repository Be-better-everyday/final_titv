package com.example.final_titv.repository;

import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.compositeKey.TClassKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TClassRepository extends JpaRepository<TClass, TClassKey> {
    @Query("SELECT t FROM TClass t JOIN FETCH t.teacherClasses WHERE t.tClassKey.className = :className")
    public List<TClass> findByTClassKeyClassNameJoinFetchTeacherClass(@Param("className")String className);

    public List<TClass> findBySchool(School school);
}
