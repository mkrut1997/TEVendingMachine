package com.techelevator.ui;

import com.techelevator.models.MachineBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseOptions(){
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.print("\nPlease select an option: ");


        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if(option.equals("M")){
            System.out.print("Please enter dollar amount ($1, $5, $10, or $20): ");
            String dollarAmount = scanner.nextLine();
            if(dollarAmount.equals("1") ||dollarAmount.equals("5") ||dollarAmount.equals("10") ||dollarAmount.equals("20")) {
                return dollarAmount;
            }else{
                System.out.println("\nINVALID DOLLAR AMOUNT ENTERED!");
                return "0";
            }
        }
        else if(option.equals("S")){
            System.out.print("");
            return "select item";
        }
        else if(option.equals("F")){

            return "finish transaction";

        }
        else{
            return "";
        }
    }

    public static String getItemChoice(){
        System.out.print("Please enter the key for your item: ");
        String itemKey = scanner.nextLine();
        return itemKey;
    }

    
}
