package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data  // ✅ Auto-generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor // ✅ Constructor with all fields
@NoArgsConstructor // ✅ No-args constructor (required by JPA)
@Builder // ✅ Enables builder pattern for object creation
@Entity
@Table(
        name = "product_table",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sku"}) // ✅ Unique constraint on SKU
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;
}
