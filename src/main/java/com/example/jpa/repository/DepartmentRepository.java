package com.example.jpa.repository;

import com.example.jpa.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    // Additional custom methods
}
