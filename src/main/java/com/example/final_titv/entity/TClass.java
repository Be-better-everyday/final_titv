package com.example.final_titv.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"school", "teacherClasses", "studentSet", "homeroomTeacher"})
@Table(name = "classes"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = {"school_id", "class_name"})}
)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TClass extends BaseEntity {
    @Column(name = "class_name")
    @EqualsAndHashCode.Include
    private String className;
    private Integer grade;
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
    @JoinColumn(name = "school_id")
    private School school;
    @OneToMany(mappedBy = "tClass", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<TeacherClass> teacherClasses = new HashSet<>();

    @OneToMany(mappedBy = "tClass", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Set<Student> studentSet = new HashSet<>();


    public void addStudent(Student student) {
        if (studentSet == null) {
            studentSet = new HashSet<>();
        }
        studentSet.add(student);
    }

    public void addTeacherToTeacherClass(Teacher teacher) {
        TeacherClass teacherClass = TeacherClass.builder()
                .tClass(this).teacher(teacher)
                .build();
        if (teacherClasses == null) {
            teacherClasses = new HashSet<>();
        }
        teacherClasses.add(teacherClass);
    }
}
