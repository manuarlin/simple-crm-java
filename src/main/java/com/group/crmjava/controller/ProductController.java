package com.group.crmjava.controller;

import com.group.crmjava.model.Product;
import com.group.crmjava.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    private IProductService productService;

    @RequestMapping("/products/{id}/price")
    public String findProductPriceById(@PathVariable String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        return optionalProduct.map(product -> "Le prix est de " + product.getPriceLabel()).orElse("Produit inconnu");
    }

}
