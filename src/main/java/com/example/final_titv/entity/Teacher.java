package com.example.final_titv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "teacherClassess")
@SuperBuilder
@Table(name = "teachers")

public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    @OneToMany(mappedBy ="teacher", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<TeacherClass> teacherClasses = new HashSet<>();
//    @OneToMany(cascade = {
//            CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH
//    })
//    private Set<TClass> tClass;

    public void addTClassToTeacherClass(TClass tClass){
        TeacherClass teacherClass = TeacherClass.builder()
                .teacher(this).tClass(tClass)
                .build();
        if(teacherClasses == null){
            teacherClasses = new HashSet<>();
        }
        teacherClasses.add(teacherClass);
    }
}
