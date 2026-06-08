package com.java.projects.miniecommercebackend.dto.cart;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Jacksonized
public record CartResponse(
        Long cartId,
        BigDecimal totalAmount,
        Integer totalItems,
        List<CartItemResponse> items,

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime updatedAt

) {}
