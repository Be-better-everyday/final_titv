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
@ToString(exclude = "teacherClasses")
@Table(name = "teachers")

public class Teacher extends Person {
    @OneToOne(mappedBy ="homeroomTeacher", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private TClass homeClass;
    @OneToMany(mappedBy ="teacher", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<TeacherClass> teacherClasses = new HashSet<>();

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
