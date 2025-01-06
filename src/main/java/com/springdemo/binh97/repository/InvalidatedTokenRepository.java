package com.springdemo.binh97.repository;

import com.springdemo.binh97.entities.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidToken, String> {
}
