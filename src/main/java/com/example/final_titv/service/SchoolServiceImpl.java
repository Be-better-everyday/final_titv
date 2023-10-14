package com.example.final_titv.service;

import com.example.final_titv.dto.SchoolRequest;
import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.entity.School;
import com.example.final_titv.entity.TClass;
import com.example.final_titv.exception.ApiException;
import com.example.final_titv.exception.NotFoundException;
import com.example.final_titv.mapper.SchoolMapper;
import com.example.final_titv.repository.SchoolRepository;
import com.example.final_titv.repository.TClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{
    private SchoolRepository schoolRepository;
    private TClassRepository tClassRepository;

    private SchoolMapper schoolMapper;
    // This bean is create using method "getSchoolMapper" in BeanConfig

    public SchoolResponse save(SchoolRequest schoolRequest){
        School school = schoolMapper.toEntity(schoolRequest);
        school = schoolRepository.save(school);
//        System.out.println(school.getId());
        return schoolMapper.toDto(school);
    }
    public SchoolResponse getSchoolById(Integer id){
        School school = getSchoolByIdOrThrow(id);
        return schoolMapper.toDto(school);
    }

    private School getSchoolByIdOrThrow(Integer id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("School not Found!", School.class));
    }

    @Override
    public SchoolResponse getSchoolWithClassById(Integer id) {
        School school = null;
        try {
            school = schoolRepository.findByIdJoinFetchTClassSet(id);
        } catch (Exception e) {
            throw new NotFoundException("School not Found!", School.class);
        }

        return schoolMapper.toDtoWithClassList(school);
    }

    public Page<SchoolResponse> getPageStudentByCondition(
            Pageable pageable, String name, Double cutoffScore){
        Page<School> schoolPage = schoolRepository.findPageSchoolBySchool(pageable, name, cutoffScore);
        schoolPage.forEach(System.out::println);
        System.out.println("___***___");
        return schoolPage.map(schoolMapper::toDto);
    }

    public SchoolResponse updateSchoolById(Integer id, SchoolRequest schoolRequest) {
        School school = getSchoolByIdOrThrow(id);

        schoolMapper.updateSchool(schoolRequest, school);
        schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    public SchoolResponse deleteById(Integer id){
        School school = getSchoolByIdOrThrow(id);

        List<TClass> tClassList = tClassRepository.findBySchool(school);
        tClassList.forEach(c -> c.setSchool(null));

        schoolRepository.delete(school);
        return schoolMapper.toDto(school);
    }

}
