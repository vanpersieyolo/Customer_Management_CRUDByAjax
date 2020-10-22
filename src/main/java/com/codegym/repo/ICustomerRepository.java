package com.codegym.repo;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Iterable<Customer> findCustomerByNameContaining(String name);
}
