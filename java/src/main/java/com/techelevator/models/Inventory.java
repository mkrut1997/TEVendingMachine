package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private String path;
    private Map<String,VendingItem> inventory = new HashMap<>();

    public Inventory(String path) throws FileNotFoundException{
        this.path = path;
        inventory = this.scanInventory();
    }

    public String getPath() {
        return path;
    }

    public Map<String, VendingItem> getInventory() {
        return inventory;
    }

    private Map<String, VendingItem> scanInventory() throws FileNotFoundException{
        File itemsToLoad = new File(path);
        try(Scanner inputFile = new Scanner(itemsToLoad)){
            while(inputFile.hasNextLine()){
                String itemFromList = inputFile.nextLine();
                this.createInventoryItem(itemFromList);
            }
        } catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
        return inventory;
    }

    private void createInventoryItem(String inventoryDescription) {
        String[] itemElementArray = inventoryDescription.split(",");
        String key = itemElementArray[0];
        String name = itemElementArray[1];
        BigDecimal price = new BigDecimal(itemElementArray[2]);
        if(itemElementArray[3].equals("Candy")){
            Candy candyItem = new Candy(name, price);
            inventory.put(key, candyItem);
        }
        if(itemElementArray[3].equals("Drink")){
            Drink drinkItem = new Drink(name, price);
            inventory.put(key, drinkItem);
        }
        if(itemElementArray[3].equals("Gum")){
            Gum gumItem = new Gum(name, price);
            inventory.put(key, gumItem);
        }
        if(itemElementArray[3].equals("Munchy")){
            Munchy munchyItem = new Munchy(name, price);
            inventory.put(key, munchyItem);
        }
    }

    public String getInventoryList() {
        String result = "";
        for (Map.Entry<String, VendingItem> item : inventory.entrySet()) {
            if (item.getValue().getQuantity() == 0) {
                result += "[" + item.getKey() + "] " + item.getValue().getName() + " ($" + item.getValue().getPrice() + "), SOLD OUT!" + "\n";
            }
            else {
                result += "[" + item.getKey() + "] " + item.getValue().getName() + " ($" + item.getValue().getPrice() + "), Remaining: " + item.getValue().getQuantity() + "\n";
            }
        }
        return result;
    }
}
