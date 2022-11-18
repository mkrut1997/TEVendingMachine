package com.techelevator.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private LocalDateTime timeNow = LocalDateTime.now();
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private MachineBank machineBank;
    private Inventory inventory;


    public AuditLog(MachineBank machineBank, Inventory inventory ){
        this.machineBank = machineBank;
        this.inventory = inventory;
        balanceBefore = machineBank.getBalance();
        balanceAfter = machineBank.getBalance();
    }

    public BigDecimal getBalanceBefore() {
        return balanceBefore;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceBefore(BigDecimal balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public String writeAuditMoneyFed(){
        timeNow = LocalDateTime.now();
        return timeNow.format(DATE_TIME_FORMAT) + "            MONEY FED: $" + balanceBefore + "   $" + balanceAfter;
    }

    public String writeAuditMoneyPurchase(String itemChoice){
        timeNow = LocalDateTime.now();
        return timeNow.format(DATE_TIME_FORMAT) + "            " + inventory.getInventory().get(itemChoice).getName() + "(" + itemChoice + ")" + ": $" + balanceBefore + "   $" + balanceAfter;
    }

    public String writeAuditMoneyChangeGiven(){
        timeNow = LocalDateTime.now();
        return timeNow.format(DATE_TIME_FORMAT) + "            CHANGE GIVEN: $" + balanceBefore + "   $" + balanceAfter;
    }
}
