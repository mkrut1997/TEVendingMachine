package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingItem{
    public Gum(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public void getMessage() {
        System.out.println("Chewy, Chewy, Lots O Bubbles!");
    }


}
