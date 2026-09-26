package com.naresh.introduction.repository;

import com.naresh.introduction.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Repository abstraction = data-access contract.
 * The service layer depends on THIS interface, not on a concrete store.
 * (Spring Data JPA replaces this with Spring Data repositories - see spring-data-jpa repo.)
 */
public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}