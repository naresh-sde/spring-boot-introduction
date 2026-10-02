package com.naresh.introduction.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/** Customer data accepted from API clients. */
public record CustomerRequest(
        @NotBlank(message = "name is required")
        String name,
        @NotBlank(message = "email is required")
        @Email(message = "email must be a well-formed address")
        String email,
        @NotBlank(message = "phone is required")
        @Pattern(regexp = "\\+?[0-9]{10,15}", message = "phone must be 10 to 15 digits, optionally starting with +")
        String phone,
        boolean active) {
}
