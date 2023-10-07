package com.example.final_titv.repository;

import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TClassRepository extends JpaRepository<TClass, Integer> {

    public List<TClass> findBySchool(School school);
}
