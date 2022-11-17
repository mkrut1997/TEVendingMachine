package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends VendingItem{

    public Munchy(String name, BigDecimal price) {
        super(name, price);
    }


    @Override
    public void getMessage() {
        System.out.println("Munchy, Munchy, so Good!");
    }
}
