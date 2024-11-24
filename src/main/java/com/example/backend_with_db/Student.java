package com.example.backend_with_db;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="t_student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            name="s_name",
            length = 20
    )
    private String name;
    @Column(
            unique = true
    )
    private String email;
    private int age;


    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private StudentProfile studentProfile;


public String sayhi(){
    return "hiweff";
}












    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(
            name ="school_id"
    )
    @JsonBackReference
    private School school;




    @Column(
            updatable = false
    )
    private LocalDateTime created_date;

    @PrePersist // this will ensure before insert this will set the value using onCreate()
    protected void onCreate() {
        this.created_date = LocalDateTime.now();
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }


    public Student(String name, String email, int age) {
//        this.created_date= LocalDateTime.now();
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
