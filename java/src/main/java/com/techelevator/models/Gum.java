package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingItem{
    public Gum(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getMessage() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }


}
