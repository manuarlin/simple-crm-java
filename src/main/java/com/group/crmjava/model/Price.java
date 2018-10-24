package com.group.crmjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price implements Comparable<Price>{

    private Double amount;

    @Override
    public String toString() {
        return amount.toString();
    }

    public Price plus(Price price) {
        return new Price(amount + price.getAmount());
    }

    @Override
    public int compareTo(Price o) {
        return (int) (amount - o.getAmount());
    }
}
