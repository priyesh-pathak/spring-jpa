package com.example.jpa;

import com.example.jpa.entity.ProductEntity;
import com.example.jpa.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	private ProductRepo productRepo;

	@Test
	void contextLoads() {
	}

	@Test

	void testRepositories() {
		// ✅ Using @Builder to create ProductEntity instance
		ProductEntity pe = ProductEntity.builder()
				.sku("SKU6")
				.name("Product F")
				.price(2700)
				.build();

		// ✅ Save entity to the database
		ProductEntity saved = productRepo.save(pe);

		// ✅ Print saved entity
		System.out.println("Saved product: " + saved);
	}

	@Test
	void findProduct(){
		List<ProductEntity> products = productRepo.findAll();
		products.forEach(System.out::println);
	}
}
