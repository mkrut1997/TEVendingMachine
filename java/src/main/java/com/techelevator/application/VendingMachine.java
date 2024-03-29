package com.techelevator.application;

import com.techelevator.models.AuditLog;
import com.techelevator.models.Inventory;
import com.techelevator.models.MachineBank;
import com.techelevator.models.VendingItem;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;


import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class VendingMachine 
{
    public void run()
    {
        MachineBank bank = new MachineBank();
        Inventory inventory = null;

        try{
            inventory = new Inventory("catering1.csv");
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
        AuditLog auditLog = new AuditLog(inventory);

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                UserOutput.displayMessage(inventory.getInventoryList());
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                while(true) {
                    String purchaseChoice = UserInput.getPurchaseOptions();
                    if(purchaseChoice.equals("0") || purchaseChoice.equals("1") || purchaseChoice.equals("5") || purchaseChoice.equals("10") || purchaseChoice.equals("20")){
                        auditLog.setBalanceBefore(bank.getBalance());
                        bank.setBalance(bank.getBalance().add( new BigDecimal(purchaseChoice)));
                        UserOutput.displayMessage(bank.displayMoneyProvided());
                        auditLog.setBalanceAfter(bank.getBalance());
                        auditLog.writeAuditMoneyFed();
                    }
                    else if(purchaseChoice.equals("select item")){
                        auditLog.setBalanceBefore(bank.getBalance());
                        UserOutput.displayMessage(inventory.getInventoryList());
                        String itemChoice = UserInput.getItemChoice();
                        if(inventory.getInventory().containsKey(itemChoice)){
                            VendingItem item = inventory.getInventory().get(itemChoice);
                            String nameOfItem = item.getName();
                            int quantity = item.getQuantity();
                            String itemMessage = item.getMessage();
                            if(quantity>0){
                                BigDecimal priceOfItem = bank.calculatePrice(item.getPrice());
                                if(bank.getBalance().compareTo(priceOfItem) >= 0){
                                    bank.updateSaleCounter();
                                    bank.setBalance(bank.getBalance().subtract(priceOfItem));
                                    UserOutput.displayMessage("Here is your " + nameOfItem + "!\nCost: $" + priceOfItem + "\nBalance remaining: $" + bank.getBalance() +"\n" + itemMessage);
                                    item.decrementQuantity();
                                }
                                else{
                                    UserOutput.displayMessage("INSUFFICIENT BALANCE: price of item is $" + priceOfItem + "!");
                                }
                            }
                            else{
                                UserOutput.displayMessage(nameOfItem + " IS NO LONGER AVAILABLE");
                            }
                        }
                        else {
                            UserOutput.displayMessage("ITEM CHOICE IS INVALID!");
                        }
                        auditLog.setBalanceAfter(bank.getBalance());
                        auditLog.writeAuditMoneyPurchase(itemChoice);
                    }
                    else if(purchaseChoice.equals("finish transaction")){
                        auditLog.setBalanceBefore(bank.getBalance());
                        UserOutput.displayMessage(bank.getChange());
                        auditLog.setBalanceAfter(bank.getBalance());
                        auditLog.writeAuditMoneyChangeGiven();
                        break;
                    }
                    else {
                        UserOutput.displayMessage("UNKNOWN ACTION: PLEASE ENTER A VALID MENU OPTION!");
                    }
                }
            }
            else if(choice.equals("exit"))
            {
                auditLog.writeAudit();
                // good bye
                break;
            }
        }
    }
    
}
