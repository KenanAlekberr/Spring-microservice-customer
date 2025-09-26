package com.example.mscustomer.service.impl;

import com.example.mscustomer.dao.entity.CustomerEntity;
import com.example.mscustomer.dao.repository.CustomerRepository;
import com.example.mscustomer.dto.request.CreateCustomerRequest;
import com.example.mscustomer.dto.request.UpdateCustomerRequest;
import com.example.mscustomer.dto.response.CustomerResponse;
import com.example.mscustomer.exception.custom.NotFoundException;
import com.example.mscustomer.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.mscustomer.enums.Status.ACTIVE;
import static com.example.mscustomer.enums.Status.DELETED;
import static com.example.mscustomer.enums.Status.IN_PROGRESS;
import static com.example.mscustomer.exception.ExceptionConstants.CUSTOMER_NOT_FOUND;
import static com.example.mscustomer.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        CustomerEntity customerEntity = CUSTOMER_MAPPER.buildCustomerEntity(request);
        customerRepository.save(customerEntity);
        return CUSTOMER_MAPPER.buildCustomerResponse(customerEntity);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        CustomerEntity customer = fetchUserIfExist(id);

        return CUSTOMER_MAPPER.buildCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for (CustomerEntity customer : customerEntities) {
            if (customer.getStatus() == ACTIVE || customer.getStatus() == IN_PROGRESS)
                customerResponses.add(CUSTOMER_MAPPER.buildCustomerResponse(customer));
        }

        return customerResponses;
    }

    @Override
    public CustomerResponse updateCustomer(Long id, UpdateCustomerRequest request) {
        CustomerEntity customer = fetchUserIfExist(id);
        CUSTOMER_MAPPER.updateCustomer(customer, request);

        customerRepository.save(customer);

        return CUSTOMER_MAPPER.buildCustomerResponse(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        CustomerEntity customer = fetchUserIfExist(id);
        customer.setStatus(DELETED);
        customerRepository.save(customer);
    }

    private CustomerEntity fetchUserIfExist(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND.getCode(), CUSTOMER_NOT_FOUND.getMessage()));
    }
}