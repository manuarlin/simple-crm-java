package com.group.crmjava.service;

import com.group.crmjava.model.Product;

import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(String id);
}
