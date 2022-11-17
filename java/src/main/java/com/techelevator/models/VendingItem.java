package com.techelevator.models;

import java.math.BigDecimal;

public abstract class VendingItem {
    private String name;
    private BigDecimal price;
    private int quantity = 6;

    public VendingItem(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public abstract void getMessage();

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
