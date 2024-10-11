package com.example.supermarket_restapi.repository;

import com.example.supermarket_restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
