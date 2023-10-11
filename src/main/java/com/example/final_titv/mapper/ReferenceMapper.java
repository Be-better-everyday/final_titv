package com.example.final_titv.mapper;

import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.TeacherClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
//@AllArgsConstructor
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ReferenceMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ObjectFactory
    public <T> T map(@NonNull final Integer id, @TargetType Class<T> type) {
        return entityManager.find(type, id);
    }

    public static Set<String> listingId(Set<TClass> tClassSet){
        return tClassSet.stream().map(TClass::getClassName).collect(Collectors.toSet());
    }

    TClass map(Integer value){
        return entityManager.find(TClass.class, value);
    }

    Set<String> map(Set<TeacherClass> teacherClassSet){
        return teacherClassSet.stream()
                .map(tc -> tc.gettClass().getClassSchool())
                .collect(Collectors.toSet());
    }
}
