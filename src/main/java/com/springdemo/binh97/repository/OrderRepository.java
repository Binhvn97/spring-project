package com.springdemo.binh97.repository;

import com.springdemo.binh97.entities.ecommerce.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
