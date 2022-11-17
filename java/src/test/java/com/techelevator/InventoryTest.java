package com.techelevator;

import com.techelevator.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest {
    private Inventory test = null;
    private Map<String, VendingItem> expected = new HashMap<>();

    @Before
    public void setup() {
        try {
            test = new Inventory("cateringTestFile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        expected.put("A1", new Gum("Hubba Bubba", new BigDecimal("1.50")));
        expected.put("A2", new Drink("Coke", new BigDecimal("2.00")));
        expected.put("A3", new Candy("Nerds", new BigDecimal("2.50")));
        expected.put("A4", new Munchy("Lays", new BigDecimal("3.00")));
    }

    @Test
    public void assert_inventory_names_are_created_correctly() {
        //Arrange
        //Act
        //Assert
        Assert.assertEquals("Inventory names are not correct!", expected.get("A1").getName(), test.getInventory().get("A1").getName());
    }

    @Test
    public void assert_inventory_prices_are_created_correctly() {
        //Arrange
        //Act
        //Assert
        Assert.assertEquals("Inventory prices are not correct!", expected.get("A2").getPrice(), test.getInventory().get("A2").getPrice());
    }

    @Test
    public void assert_inventory_quantities_are_created_correctly() {
        //Arrange
        //Act
        //Assert
        Assert.assertEquals("Inventory quantities are not correct!", 6, test.getInventory().get("A3").getQuantity());
    }

    @Test
    public void assert_display_inventory_is_correct() {
        //Arrange
        String expectedString = "";
        expectedString += "[A1] Hubba Bubba ($1.50), Remaining: 6\n";
        expectedString += "[A2] Coke ($2.00), Remaining: 6\n";
        expectedString += "[A3] Nerds ($2.50), Remaining: 6\n";
        expectedString += "[A4] Lays ($3.00), SOLD OUT!\n";
        test.getInventory().get("A4").setQuantity(0);
        //Act
        //Assert
        Assert.assertEquals("Inventory display is not correct!", expectedString, test.getInventoryList());
    }

}

