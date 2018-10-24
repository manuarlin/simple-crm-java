package com.group.crmjava.service;

import com.group.crmjava.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);

    Optional<Customer> findById(String id);
}
