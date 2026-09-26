package com.naresh.introduction.exception;

// Thrown when no customer matches the given id.
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer not found with id: " + id);
    }
}