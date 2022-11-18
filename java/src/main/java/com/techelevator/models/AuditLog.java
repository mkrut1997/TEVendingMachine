package com.techelevator.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuditLog {
    private LocalDateTime timeNow = LocalDateTime.now();
    private BigDecimal balanceBefore = new BigDecimal("0.00");
    private BigDecimal balanceAfter;
    private MachineBank machineBank;
    private Inventory inventory;


    public AuditLog(MachineBank machineBank, Inventory inventory ){
        this.machineBank = machineBank;
        this.inventory = inventory;
        balanceBefore = machineBank.getBalance();
        balanceAfter = machineBank.getBalance();
    }

    public String writeAuditMoneyFed(){
        balanceBefore = balanceAfter.subtract(balanceBefore);
        balanceAfter = machineBank.getBalance();
        return timeNow + " MONEY FED:            $" + balanceBefore + "   $" + balanceAfter;
    }

   


}
