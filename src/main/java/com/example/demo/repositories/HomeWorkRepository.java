package com.example.demo.repositories;

import com.example.demo.models.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWork, Integer> {
}
