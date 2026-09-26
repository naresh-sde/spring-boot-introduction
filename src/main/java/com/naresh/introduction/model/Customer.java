package com.naresh.introduction.model;

import java.time.LocalDateTime;

/**
 * Domain model. In production this would be a JPA/Hibernate entity
 * (see spring-data-jpa repo). Here a plain POJO keeps the intro focused.
 */
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private boolean active;
    private LocalDateTime createdAt;

    public Customer(Long id, String name, String email, String phone, boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}