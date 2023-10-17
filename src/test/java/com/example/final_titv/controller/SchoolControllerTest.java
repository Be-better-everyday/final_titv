package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.entity.School;
import com.example.final_titv.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(SchoolController.class)
@RunWith(SpringRunner.class)
class SchoolControllerTest {
    private static final String END_POINT_PATH = "/users";

    @Autowired
    private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean
    private SchoolService schoolService;
    @MockBean
    private SchoolController schoolController;

    @Test
    void saveSchool() {
        SchoolRequest request = SchoolRequest.builder()
            .cutoffScore(24).name("FPT2").address("TonThatThuyet").phoneNumber("0010020034")
                .build();

        SchoolResponse response = schoolController.saveSchool(request);

    }

    @Test
    void getSchool() {
    }

    @Test
    void getSchoolWithClass() {
    }

    @Test
    void getPageStudentByCondition() {
    }

    @Test
    void updateStudentById() {
    }

    @Test
    void deleteSchool() {
    }
}