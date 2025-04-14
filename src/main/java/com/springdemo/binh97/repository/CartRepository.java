package com.springdemo.binh97.repository;

import com.springdemo.binh97.entities.ecommerce.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
