package com.naresh.introduction.dto;

import java.time.LocalDateTime;

/** Customer data sent back to API clients. */
public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phone,
        boolean active,
        LocalDateTime createdAt) {
}