package com.group.crmjava.model;

import com.group.crmjava.entity.ProductEntity;
import lombok.Data;

@Data
public class Product {

    private Long id;
    private String description;
    private Price price;

    public Product(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice() != null ? new Price(productEntity.getPrice()) : null;
}

    public String getPriceLabel() {
        if (price != null) {
            return price.getAmount() + "€";
        }
        return "inconnu";
    }
}
