package com.example.final_titv.controller;

import com.example.final_titv.dto.SchoolResponse;
import com.example.final_titv.dto.TClassRequest;
import com.example.final_titv.dto.TClassResponse;

import com.example.final_titv.service.TClassService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class TClassController {
    private TClassService tClassService;

    @PostMapping
    public TClassResponse saveTClass( @RequestBody TClassRequest tClassRequest){
        return tClassService.saveTClass(tClassRequest);
    }

    @GetMapping("/{id}")
    public TClassResponse getTClassById(@PathVariable Integer id){
        return tClassService.getTClassById(id);
    }

    @GetMapping
    public Page<TClassResponse> getTClassPageableByCondition(
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "schoolId", required = false) Integer schoolId,
            Pageable pageable
    ){
        System.out.println("___TClass Pageable___");
        return tClassService.getTClassPageableByCondition(className, schoolId, pageable);
    }


    /*
     * This method can update "school", "className", "grade" of TClass */
    @PutMapping("/{id}")
    public TClassResponse updateTClass(
            @PathVariable Integer id,
            @RequestBody TClassRequest tClassRequest
    ){
        return tClassService.updateTClass(id, tClassRequest);
    }

    @DeleteMapping("/{id}")
    public TClassResponse deleteTClass(
            @PathVariable Integer id
    ){
        return tClassService.deleteTClass(id);
    }
}
