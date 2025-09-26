package com.example.mscustomer.service.abstraction;

import com.example.mscustomer.dto.request.CreateCustomerRequest;
import com.example.mscustomer.dto.request.UpdateCustomerRequest;
import com.example.mscustomer.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);

    CustomerResponse  getCustomerById(Long id);

    List<CustomerResponse> getAllCustomer();

    CustomerResponse updateCustomer(Long id, UpdateCustomerRequest request);

    void deleteCustomer(Long id);
}