package com.naresh.introduction.repository.impl;

import com.naresh.introduction.model.Customer;
import com.naresh.introduction.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory implementation backed by a ConcurrentHashMap.
 * Keeps the intro dependency-free; swap in JPA later without touching callers.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<Long, Customer> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(idGenerator.getAndIncrement());
        }
        store.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Customer> findAll() {
        return List.copyOf(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return store.containsKey(id);
    }
}