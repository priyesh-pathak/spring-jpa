package com.example.jpa.repository;


import com.example.jpa.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findByOrderByName();

    List<ProductEntity> findBy(Sort sort);
}
