package com.example.final_titv;

import com.example.final_titv.entity.Teacher;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.Student;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.entity.compositeKey.TClassKey;
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
    public static void display (Set<?> tSet){
        tSet.forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(FinalTitvApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
//            testLv1();
//            testLv2();
//            testLv3();
//            testConnectExisting();
//            addNewSchool();
        };
    }

    private void addNewSchool() {
        School school = School.builder()
                .name("NTMK").address("Bac Tu Liem")
                .build();
        TClass class3 = TClass.builder()
                .tClassKey(new TClassKey(0, "12A"))
                .school(school).grade(12)
                .build();

        TClass class4 = TClass.builder()
                .tClassKey(new TClassKey(0, "12B"))
                .school(school).grade(12)
                .build();
        school.addTClass(class3);
        school.addTClass(class4);
        schoolRepository.save(school);
    }

    private void testConnectExisting() {
        Teacher teacher = teacherRepository.getReferenceById(3);
//        TClass tClass = tClassRepository.getReferenceById(new TClassKey(1, "12A"));
//        TClass tClass = tClassRepository.getById(new TClassKey(1, "12A"));
        TClass tClass = tClassRepository.findByTClassKeyClassNameJoinFetchTeacherClass("12A").get(0);
        tClass.addTeacherToTeacherClass(teacher);
        tClassRepository.save(tClass);
    }

    private void testLv3() {
        School school = schoolRepository.findByNameJoinFetchTClassSet("FTU");
        System.out.println(school);
        System.out.println("_____***_____Lv3");
//        display(school.getTClassSet());
//        school.getTClassSet().forEach(t -> System.out.println(t.getSchool()));
        tClassRepository.findBySchool(school).forEach(t -> System.out.println("* ___ " + t.getSchool()));
    }

    private void testLv2() {
        School school = schoolRepository.findByNameJoinFetchTClassSet("FTU");
        System.out.println(school);
        System.out.println("_____***_____Lv2");
        school.getTClassSet().forEach(System.out::println);
//        System.out.println(school.getTClassSet());
//        display(school.getTClassSet());
        TClass class3 = TClass.builder()
                .tClassKey(new TClassKey(null, "12C"))
                .school(school).grade(12)
                .build();
        school.addTClass(class3);
//        tClassRepository.save(class3);
        schoolRepository.save(school);
    }

    private void testLv1() {
        System.out.println(1);
        School school = School.builder()
                .name("FTU").address("Lang pagoda Street").phoneNumber("000000FTU")
                .build();

        TClass class1 = TClass.builder()
                .tClassKey(new TClassKey(0, "12A"))
                .school(school).grade(12)
                .build();

        TClass class2 = TClass.builder()
                .tClassKey(new TClassKey(0, "12B"))
                .school(school).grade(12)
                .build();

        Teacher teacher1 = Teacher.builder()
                .role("teacher")
                .firstName("nam")
                .lastName("nguyen dfs")
                .build();
        Teacher teacher2 = Teacher.builder()
                .role("teacher2")
                .firstName("nam2")
                .lastName("nguyen dfs2")
                .build();

        Student student1 = Student.builder()
                .tClass(class1)
                .firstName("dao")
                .lastName("nh")
                .build();
        Student student2 = Student.builder()
                .tClass(class1)
                .firstName("dao2")
                .lastName("nh2")
                .build();
        Student student3 = Student.builder()
                .tClass(class1)
                .firstName("dao3")
                .lastName("nh3")
                .build();

        class1.setHomeroomTeacher(teacher1);class2.setHomeroomTeacher(teacher2);

        teacher1.addTClassToTeacherClass(class1);
        teacher1.addTClassToTeacherClass(class2);

        teacher2.addTClassToTeacherClass(class1);
        teacher2.addTClassToTeacherClass(class2);

        class1.addStudent(student1);
        class2.addStudent(student2);
        class2.addStudent(student3);

        class2.getStudentSet().forEach(System.out::println);
//        class1.
        school.addTClass(class1);
        school.addTClass(class2);
        schoolRepository.save(school);
        System.out.println(2);

        Teacher teacher3 = Teacher.builder()
                .role("teacher3")
                .firstName("nam3")
                .lastName("nguyen dfs3")
                .build();
        teacherRepository.save(teacher3);
    }
}
