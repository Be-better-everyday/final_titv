package com.example.final_titv;

import com.example.final_titv.entity.School;
import com.example.final_titv.mapper.ReferenceMapper;
import com.example.final_titv.mapper.SchoolMapper;
import com.example.final_titv.repository.TeacherRepository;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.StudentRepository;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Set;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootApplication
@NoArgsConstructor
public class FinalTitvApplication {
    private TeacherRepository teacherRepository;
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    private TClassRepository tClassRepository;

    private ReferenceMapper referenceMapper;
    private SchoolMapper schoolMapper;

    public static void display (Set<?> tSet){
        tSet.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(FinalTitvApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
//            mapperTest(); // Fail !
        };
    }

    private void mapperTest() {
//        School school = referenceMapper.map(1, School.class);
        School school = schoolMapper.ToEntity(2);
        System.out.println(school);
    }

}
