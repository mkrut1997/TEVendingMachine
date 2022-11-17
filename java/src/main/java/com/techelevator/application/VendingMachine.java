package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.MachineBank;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;

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
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
