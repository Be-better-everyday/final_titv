package com.example.final_titv.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "tClass", callSuper = true)
@Table(name = "students")
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Person{

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private TClass tClass;

    public TClass gettClass() {
        return tClass;
    }

    public void settClass(TClass tClass) {
        this.tClass = tClass;
    }
}
