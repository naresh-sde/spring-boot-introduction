package com.naresh.introduction.dto;

/** Customer data accepted from API clients. */
public record CustomerRequest(
        String name,
        String email,
        String phone,
        boolean active) {
}