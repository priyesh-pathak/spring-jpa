package com.example.jpa.repository;


import com.example.jpa.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findAll(Pageable pageable);
}
