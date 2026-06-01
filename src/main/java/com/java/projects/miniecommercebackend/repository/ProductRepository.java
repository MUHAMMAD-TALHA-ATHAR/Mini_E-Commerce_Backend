package com.java.projects.miniecommercebackend.repository;

import com.java.projects.miniecommercebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
