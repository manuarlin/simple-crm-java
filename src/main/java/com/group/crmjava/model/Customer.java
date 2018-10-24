package com.group.crmjava.model;

import com.group.crmjava.entity.CustomerEntity;
import com.group.crmjava.entity.ProductEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Product> products;

    public Customer(CustomerEntity customerEntity) {
        this.id = customerEntity.getId();
        this.firstName = customerEntity.getFirstName();
        this.lastName = customerEntity.getLastName();
        this.products = mapListOfProduct(customerEntity.getProducts());
    }

    private List<Product> mapListOfProduct(List<ProductEntity> productEntities) {
        return productEntities.stream().map(Product::new).collect(Collectors.toList());
    }
}
