package com.example.backend_with_db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository  extends JpaRepository<School,Integer> {
}
