package com.example.jpa.controller;

import com.example.jpa.entity.ProductEntity;
import com.example.jpa.repository.ProductRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepo productRepo;
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @GetMapping("/price")
    public List<ProductEntity> getProductsSorted() {
        return productRepo.findByOrderByPrice();
    }
    @GetMapping(path="/name")
    public List<ProductEntity> getProductsSortedByName() {
        return productRepo.findByOrderByName();
    }
    @GetMapping
    public List<ProductEntity> getSortedProducts(@RequestParam(defaultValue = "id") String sortby) {
        return productRepo.findBy(Sort.by(Sort.Direction.DESC,sortby));

    }
}
