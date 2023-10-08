package com.example.final_titv.mapper;

import com.example.final_titv.entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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

//    public static void main(String[] args) {
//        ReferenceMapper referenceMapper = new ReferenceMapper();
//        School school = referenceMapper.map(1, School.class);
//        System.out.println(school);
//    }
}
