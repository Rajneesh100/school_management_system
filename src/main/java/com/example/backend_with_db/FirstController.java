package com.example.backend_with_db;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello()
    {
        return "Say Hello from my first java spring boot backend";
    }

    private final StudentRepository repository;
    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/student")
    public Student post(
            @RequestBody Student stud
    ){
        return repository.save(stud);
    }

    @GetMapping("/student")
    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    @GetMapping("/student/{student-id}")
    public Student findStudById(
            @PathVariable("student-id") Integer id
    )
    {
        return repository.findById(id)
                .orElse(new Student());
    }
    @GetMapping("/student/search/{name}")
    public List<Student>  findStudentByName(
            @PathVariable("name") String name
    ){
        return repository.findAllBynameContaining(name);
    }


    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("id") Integer id
    )
    {

        repository.deleteById(id);
    }


























    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "post accepted :"+ message;
    }

}
