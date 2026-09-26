package com.naresh.introduction.exception;

/**
 * Custom business exception - a customer was not found.
 * GlobalExceptionHandler translates it into a 404 response.
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer not found with id: " + id);
    }
}