package com.example.final_titv.repository;

import com.example.final_titv.entity.Student;
import com.example.final_titv.entity.TClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM students s WHERE " +
            ":partOfFullName IS NULL OR concat(s.first_name, ' ', s.last_name) ILIKE '%' || :partOfFullName || '%'",
    nativeQuery = true)
    Page<Student> getStudentPageableByCondition(String partOfFullName, Pageable pageable);

    @Query(value = "SELECT s FROM Student s WHERE s.tClass = ?1")
    public List<Student> findStudentByTClass(TClass tClass);
}
