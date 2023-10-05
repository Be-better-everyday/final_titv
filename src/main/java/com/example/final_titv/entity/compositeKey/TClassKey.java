package com.example.final_titv.entity.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class TClassKey implements Serializable {
    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "class_name")
    private String className;

    // Constructors, getters, and setters (omitted for brevity)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TClassKey tClassKey = (TClassKey) o;
        return Objects.equals(schoolId, tClassKey.schoolId) &&
                Objects.equals(className, tClassKey.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, className);
    }
}
