package com.java.projects.miniecommercebackend.dto.product;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Builder
@Jacksonized
public record ProductSummary(
        Long id,
        String name,
        BigDecimal price,
        BigDecimal discountPrice,
        String imageUrl
) {}
