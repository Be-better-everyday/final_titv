package com.example.final_titv.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@ToString(exclude = "tClass", callSuper = true)
@Table(name = "students")
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private TClass tClass;


//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", tClass=" + tClass +
//                '}';
//    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
    }
}
