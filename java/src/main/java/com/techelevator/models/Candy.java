package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem{

    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getMessage() {
        return "Sugar, Sugar, so Sweet!";
    }
}
