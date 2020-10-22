package com.codegym.service.Customer;

import com.codegym.model.Customer;
import com.codegym.service.IService;

public interface ICustomerService extends IService<Customer> {
    Iterable<Customer> findAllByNameContaining(String name);
}
