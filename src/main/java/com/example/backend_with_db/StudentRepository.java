package com.example.backend_with_db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//        List<Student> findAllBynameContaining(String name);
        List<Student> findAllBynameContaining(String name);
}

