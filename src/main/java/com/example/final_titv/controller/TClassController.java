package com.example.final_titv.controller;

import com.example.final_titv.dto.TClassDto;
import com.example.final_titv.dto.view.Views;
import com.example.final_titv.mapper.TClassMapper;
import com.example.final_titv.repository.TClassRepository;
import com.example.final_titv.service.TClassService;
import com.example.final_titv.service.TClassServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class TClassController {
    private TClassService tClassService;

    @PostMapping
    public TClassDto saveTClass(@JsonView(Views.InputView.class) @RequestBody TClassDto tClassDto){
        return tClassService.saveTClass(tClassDto);
    }
}
