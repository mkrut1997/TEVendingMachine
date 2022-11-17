package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem{

    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public void getMessage() {
        System.out.println("Sugar, Sugar, so Sweet!");
    }
}
