package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.MachineBank;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class VendingMachine 
{
    public void run()
    {
        MachineBank bank = new MachineBank();
        Inventory inventory = null;
        try{
            inventory = new Inventory("catering.csv");
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
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
                    if(purchaseChoice.equals("1") ||purchaseChoice.equals("5") ||purchaseChoice.equals("10") ||purchaseChoice.equals("20")){
                        bank.setBalance(bank.getBalance().add( new BigDecimal(purchaseChoice)));
                    }
                    else if(purchaseChoice.equals("select item")){
                        UserOutput.displayMessage(inventory.getInventoryList());
                        String itemChoice = UserInput.getItemChoice();
                        if(inventory.getInventory().containsKey(itemChoice)){
                            if(inventory.getInventory().get(itemChoice).getQuantity()>0){
                                BigDecimal priceOfItem = bank.calculatePrice(inventory.getInventory().get(itemChoice).getPrice());
                                if(bank.getBalance().compareTo(priceOfItem) >= 0){
                                    bank.updateSaleCounter();
                                    UserOutput.displayMessage("Here is your " + inventory.getInventory().get(itemChoice).getName() + "!");
                                    bank.setBalance(bank.getBalance().subtract(priceOfItem));
                                    UserOutput.displayMessage("Cost: $" + priceOfItem + "\nBalance remaining: $" + bank.getBalance());
                                    UserOutput.displayMessage(inventory.getInventory().get(itemChoice).getMessage());
                                    inventory.getInventory().get(itemChoice).decrementQuantity();

                                }
                                else{
                                    UserOutput.displayMessage("Insufficient balance: price of item is $" + inventory.getInventory().get(itemChoice).getPrice());
                                }
                            }
                            else{
                                UserOutput.displayMessage(inventory.getInventory().get(itemChoice).getName() + " IS NO LONGER AVAILABLE");
                            }
                        }
                        else{
                            UserOutput.displayMessage("Item choice is invalid");
                        }
                    }
                    UserOutput.displayMessage(bank.displayMoneyProvided());

                }
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
