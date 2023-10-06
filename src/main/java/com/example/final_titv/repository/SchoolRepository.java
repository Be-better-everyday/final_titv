package com.example.final_titv.repository;

import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
    public School findByName(String name);

    @Query("SELECT s FROM School s JOIN FETCH s.tClassSet WHERE s.name = ?1 ")
    public School findByNameJoinFetchTClassSet(String name);

    @Query(value = "SELECT * FROM schools s WHERE (:name IS NULL OR s.name ILIKE '%' || :name || '%') " +
            "AND (:cutoffScore is null or s.cutoff_score >= :cutoffScore )",
            nativeQuery = true)
//    @Query(value = "SELECT * FROM schools s WHERE (:name IS NULL OR s.name ILIKE '%' || :name || '%') "
//            , nativeQuery = true)
    public Page<School> findPageSchoolBySchool(Pageable pageable, String name, Double cutoffScore);
}
