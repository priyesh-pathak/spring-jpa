package com.example.jpa.repository;

import com.example.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    // Additional custom methods go here.
}
