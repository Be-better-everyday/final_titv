package com.example.final_titv.repository;

import com.example.final_titv.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
    public School findByName(String name);

    @Query("SELECT s FROM School s JOIN FETCH s.tClassSet WHERE s.name = ?1 ")
    public School findByNameJoinFetchTClassSet(String name);
    @Query("SELECT s FROM School s JOIN FETCH s.tClassSet WHERE s.id = ?1 ")
    public School findByIdJoinFetchTClassSet(Integer id);
}
