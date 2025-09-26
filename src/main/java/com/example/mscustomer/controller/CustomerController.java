package com.example.mscustomer.controller;

import com.example.mscustomer.dto.request.CreateCustomerRequest;
import com.example.mscustomer.dto.request.UpdateCustomerRequest;
import com.example.mscustomer.dto.response.CustomerResponse;
import com.example.mscustomer.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/customer")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerController {
    CustomerService customerService;

    @PostMapping("/post")
    @ResponseStatus(CREATED)
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(OK)
    public CustomerResponse getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getAllCustomers")
    @ResponseStatus(OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(OK)
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest request) {
        return customerService.updateCustomer(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
    }
}