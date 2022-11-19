package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private LocalDateTime timeNow = LocalDateTime.now();
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private Inventory inventory;
    private File auditFile = new File("Audit.txt");
    private String auditText = "";


    public AuditLog(Inventory inventory ){
        this.inventory = inventory;

    }

    public void setBalanceBefore(BigDecimal balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public void writeAuditMoneyFed(){
        timeNow = LocalDateTime.now();
        auditText+= timeNow.format(DATE_TIME_FORMAT) + "            MONEY FED: $" + balanceBefore + "   $" + balanceAfter + "\n";
    }


    public void writeAuditMoneyPurchase(String itemChoice){
        timeNow = LocalDateTime.now();
        auditText += timeNow.format(DATE_TIME_FORMAT) + "            " + inventory.getInventory().get(itemChoice).getName() + "(" + itemChoice + ")" + ": $" + balanceBefore + "   $" + balanceAfter + "\n";
    }

    public void writeAuditMoneyChangeGiven(){
        timeNow = LocalDateTime.now();
        auditText += timeNow.format(DATE_TIME_FORMAT) + "            CHANGE GIVEN: $" + balanceBefore + "   $" + balanceAfter + "\n";
    }

    public void writeAudit(){
        try(PrintWriter writeAudit = new PrintWriter(auditFile)){
            writeAudit.print(auditText);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


}
