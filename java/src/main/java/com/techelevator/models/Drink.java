package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends VendingItem{
    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public void getMessage() {
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }



}
