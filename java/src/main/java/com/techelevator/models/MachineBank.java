package com.techelevator.models;

import java.math.BigDecimal;

public class MachineBank {
    BigDecimal balance = new BigDecimal("0.00");

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
        String result = "Your change is: " + (dollars==0 ? "": dollars + " dollar(s), ") + (quarters==0? "" : quarters + " quarter(s), ") + (dimes==0 ? "" : dimes + " dime(s), ") + (nickels==0 ? "" : nickels + " nickel(s), ") + (pennies==0? "": pennies + " pennies, ");
        return result.substring(0,result.length()-2);
    }

    public void displayMoneyProvided() {

    }

    public void recordTransactions() {

    }
}
