package com.naresh.introduction.repository;

import com.naresh.introduction.model.Customer;

import java.util.List;
import java.util.Optional;

// Data access contract used by the service layer.
public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}