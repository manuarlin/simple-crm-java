package com.group.crmjava.repository;

import com.group.crmjava.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();
    List<CustomerEntity> findByLastNameIgnoreCase(String lastName);
    List<CustomerEntity> findByLastNameIgnoreCaseAndFirstNameIgnoreCase(String lastName, String firstName);
    Optional<CustomerEntity> findById(Long id);
}
