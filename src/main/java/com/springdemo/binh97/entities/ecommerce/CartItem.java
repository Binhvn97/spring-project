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
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cart_item_id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false) // Gắn với Cart
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Gắn với Product
    Product product;

    Integer quantity;

    Double total_price;

    LocalDateTime created_at;
    LocalDateTime updatedAt;
}
