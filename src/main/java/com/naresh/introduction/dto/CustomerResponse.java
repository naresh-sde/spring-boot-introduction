package com.naresh.introduction.dto;

import java.time.LocalDateTime;

/**
 * Response DTO - what the API returns to clients. Never expose the
 * internal model directly (decoupling + API contract stability).
 */
public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phone,
        boolean active,
        LocalDateTime createdAt) {
}