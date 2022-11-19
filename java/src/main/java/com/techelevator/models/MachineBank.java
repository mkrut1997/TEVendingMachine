package com.techelevator.models;

import java.math.BigDecimal;

public class MachineBank {
    private BigDecimal balance = new BigDecimal("0.00");
    private int saleCounter = 0;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getChange(){
        BigDecimal balanceInPennies = balance.multiply(new BigDecimal(100));
        int restOfChangePennies = balanceInPennies.intValue();
        int dollars = restOfChangePennies/100;
        restOfChangePennies -= 100 * dollars;
        int quarters = restOfChangePennies/25;
        restOfChangePennies -= 25 * quarters;
        int dimes = restOfChangePennies/10;
        restOfChangePennies -= 10 * dimes;
        int nickels = restOfChangePennies/5;
        restOfChangePennies -= 5*nickels;
        int pennies = restOfChangePennies;
        balance = new BigDecimal("0.00");
        String result = "Your change is: " + (dollars==0 ? "": (dollars==1 ? dollars + " dollar, " : dollars + " dollars, ")) + (quarters==0 ? "": (quarters==1 ? quarters + " quarter, " : quarters + " quarters, ")) + (dimes==0 ? "": (dimes==1 ? dimes + " dime, " : dimes + " dimes, ")) + (nickels==0 ? "": (nickels==1 ? nickels + " nickel, " : nickels + " nickels, ")) + (pennies==0 ? "": (pennies==1 ? pennies + " penny, " : pennies + " pennies, "));
        return result.substring(0,result.length()-2);
    }

    public String displayMoneyProvided() {
        return "Current Money Provided: $" + balance;

    }

    public void updateSaleCounter() {
        saleCounter++;
    }

    public BigDecimal calculatePrice(BigDecimal price){
        BigDecimal salePrice = price.subtract(new BigDecimal("1.00"));
        if(saleCounter%2==0){
            return price;
        }else{
            if(price.compareTo(new BigDecimal("1.00")) < 0){
                return new BigDecimal("0.00");
            }
            return salePrice;
        }

    }

}
