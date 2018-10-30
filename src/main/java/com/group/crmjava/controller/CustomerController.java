package com.group.crmjava.controller;

import com.group.crmjava.model.Customer;
import com.group.crmjava.model.Price;
import com.group.crmjava.model.Product;
import com.group.crmjava.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {

    private ICustomerService customerService;

    @RequestMapping("/customers/{name}")
    public List<Customer> findCustomerByLastName(@PathVariable String name) {
        return customerService.findByLastNameIgnoreCase(name);
    }

    @RequestMapping("/customers/{lastName}/{firstName}")
    public List<Customer> findCustomerByLastNameAndFirstName(@PathVariable String lastName, @PathVariable String firstName) {
        return customerService.findByLastNameAndFirstName(lastName, firstName);
    }

    @RequestMapping("/customers/{id}/description")
    public String getCustomerDescription(@PathVariable String id) {
        String description  = "Inconnu";
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (optionalCustomer.isPresent()) {
            description = optionalCustomer.get().getFirstName() + " " + optionalCustomer.get().getLastName();
        }
        return description;
    }

    @RequestMapping("/customers/{id}/products")
    public List<Product> findProductsByCustomer(@PathVariable String id) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        return optionalCustomer.map(Customer::getProducts).orElse(new ArrayList<>());
    }

    @RequestMapping("/customers/{id}/total")
    public Price findTotalByCustomer(@PathVariable String id) {
        List<Product> products = findProductsByCustomer(id);
        Price totalPrice = new Price(0.0);
        for (Product product : products) {
            totalPrice = totalPrice.plus(product.getPrice());
        }
        return totalPrice;
    }

    @RequestMapping("/customers/totals")
    public List<Price> getTop() {
        List<Customer> customers = customerService.findAll();
        List<Price> totals = customers.stream().map((customer) -> findTotalByCustomer(customer.getId().toString()))
                .collect(Collectors.toList());
        return totals.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    }

}
