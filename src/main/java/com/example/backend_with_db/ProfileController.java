package com.example.backend_with_db;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    private final StudentProfileRepository studentProfileRepository;

    public ProfileController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }


    @PostMapping("/profile")
    public StudentProfile createprofile(
            @RequestBody StudentProfile studentProfile
    ){
        return studentProfileRepository.save(studentProfile);
    }


    @GetMapping("/profile")
    public List<StudentProfile> getprofile(
            @RequestBody StudentProfile studentProfile
    ){
        return studentProfileRepository.findAll();
    }


}
