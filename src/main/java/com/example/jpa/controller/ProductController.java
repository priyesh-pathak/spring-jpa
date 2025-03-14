package com.example.jpa.controller;

import com.example.jpa.entity.ProductEntity;
import com.example.jpa.repository.ProductRepo;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<ProductEntity> getProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "2") Integer pageSize) {

        Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return productRepo.findAll(pageable).getContent();
    }
}
