package com.naresh.introduction.service;

import com.naresh.introduction.dto.CustomerRequest;
import com.naresh.introduction.dto.CustomerResponse;

import java.util.List;

/**
 * Business-logic contract. Controllers depend on this interface,
 * keeping web and business layers decoupled.
 */
public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    CustomerResponse getById(Long id);

    List<CustomerResponse> getAll();

    CustomerResponse update(Long id, CustomerRequest request);

    void delete(Long id);
}