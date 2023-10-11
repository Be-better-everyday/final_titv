package com.example.final_titv.repository;

import com.example.final_titv.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

//    @Query(value = "SELECT * FROM teachers t " +
//            "INNER JOIN teacher_class tc on t.id = tc.teacher_id " +
//            "INNER JOIN classes c on c.id = tc.class_id " +
//            "(:name IS NULL OR concat(t.first_name, ' ', t.last_name) " +
//            "ILIKE '%' || :name || '%' ) AND " +
//            "(:className IS NULL OR " +
//            ":class ILIKE '%' || :className || '%' )",
//    nativeQuery = true)

    @Query(value = "SELECT t.id, t.first_name, t.last_name, t.created_at, t.updated_at, t.dob " +
            "FROM teachers t " +
            "INNER JOIN teacher_class tc on t.id = tc.teacher_id " +
            "INNER JOIN classes c on c.id = tc.class_id " +
            "WHERE (:name IS NULL OR concat(t.first_name, ' ', t.last_name) ILIKE '%' || :name || '%') " +
            "AND (:className IS NULL OR c.class_name ILIKE '%' || :className || '%')"
            ,nativeQuery = true)
    public Page<Teacher> getTeacherPageableByCondition(
            String name, String className, Pageable pageable
    );


}
