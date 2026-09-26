package com.naresh.introduction.service;

import com.naresh.introduction.dto.CustomerRequest;
import com.naresh.introduction.dto.CustomerResponse;

import java.util.List;

// Business operations that the controller layer depends on.
public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    CustomerResponse getById(Long id);

    List<CustomerResponse> getAll();

    CustomerResponse update(Long id, CustomerRequest request);

    void delete(Long id);
}