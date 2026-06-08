package com.java.projects.miniecommercebackend.mapper;

import com.java.projects.miniecommercebackend.dto.product.ProductRequest;
import com.java.projects.miniecommercebackend.dto.product.ProductResponse;
import com.java.projects.miniecommercebackend.dto.product.ProductSummary;
import com.java.projects.miniecommercebackend.entity.Category;
import com.java.projects.miniecommercebackend.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request, Category category) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(category);
        product.setActive(true);
        return product;
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public ProductSummary toSummary(Product product, BigDecimal discountPrice) {
        return ProductSummary.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .discountPrice(discountPrice)
                .imageUrl(product.getImageUrl())
                .build();
    }
}