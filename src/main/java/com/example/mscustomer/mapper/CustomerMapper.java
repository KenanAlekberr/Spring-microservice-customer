package com.example.mscustomer.mapper;

import com.example.mscustomer.dao.entity.CustomerEntity;
import com.example.mscustomer.dto.request.CreateCustomerRequest;
import com.example.mscustomer.dto.request.UpdateCustomerRequest;
import com.example.mscustomer.dto.response.CustomerResponse;

import java.time.LocalDateTime;

import static com.example.mscustomer.enums.Status.ACTIVE;
import static com.example.mscustomer.enums.Status.IN_PROGRESS;

public enum CustomerMapper {
    CUSTOMER_MAPPER;

    public CustomerEntity buildCustomerEntity(CreateCustomerRequest request) {
        return CustomerEntity.builder().firstName(request.getFirstName()).lastName(request.getLastName()).status(ACTIVE).createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
    }

    public CustomerResponse buildCustomerResponse(CustomerEntity customer) {
        return CustomerResponse.builder().id(customer.getId()).firstName(customer.getFirstName()).lastName(customer.getLastName()).status(customer.getStatus()).createdAt(customer.getCreatedAt()).updatedAt(customer.getUpdatedAt()).build();
    }

    public void updateCustomer(CustomerEntity customer, UpdateCustomerRequest request) {
        if (request.getFirstName() != null && !request.getFirstName().isBlank())
            customer.setFirstName(request.getFirstName());

        if (request.getLastName() != null && !request.getLastName().isBlank())
            customer.setLastName(request.getLastName());

        customer.setStatus(IN_PROGRESS);
        customer.setUpdatedAt(LocalDateTime.now());
    }
}