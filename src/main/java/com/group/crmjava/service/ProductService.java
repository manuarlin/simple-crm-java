package com.group.crmjava.service;

import com.group.crmjava.model.Product;
import com.group.crmjava.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(Long.parseLong(id)).map(Product::new);
    }
}
