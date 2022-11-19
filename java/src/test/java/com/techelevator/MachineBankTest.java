package com.techelevator;

import com.techelevator.models.MachineBank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MachineBankTest {
    private MachineBank test = new MachineBank();

    @Test
    public void assert_change_is_properly_counted(){
        test.setBalance(new BigDecimal("3.44"));
        String expected = "Your change is: 3 dollars, 1 quarter, 1 dime, 1 nickel, 4 pennies";
        Assert.assertEquals(expected, test.getChange());
    }

    @Test
    public void assert_change_only_displays_coins_used(){
        test.setBalance(new BigDecimal("12.03"));
        String expected = "Your change is: 12 dollars, 3 pennies";
        Assert.assertEquals(expected, test.getChange());
    }

    @Test
    public void assert_discount_is_applied_when_sale_counter_is_odd(){
        test.updateSaleCounter();
        BigDecimal result = new BigDecimal("10.50");
        Assert.assertEquals(result, test.calculatePrice(new BigDecimal("11.50")));
    }

    @Test
    public void assert_no_discount_applied_when_counter_is_even(){
        test.updateSaleCounter();
        test.updateSaleCounter();
        BigDecimal result = new BigDecimal("11.50");
        Assert.assertEquals(result, test.calculatePrice(new BigDecimal("11.50")));
    }




}
