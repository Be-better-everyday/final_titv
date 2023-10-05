package com.example.final_titv.config;

import com.example.final_titv.entity.School;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JsonConfiguration {
    @Bean
    public Hibernate5JakartaModule hibernateModule() {
        return new Hibernate5JakartaModule();
    }

//    public class YourEntitySerializer extends JsonSerializer<School> {
//        @Override
//        public void serialize(School entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("nonLazyProperty", entity.getNonLazyProperty());
//            // Handle other properties as needed, ignoring lazy-loaded properties
//            jsonGenerator.writeEndObject();
//        }
//    }
}
