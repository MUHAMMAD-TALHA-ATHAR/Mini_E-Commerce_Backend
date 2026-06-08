package com.java.projects.miniecommercebackend.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.projects.miniecommercebackend.enums.OrderStatus;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Jacksonized
public record OrderResponse(
        Long orderId,
        String trackingId,
        BigDecimal totalAmount,
        OrderStatus status,
        String shippingAddress,
        List<OrderItemResponse> items,

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime updatedAt

) {}