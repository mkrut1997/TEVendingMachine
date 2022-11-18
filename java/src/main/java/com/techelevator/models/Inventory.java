package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
//the method below scans our catering file, loops through it, and sends each item to the create inventory method to be loaded
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
//method below works with the method above. it basically builds each vending item and adds it to the inventory map
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
//this method returns a string of all the available items, their price, and the quantity remaining
    public String getInventoryList() {
        String result = "";
        //Tree map will sort the inventory Map by key for the user
        Map<String,VendingItem> sortedMap = new TreeMap<>(inventory);
        for (Map.Entry<String, VendingItem> item : sortedMap.entrySet()) {
            result += "[" + item.getKey() + "] " + item.getValue().getName() + " ($" + item.getValue().getPrice() + "), " + (item.getValue().getQuantity() == 0?"SOLD OUT!" : "Remaining: " + item.getValue().getQuantity()) +"\n";
        }
        return result;
    }
}
