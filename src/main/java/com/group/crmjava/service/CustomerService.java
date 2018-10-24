package com.group.crmjava.service;

import com.group.crmjava.model.Customer;
import com.group.crmjava.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream().map(Customer::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findByLastNameIgnoreCase(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName).stream().map(Customer::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName) {
        return customerRepository.findByLastNameIgnoreCaseAndFirstNameIgnoreCase(lastName, firstName).stream().map(Customer::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(Long.parseLong(id)).map(Customer::new);
    }
}
