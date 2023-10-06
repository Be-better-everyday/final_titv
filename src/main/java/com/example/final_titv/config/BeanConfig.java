package com.example.final_titv.config;

import com.example.final_titv.mapper.SchoolMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public SchoolMapper getSchoolMapper(){
        return Mappers.getMapper(SchoolMapper.class);
    }
}
