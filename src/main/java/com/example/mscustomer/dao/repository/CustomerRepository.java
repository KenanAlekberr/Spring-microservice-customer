package com.example.mscustomer.dao.repository;

import com.example.mscustomer.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}