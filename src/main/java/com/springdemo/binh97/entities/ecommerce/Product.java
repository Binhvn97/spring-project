package com.springdemo.binh97.entities.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String product_id;
    String product_name;
    Integer stockQuantity;

    @Column(length = 500)
    String product_description;
    String product_price;
    String product_image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category product_category;
    String product_status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
