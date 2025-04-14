package com.springdemo.binh97.repository;

import com.springdemo.binh97.entities.ecommerce.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
