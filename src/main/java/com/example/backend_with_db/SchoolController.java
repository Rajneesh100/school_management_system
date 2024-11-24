package com.example.backend_with_db;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
 

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository repo) {
        this.schoolRepository = repo;
    }

    @PostMapping("/school")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);
    }

    @GetMapping("/school")
    public List<School> getschool(){
        return schoolRepository.findAll();
    }

    

}
