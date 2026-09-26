package com.naresh.introduction.service.impl;

import com.naresh.introduction.config.AppProperties;
import com.naresh.introduction.dto.CustomerRequest;
import com.naresh.introduction.dto.CustomerResponse;
import com.naresh.introduction.exception.CustomerNotFoundException;
import com.naresh.introduction.model.Customer;
import com.naresh.introduction.repository.CustomerRepository;
import com.naresh.introduction.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Customer business logic, with its dependencies injected through the constructor.
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final AppProperties appProperties;

    public CustomerServiceImpl(CustomerRepository customerRepository, AppProperties appProperties) {
        this.customerRepository = customerRepository;
        this.appProperties = appProperties;
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {
        Customer customer = new Customer(null, request.name(), request.email(),
                request.phone(), appProperties.features().autoApprove(), LocalDateTime.now());
        Customer saved = customerRepository.save(customer);
        log.debug("Customer created: id={}", saved.getId());
        return toResponse(saved);
    }

    @Override
    public CustomerResponse getById(Long id) {
        Customer customer = findCustomer(id);
        return toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer existing = findCustomer(id);
        existing.setName(request.name());
        existing.setEmail(request.email());
        existing.setPhone(request.phone());
        existing.setActive(request.active());
        return toResponse(customerRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        findCustomer(id);
        customerRepository.deleteById(id);
        log.debug("Customer deleted: id={}", id);
    }

    private Customer findCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    private CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail(),
                customer.getPhone(), customer.isActive(), customer.getCreatedAt());
    }
}