package com.naresh.introduction.dto;

/**
 * Request DTO - input contract for create/update operations.
 */
public record CustomerRequest(
        String name,
        String email,
        String phone,
        boolean active) {
}