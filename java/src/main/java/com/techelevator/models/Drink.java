package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends VendingItem{
    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }



}
