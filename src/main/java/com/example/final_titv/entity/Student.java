package com.example.final_titv.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "tClass", callSuper = true)
@Table(name = "students")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private TClass tClass;
//    private Parents parents;


//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", tClass=" + tClass +
//                '}';
//    }
}
