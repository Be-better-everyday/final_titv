package com.example.final_titv.entity;

import com.example.final_titv.entity.compositeKey.TClassKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode
@ToString(exclude = {"school", "teacherClasses", "studentSet"})
@Builder
@Table(name = "classes")
public class TClass {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @EmbeddedId
    private TClassKey tClassKey;    // include "schoolId" and "className"
    private Integer grade;
    @Column(name = "academy_year")
    private Integer academicYear;
    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "homeroom_teacher")
    private Teacher homeroomTeacher;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @MapsId("schoolId")
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;
    @OneToMany(mappedBy ="tClass", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<TeacherClass> teacherClasses = new HashSet<>();

    @OneToMany(mappedBy ="tClass", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<Student> studentSet = new HashSet<>();

    public void addStudent(Student student){
        if(studentSet == null){
            studentSet = new HashSet<>();
        }
        studentSet.add(student);
    }

    public void addTeacherToTeacherClass(Teacher teacher){
        TeacherClass teacherClass = TeacherClass.builder()
                .tClass(this).teacher(teacher)
                .build();
        if(teacherClasses == null){
            teacherClasses = new HashSet<>();
        }
        teacherClasses.add(teacherClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TClass tClass = (TClass) o;

        if (!Objects.equals(tClassKey, tClass.tClassKey)) return false;
        if (!Objects.equals(grade, tClass.grade)) return false;
        return Objects.equals(academicYear, tClass.academicYear);
    }

    @Override
    public int hashCode() {
        int result = tClassKey != null ? tClassKey.hashCode() : 0;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (academicYear != null ? academicYear.hashCode() : 0);
        return result;
    }
}
